package c.a.r0.k2.c;

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

    /* renamed from: a  reason: collision with root package name */
    public View f21730a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f21731b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21732c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21733d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21734e;

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
        this.f21730a = null;
        this.f21731b = null;
        this.f21732c = null;
        this.f21733d = null;
        this.f21734e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f21730a = inflate;
        this.f21731b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f21732c = (TextView) this.f21730a.findViewById(R.id.zan_list_item_name);
        this.f21733d = (TextView) this.f21730a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f21730a.findViewById(R.id.zan_list_item_line_bottom);
        this.f21734e = imageView;
        imageView.setVisibility(0);
        this.f21730a.setTag(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21730a : (View) invokeV.objValue;
    }

    public void c(String str, String str2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.f21732c.setText(str);
            this.f21731b.setImageDrawable(null);
            this.f21733d.setText(StringHelper.getFormatTime(j2));
            this.f21731b.startLoad(str2, 28, false);
        }
    }
}
