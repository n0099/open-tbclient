package c.a.p0.q3.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c.a.o0.r.t.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final int T;
    public static final int U;
    public static final int V;
    public transient /* synthetic */ FieldHolder $fh;
    public Context F;
    public LinearLayout G;
    public LinearLayout H;
    public View I;
    public View J;
    public String K;
    public boolean L;
    public boolean M;
    public l.d N;
    public l.d O;
    public l.d P;
    public l.d Q;
    public l.d R;
    public View.OnClickListener S;

    /* loaded from: classes2.dex */
    public class a extends ShareDialogItemView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context j;
        public EMTextView k;
        public LinearLayout.LayoutParams l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = context;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                super.a();
                addView(this.k, this.l);
                return this;
            }
            return (ShareDialogItemView) invokeV.objValue;
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.f35938b = new ImageView(this.j);
                setTag(Integer.valueOf(i));
                this.f35938b.setScaleType(ImageView.ScaleType.FIT_XY);
                WebPManager.setMaskDrawable(this.f35938b, i, null);
                b();
            }
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                EMTextView eMTextView = new EMTextView(this.j);
                this.k = eMTextView;
                eMTextView.setTextSize(0, ShareDialogItemView.i);
                this.k.setText(i);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0107);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                this.l = layoutParams;
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
                this.l.gravity = 1;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2097288859, "Lc/a/p0/q3/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2097288859, "Lc/a/p0/q3/g/b;");
                return;
            }
        }
        T = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
        U = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
        V = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, String str, boolean z, boolean z2, l.d dVar, l.d dVar2, l.d dVar3, l.d dVar4, l.d dVar5, View.OnClickListener onClickListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, Boolean.valueOf(z), Boolean.valueOf(z2), dVar, dVar2, dVar3, dVar4, dVar5, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.F = context;
        this.K = str;
        this.L = z;
        this.M = z2;
        this.N = dVar;
        this.O = dVar2;
        this.P = dVar3;
        this.Q = dVar4;
        this.R = dVar5;
        this.S = onClickListener;
        this.G = (LinearLayout) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0909a2);
        this.H = (LinearLayout) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091c59);
        d0();
    }

    @Override // c.a.p0.q3.g.d
    public boolean X() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.G.removeAllViews();
            this.H.removeAllViews();
            int i2 = 0;
            while (true) {
                if (i2 >= Math.min(6, this.f17690g.size())) {
                    break;
                }
                this.G.addView(this.f17690g.get(i2), new ViewGroup.LayoutParams(T, U));
                i2++;
            }
            this.G.addView(this.I, new ViewGroup.LayoutParams(V, -1));
            for (i = 6; i < this.f17690g.size(); i++) {
                this.H.addView(this.f17690g.get(i), new ViewGroup.LayoutParams(T, U));
            }
            this.H.addView(this.J, new ViewGroup.LayoutParams(V, -1));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17690g.clear();
            h(R.string.obfuscated_res_0x7f0f1127, new SvgMaskType(R.drawable.obfuscated_res_0x7f080820));
            h(R.string.obfuscated_res_0x7f0f112b, new SvgMaskType(R.drawable.obfuscated_res_0x7f080821));
            h(R.string.obfuscated_res_0x7f0f1148, new SvgMaskType(R.drawable.obfuscated_res_0x7f080823));
            a aVar = new a(this, this.F);
            aVar.d(R.drawable.obfuscated_res_0x7f080a20);
            aVar.setItemName(R.string.obfuscated_res_0x7f0f1149);
            aVar.e(R.string.obfuscated_res_0x7f0f114a);
            aVar.setOnClickListener(this);
            List<View> list = this.f17690g;
            aVar.a();
            list.add(aVar);
            h(R.string.obfuscated_res_0x7f0f114f, new SvgMaskType(R.drawable.obfuscated_res_0x7f08081f));
            h(R.string.obfuscated_res_0x7f0f1136, new SvgMaskType(R.drawable.obfuscated_res_0x7f080824));
            if (this.K != null) {
                g(R.string.obfuscated_res_0x7f0f0ce5, R.drawable.obfuscated_res_0x7f08098d);
            }
            LinearLayout u = u(R.string.obfuscated_res_0x7f0f1068, R.drawable.obfuscated_res_0x7f080988);
            u.setOnClickListener(this);
            u.setTag(-32040464);
            this.f17690g.add(u);
            if (this.L) {
                g(R.string.obfuscated_res_0x7f0f1067, R.drawable.obfuscated_res_0x7f080a13);
            }
            g(R.string.obfuscated_res_0x7f0f0899, R.drawable.obfuscated_res_0x7f080a15);
            if (this.M) {
                g(R.string.obfuscated_res_0x7f0f08ad, R.drawable.obfuscated_res_0x7f080a14);
            }
            this.I = new View(this.F);
            this.J = new View(this.F);
        }
    }

    @Override // c.a.p0.q3.g.d
    public void i(View view, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i, onClickListener) == null) {
            super.i(view, i, onClickListener);
        }
    }

    @Override // c.a.p0.q3.g.d, android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
            if (intValue == R.drawable.obfuscated_res_0x7f08098d) {
                l.d dVar = this.P;
                if (dVar != null) {
                    dVar.onClick();
                }
            } else if (intValue == -32040464) {
                l.d dVar2 = this.N;
                if (dVar2 != null) {
                    dVar2.onClick();
                }
            } else if (intValue == R.drawable.obfuscated_res_0x7f080a13) {
                l.d dVar3 = this.O;
                if (dVar3 != null) {
                    dVar3.onClick();
                }
            } else if (intValue == R.drawable.obfuscated_res_0x7f080a15) {
                l.d dVar4 = this.Q;
                if (dVar4 != null) {
                    dVar4.onClick();
                }
            } else if (intValue == R.drawable.obfuscated_res_0x7f080a14) {
                l.d dVar5 = this.R;
                if (dVar5 != null) {
                    dVar5.onClick();
                }
            } else if (intValue != R.drawable.obfuscated_res_0x7f080a20 || (onClickListener = this.S) == null) {
            } else {
                onClickListener.onClick(view);
            }
        }
    }

    @Override // c.a.p0.q3.g.d
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d03da, (ViewGroup) null) : (View) invokeV.objValue;
    }
}
