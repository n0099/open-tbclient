package com.baidu.nadcore.widget.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedVideoBaseView;
import com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView;
import com.baidu.nadcore.widget.uitemplate.NadRewardOperateView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f41;
import com.repackage.fm0;
import com.repackage.g41;
import com.repackage.m01;
import com.repackage.pi0;
import com.repackage.so0;
import com.repackage.y31;
import com.repackage.ym0;
import com.repackage.z31;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class NadRewardBaseView extends AdFeedVideoBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> j;
    public int k;
    public int l;
    public NadRewardOperateView m;
    public NadRewardCountDownView n;
    public g41 o;
    public boolean p;

    /* loaded from: classes2.dex */
    public class a implements f41.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardBaseView a;

        public a(NadRewardBaseView nadRewardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardBaseView;
        }

        @Override // com.repackage.f41.d
        public void a(List<fm0.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Toast.makeText(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0b8a, 0).show();
                this.a.p = true;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardBaseView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedVideoBaseView, com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.p) {
                Toast.makeText(getContext(), (int) R.string.obfuscated_res_0x7f0f0b8b, 0).show();
                if (this.d != null) {
                    this.d = null;
                    return;
                }
                return;
            }
            if (this.d == null) {
                if (!(getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.d = new f41(getContext(), (AdBaseModel) getTag());
            }
            this.d.h(new a(this));
            this.d.i();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            so0 so0Var = this.i;
            if (so0Var != null) {
                so0Var.release();
                this.i = null;
            }
            pi0 pi0Var = this.e;
            if (pi0Var != null) {
                pi0Var.j();
                this.e = null;
            }
            if (this.m != null) {
                this.m = null;
            }
            NadRewardCountDownView nadRewardCountDownView = this.n;
            if (nadRewardCountDownView != null) {
                nadRewardCountDownView.s();
                this.n = null;
            }
            WeakReference<Activity> weakReference = this.j;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.j.get().setRequestedOrientation(this.k);
            o();
        }
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            n(context);
        }
    }

    public void l() {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.j) == null || weakReference.get() == null) {
            return;
        }
        m01.a(this.j.get().getWindow());
    }

    public abstract void m(LayoutInflater layoutInflater, ym0 ym0Var);

    public abstract void n(Context context);

    public final void o() {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (weakReference = this.j) == null || weakReference.get() == null) {
            return;
        }
        View decorView = this.j.get().getWindow().getDecorView();
        decorView.setSystemUiVisibility(this.l);
        decorView.requestLayout();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent)) == null) {
            if (i == 4) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) {
            super.onVisibilityChanged(view2, i);
            if (i == 0) {
                l();
            }
        }
    }

    public final void q(AdBaseModel adBaseModel) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) || (viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091a6e)) == null) {
            return;
        }
        viewGroup.setVisibility(8);
        if (this.m == null) {
            this.m = new NadRewardOperateView(getContext());
        }
        this.m.update(adBaseModel);
        this.m.d(viewGroup);
        y31 y31Var = this.c;
        if (y31Var != null) {
            this.m.setViewDownloadListener(y31Var);
        }
        z31 z31Var = this.a;
        if (z31Var != null) {
            this.m.setFeedListener(z31Var);
        }
    }

    public void r(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) {
            NadRewardCountDownView nadRewardCountDownView = (NadRewardCountDownView) findViewById(R.id.obfuscated_res_0x7f0914b3);
            this.n = nadRewardCountDownView;
            if (nadRewardCountDownView == null) {
                return;
            }
            nadRewardCountDownView.update(adBaseModel);
        }
    }

    public abstract void s(AdBaseModel adBaseModel);

    public void setRewardMediaListener(g41 g41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, g41Var) == null) {
            this.o = g41Var;
        }
    }

    public abstract void t(AdBaseModel adBaseModel);

    @Override // com.baidu.nadcore.widget.feed.AdFeedVideoBaseView, com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adBaseModel) == null) {
            super.update(adBaseModel);
            s(adBaseModel);
            r(adBaseModel);
            q(adBaseModel);
            t(adBaseModel);
            requestFocus();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (ym0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i, ym0 ym0Var) {
        super(context, attributeSet, i, ym0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), ym0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (ym0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        m(LayoutInflater.from(context), ym0Var);
        k(context);
    }
}
