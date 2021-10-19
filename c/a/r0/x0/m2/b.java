package c.a.r0.x0.m2;

import android.content.Intent;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f27275a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f27276b;

    /* renamed from: c  reason: collision with root package name */
    public int f27277c;

    /* renamed from: d  reason: collision with root package name */
    public a f27278d;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i2);
    }

    public b(g gVar, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27277c = 0;
        this.f27275a = gVar;
        this.f27276b = intent;
        e c2 = d.d().c(this.f27276b.getStringExtra("info_forum_name_text"));
        c2.b();
        c2.a();
        if (c2.c()) {
            ((RelativeLayout.LayoutParams) this.f27275a.f27302g.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27277c : invokeV.intValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f27278d = aVar;
        }
    }

    public abstract void c();

    public abstract void d();
}
