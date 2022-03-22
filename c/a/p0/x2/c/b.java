package c.a.p0.x2.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f20673b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20674c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20675d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f20676e;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f20673b = null;
        this.f20674c = null;
        this.f20675d = null;
        this.f20676e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08ef, (ViewGroup) null);
        this.a = inflate;
        this.f20673b = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0924d3);
        this.f20674c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0924d5);
        this.f20675d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0924d6);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0924d4);
        this.f20676e = imageView;
        imageView.setVisibility(0);
        this.a.setTag(this);
    }

    public static b b(Context context, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, view)) == null) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                return (b) view.getTag();
            }
            return new b(context);
        }
        return (b) invokeLL.objValue;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void c(String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.f20674c.setText(str);
            this.f20673b.setImageDrawable(null);
            this.f20675d.setText(StringHelper.getFormatTime(j));
            this.f20673b.J(str2, 28, false);
        }
    }
}
