package c.a.p0.q3.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.w3.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context F;
    public g G;
    public RoundRelativeLayout H;
    public TbImageView I;
    public TextView J;
    public TextView K;
    public RoundRelativeLayout L;
    public TbImageView M;
    public TextView N;
    public TextView O;
    public ImageView P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, boolean z, int i, g gVar) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = context;
        this.G = gVar;
        e0();
        Q(2);
    }

    @Override // c.a.p0.q3.g.d
    public void S(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // c.a.p0.q3.g.d
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17685b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.G != null) {
                f0(this.I);
                this.M.setImageBitmap(this.G.a());
                this.J.setText(this.G.d());
            }
            WebPManager.setPureDrawable(this.P, R.drawable.obfuscated_res_0x7f08097e, R.color.CAM_X0101, null);
            c.a.o0.r.v.c.d(this.N).v(R.color.CAM_X0101);
            c.a.o0.r.v.c.d(this.O).v(R.color.CAM_X0101);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.J);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0102);
            c.a.o0.r.v.c.d(this.K).v(R.color.CAM_X0103);
            super.U();
        }
    }

    public final Bitmap d0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            if (view == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.H = (RoundRelativeLayout) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091d93);
            this.I = (TbImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091d92);
            this.L = (RoundRelativeLayout) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0911f8);
            this.M = (TbImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091d96);
            this.J = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091d95);
            this.K = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091d94);
            this.N = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f092212);
            this.O = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f092211);
            this.P = (ImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f090ed7);
            g0();
            this.H.setRoundLayoutRadius(c.a.o0.r.v.a.y(R.string.J_X06));
            this.L.setRoundLayoutRadius(c.a.o0.r.v.a.y(R.string.J_X04));
        }
    }

    public final void f0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        if (this.G.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a18);
        } else if (this.G.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080b8a);
        } else if (this.G.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a19);
        } else if (this.G.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a1c);
        } else {
            tbImageView.J(this.G.c(), 10, false);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int k = (n.k(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i = (k * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = i;
            }
            this.H.setLayoutParams(layoutParams);
            int i2 = (k * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.I.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
                layoutParams2.height = i2;
            }
            this.I.setLayoutParams(layoutParams2);
        }
    }

    @Override // c.a.p0.q3.g.d
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d07b3, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // c.a.p0.q3.g.d
    public ShareItem s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ShareItem shareItem = this.u.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.s = "";
            shareItem.b0 = 1;
            shareItem.i(d0(this.H));
            shareItem.g();
            this.u.put(1, shareItem);
            return super.s(i);
        }
        return (ShareItem) invokeI.objValue;
    }
}
