package c.a.r0.o3.g;

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
import c.a.r0.u3.g;
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
    public Context J;
    public g K;
    public RoundRelativeLayout L;
    public TbImageView M;
    public TextView N;
    public TextView O;
    public RoundRelativeLayout P;
    public TbImageView Q;
    public TextView R;
    public TextView S;
    public ImageView T;

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
        this.J = context;
        this.K = gVar;
        e0();
        Q(2);
    }

    @Override // c.a.r0.o3.g.d
    public void S(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // c.a.r0.o3.g.d
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20398f.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.K != null) {
                f0(this.M);
                this.Q.setImageBitmap(this.K.a());
                this.N.setText(this.K.d());
            }
            WebPManager.setPureDrawable(this.T, R.drawable.icon_pure_scan_tip, R.color.CAM_X0101, null);
            c.a.q0.r.v.c.d(this.R).v(R.color.CAM_X0101);
            c.a.q0.r.v.c.d(this.S).v(R.color.CAM_X0101);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.N);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0102);
            c.a.q0.r.v.c.d(this.O).v(R.color.CAM_X0103);
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
            this.L = (RoundRelativeLayout) this.f20398f.findViewById(R.id.stamp_share_card_container);
            this.M = (TbImageView) this.f20398f.findViewById(R.id.stamp_icon);
            this.P = (RoundRelativeLayout) this.f20398f.findViewById(R.id.layout_stamp_share_qr);
            this.Q = (TbImageView) this.f20398f.findViewById(R.id.stamp_share_qr);
            this.N = (TextView) this.f20398f.findViewById(R.id.stamp_share_card_title);
            this.O = (TextView) this.f20398f.findViewById(R.id.stamp_share_card_tip);
            this.R = (TextView) this.f20398f.findViewById(R.id.tv_stamp_scan_tip_top);
            this.S = (TextView) this.f20398f.findViewById(R.id.tv_stamp_scan_tip_down);
            this.T = (ImageView) this.f20398f.findViewById(R.id.img_stamp_scan_tip);
            g0();
            this.L.setRoundLayoutRadius(c.a.q0.r.v.a.y(R.string.J_X06));
            this.P.setRoundLayoutRadius(c.a.q0.r.v.a.y(R.string.J_X04));
        }
    }

    public final void f0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        if (this.K.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_share_post_1_times);
        } else if (this.K.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.iocn_share_reply_1_times);
        } else if (this.K.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_share_post_7_times);
        } else if (this.K.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_share_reply_7_times);
        } else {
            tbImageView.startLoad(this.K.c(), 10, false);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int k = (n.k(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i2 = (k * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = i2;
            }
            this.L.setLayoutParams(layoutParams);
            int i3 = (k * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.M.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i3;
                layoutParams2.height = i3;
            }
            this.M.setLayoutParams(layoutParams2);
        }
    }

    @Override // c.a.r0.o3.g.d
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.stamp_share_dialog_layout, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // c.a.r0.o3.g.d
    public ShareItem s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ShareItem shareItem = this.y.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.s = "";
            shareItem.b0 = 1;
            shareItem.i(d0(this.L));
            shareItem.g();
            this.y.put(1, shareItem);
            return super.s(i2);
        }
        return (ShareItem) invokeI.objValue;
    }
}
