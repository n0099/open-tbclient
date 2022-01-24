package c.a.t0.o3.g;

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
import c.a.t0.u3.g;
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
/* loaded from: classes8.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context C;
    public g D;
    public RoundRelativeLayout E;
    public TbImageView F;
    public TextView G;
    public TextView H;
    public RoundRelativeLayout I;
    public TbImageView J;
    public TextView K;
    public TextView L;
    public ImageView M;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, boolean z, int i2, g gVar) {
        super(context, z, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2), gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.C = context;
        this.D = gVar;
        Y();
        K(2);
    }

    @Override // c.a.t0.o3.g.d
    public void M(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // c.a.t0.o3.g.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20351f.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.D != null) {
                Z(this.F);
                this.J.setImageBitmap(this.D.a());
                this.G.setText(this.D.d());
            }
            WebPManager.setPureDrawable(this.M, R.drawable.icon_pure_scan_tip, R.color.CAM_X0101, null);
            c.a.s0.s.u.c.d(this.K).v(R.color.CAM_X0101);
            c.a.s0.s.u.c.d(this.L).v(R.color.CAM_X0101);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.G);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0102);
            c.a.s0.s.u.c.d(this.H).v(R.color.CAM_X0103);
            super.O();
        }
    }

    public final Bitmap X(View view) {
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

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.E = (RoundRelativeLayout) this.f20351f.findViewById(R.id.stamp_share_card_container);
            this.F = (TbImageView) this.f20351f.findViewById(R.id.stamp_icon);
            this.I = (RoundRelativeLayout) this.f20351f.findViewById(R.id.layout_stamp_share_qr);
            this.J = (TbImageView) this.f20351f.findViewById(R.id.stamp_share_qr);
            this.G = (TextView) this.f20351f.findViewById(R.id.stamp_share_card_title);
            this.H = (TextView) this.f20351f.findViewById(R.id.stamp_share_card_tip);
            this.K = (TextView) this.f20351f.findViewById(R.id.tv_stamp_scan_tip_top);
            this.L = (TextView) this.f20351f.findViewById(R.id.tv_stamp_scan_tip_down);
            this.M = (ImageView) this.f20351f.findViewById(R.id.img_stamp_scan_tip);
            a0();
            this.E.setRoundLayoutRadius(c.a.s0.s.u.a.y(R.string.J_X06));
            this.I.setRoundLayoutRadius(c.a.s0.s.u.a.y(R.string.J_X04));
        }
    }

    public final void Z(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        if (this.D.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_share_post_1_times);
        } else if (this.D.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.iocn_share_reply_1_times);
        } else if (this.D.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_share_post_7_times);
        } else if (this.D.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_share_reply_7_times);
        } else {
            tbImageView.startLoad(this.D.c(), 10, false);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int k = (n.k(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i2 = (k * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = i2;
            }
            this.E.setLayoutParams(layoutParams);
            int i3 = (k * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.F.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i3;
                layoutParams2.height = i3;
            }
            this.F.setLayoutParams(layoutParams2);
        }
    }

    @Override // c.a.t0.o3.g.d
    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.stamp_share_dialog_layout, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // c.a.t0.o3.g.d
    public ShareItem r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ShareItem shareItem = this.r.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.s = "";
            shareItem.b0 = 1;
            shareItem.i(X(this.E));
            shareItem.g();
            this.r.put(1, shareItem);
            return super.r(i2);
        }
        return (ShareItem) invokeI.objValue;
    }
}
