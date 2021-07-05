package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m extends j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2043a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2044b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f2045c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, WebViewWindow webViewWindow, String str) {
        super(jVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, webViewWindow, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((j) objArr2[0], (k) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2045c = jVar;
        this.f2043a = webViewWindow;
        this.f2044b = str;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        WebViewWindow webViewWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
            this.f2045c.removeView(this.f2043a);
            webViewWindow = this.f2045c.x;
            webViewWindow.a(this.f2044b);
            this.f2045c.v = false;
        }
    }
}
