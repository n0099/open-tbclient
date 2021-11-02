package b.a.p0.h.o0.g.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.p0.f.e;
import b.a.p0.f.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f10668a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDraweeView f10669b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10670c;

    @SuppressLint({"InflateParams"})
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
        View inflate = LayoutInflater.from(context).inflate(f.swangame_recommend_button, (ViewGroup) null);
        this.f10668a = inflate;
        this.f10669b = (SimpleDraweeView) inflate.findViewById(e.swangame_recommend_button_icon);
        this.f10670c = (TextView) this.f10668a.findViewById(e.swangame_recommend_button_name);
    }
}
