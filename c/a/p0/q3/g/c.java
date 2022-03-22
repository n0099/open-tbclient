package c.a.p0.q3.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.w2.i.p;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p F;
    public View G;
    public View H;
    public View I;
    public View J;
    public TbImageView K;
    public LinearLayout L;
    public TbImageView M;
    public TextView N;
    public View O;
    public ImageView P;
    public TextView Q;
    public TextView R;
    public TbImageView S;
    public View T;
    public TextView U;
    public TextView V;
    public LinearLayout W;
    public PlayVoiceBntNew X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, boolean z, int i, p pVar) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), pVar};
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
        this.F = pVar;
        this.G = this.f17685b.findViewById(R.id.obfuscated_res_0x7f09171a);
        this.H = this.f17685b.findViewById(R.id.obfuscated_res_0x7f091718);
        this.I = this.f17685b.findViewById(R.id.obfuscated_res_0x7f091717);
        this.J = this.f17685b.findViewById(R.id.obfuscated_res_0x7f091719);
        this.K = (TbImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f09171b);
        this.L = (LinearLayout) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091722);
        TbImageView tbImageView = (TbImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091721);
        this.M = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.M.setConrers(15);
        this.M.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.M.setGifIconSupport(false);
        this.M.setLongIconSupport(false);
        this.N = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f09161d);
        this.O = this.f17685b.findViewById(R.id.obfuscated_res_0x7f091720);
        this.P = (ImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f09171c);
        this.Q = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0918c8);
        this.R = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0918c5);
        this.S = (TbImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0918c4);
        this.T = this.f17685b.findViewById(R.id.obfuscated_res_0x7f0918c7);
        this.U = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0918c6);
        this.V = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0918be);
        this.W = (LinearLayout) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0918bd);
        this.X = (PlayVoiceBntNew) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0918bf);
        e0(context, pVar.c().N());
        j0();
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.F == null) {
            return;
        }
        this.G.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.J, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.L.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.N, (int) R.color.CAM_X0107);
        this.N.setText(this.F.b());
        f0();
        SkinManager.setBackgroundColor(this.T, R.color.CAM_X0109);
        String name_show = this.F.c().s().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
        }
        this.U.setText(name_show);
        SkinManager.setViewTextColor(this.U, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.Q, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.R, (int) R.color.CAM_X0105);
        this.S.setImageBitmap(this.F.d());
        SkinManager.setImageResource(this.K, R.drawable.obfuscated_res_0x7f080f3b);
        R(false);
        super.U();
    }

    public final void d0(Context context, List<TbRichTextImageInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, list) == null) {
            int i = 0;
            while (i < list.size() && i != 9) {
                this.W.addView(g0(context, h0(list.get(i), this.F.a()), list.get(i), i == 0, this.F.a().r));
                i++;
            }
        }
    }

    public void e0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, tbRichText) == null) || tbRichText == null || tbRichText.A() == null || tbRichText.A().isEmpty()) {
            return;
        }
        Iterator<TbRichTextData> it = tbRichText.A().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                int type = next.getType();
                if (type != 1) {
                    if (type == 512) {
                        this.X.setVoiceModel((VoiceData.VoiceModel) next.O().A());
                        if (this.V.getVisibility() == 0 || this.W.getVisibility() == 0) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.X.getLayoutParams();
                            if (this.V.getVisibility() == 0 && this.W.getVisibility() == 8) {
                                layoutParams.topMargin = n.f(context, R.dimen.tbds39);
                            } else {
                                layoutParams.topMargin = n.f(context, R.dimen.tbds42);
                            }
                            this.X.setLayoutParams(layoutParams);
                        }
                        this.X.setVisibility(0);
                    }
                } else if (this.V.getVisibility() == 8) {
                    SkinManager.setViewTextColor(this.V, (int) R.color.CAM_X0105);
                    this.V.setText(next.I());
                    this.V.setVisibility(0);
                }
            }
        }
        if (tbRichText.C().isEmpty()) {
            return;
        }
        if (this.V.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.W.getLayoutParams();
            layoutParams2.topMargin = n.f(context, R.dimen.tbds37);
            this.W.setLayoutParams(layoutParams2);
        }
        this.W.setVisibility(0);
        d0(context, tbRichText.C());
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int f2 = this.F.f();
            if (f2 == 0) {
                if (!StringUtils.isNull(this.F.e())) {
                    this.M.J(this.F.e(), 10, false);
                    return;
                }
                this.M.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080890));
                this.M.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f2 == 11) {
                this.M.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080891));
                this.M.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f2 != 40) {
            } else {
                this.O.setVisibility(0);
                this.P.setVisibility(0);
                this.P.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080892));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.O);
                this.M.J(this.F.e(), 10, false);
            }
        }
    }

    public final TbImageView g0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{context, str, tbRichTextImageInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] k0 = k0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), n.f(TbadkCoreApplication.getInst(), R.dimen.tbds981));
            TbImageView tbImageView = new TbImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(k0[0], k0[1]);
            if (!z) {
                layoutParams.setMargins(0, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (tbRichTextImageInfo.G()) {
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(true);
            }
            tbImageView.setConrers(15);
            tbImageView.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            tbImageView.J(str, z2 ? 17 : 18, false);
            return tbImageView;
        }
        return (TbImageView) invokeCommon.objValue;
    }

    public final String h0(TbRichTextImageInfo tbRichTextImageInfo, c.a.o0.e1.n.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, tbRichTextImageInfo, aVar)) == null) ? aVar.c() ? tbRichTextImageInfo.y() : tbRichTextImageInfo.A() : (String) invokeLL.objValue;
    }

    public final Bitmap i0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            if (view == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
            createBitmap.eraseColor(SkinManager.getColor(R.color.CAM_X0206));
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final int[] k0(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            int[] iArr = new int[2];
            iArr[0] = i3;
            float f2 = (i * 1.0f) / (i3 * 1.0f);
            iArr[1] = (int) (f2 <= 1.0f ? i2 / f2 : i2 * f2);
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }

    @Override // c.a.p0.q3.g.d
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0699, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // c.a.p0.q3.g.d
    public ShareItem s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            ShareItem shareItem = this.u.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.s = "";
            shareItem.b0 = 1;
            shareItem.i(i0(this.H));
            shareItem.g();
            this.u.put(1, shareItem);
            return super.s(i);
        }
        return (ShareItem) invokeI.objValue;
    }
}
