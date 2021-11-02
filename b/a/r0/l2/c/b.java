package b.a.r0.l2.c;

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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f20488a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f20489b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20490c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20491d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f20492e;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20488a = null;
        this.f20489b = null;
        this.f20490c = null;
        this.f20491d = null;
        this.f20492e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f20488a = inflate;
        this.f20489b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f20490c = (TextView) this.f20488a.findViewById(R.id.zan_list_item_name);
        this.f20491d = (TextView) this.f20488a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f20488a.findViewById(R.id.zan_list_item_line_bottom);
        this.f20492e = imageView;
        imageView.setVisibility(0);
        this.f20488a.setTag(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20488a : (View) invokeV.objValue;
    }

    public void c(String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.f20490c.setText(str);
            this.f20489b.setImageDrawable(null);
            this.f20491d.setText(StringHelper.getFormatTime(j));
            this.f20489b.startLoad(str2, 28, false);
        }
    }
}
