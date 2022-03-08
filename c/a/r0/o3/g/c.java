package c.a.r0.o3.g;

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
import c.a.r0.u2.h.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
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
    public o J;
    public View K;
    public View L;
    public View M;
    public View N;
    public TbImageView O;
    public LinearLayout P;
    public TbImageView Q;
    public TextView R;
    public View S;
    public ImageView T;
    public TextView U;
    public TextView V;
    public TbImageView W;
    public View X;
    public TextView Y;
    public TextView Z;
    public LinearLayout a0;
    public PlayVoiceBntNew b0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, boolean z, int i2, o oVar) {
        super(context, z, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2), oVar};
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
        this.J = oVar;
        this.K = this.f20398f.findViewById(R.id.pb_post_share_root_view);
        this.L = this.f20398f.findViewById(R.id.pb_post_share_card_container);
        this.M = this.f20398f.findViewById(R.id.pb_post_share_card);
        this.N = this.f20398f.findViewById(R.id.pb_post_share_card_content);
        this.O = (TbImageView) this.f20398f.findViewById(R.id.pb_post_share_title);
        this.P = (LinearLayout) this.f20398f.findViewById(R.id.pb_share_thread_container);
        TbImageView tbImageView = (TbImageView) this.f20398f.findViewById(R.id.pb_share_origin_thread_img);
        this.Q = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.Q.setConrers(15);
        this.Q.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.Q.setGifIconSupport(false);
        this.Q.setLongIconSupport(false);
        this.R = (TextView) this.f20398f.findViewById(R.id.origin_thread_abstract);
        this.S = this.f20398f.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.T = (ImageView) this.f20398f.findViewById(R.id.pb_post_share_video_play_iv);
        this.U = (TextView) this.f20398f.findViewById(R.id.post_share_screen_shot_title);
        this.V = (TextView) this.f20398f.findViewById(R.id.post_share_qcode_comment);
        this.W = (TbImageView) this.f20398f.findViewById(R.id.post_share_qcode);
        this.X = this.f20398f.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.Y = (TextView) this.f20398f.findViewById(R.id.post_share_reply_user_id);
        this.Z = (TextView) this.f20398f.findViewById(R.id.post_share_comment_text);
        this.a0 = (LinearLayout) this.f20398f.findViewById(R.id.post_share_comment_image_container);
        this.b0 = (PlayVoiceBntNew) this.f20398f.findViewById(R.id.post_share_comment_voice);
        e0(context, oVar.c().N());
        j0();
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.J == null) {
            return;
        }
        this.K.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.N, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.P.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.R, (int) R.color.CAM_X0107);
        this.R.setText(this.J.b());
        f0();
        SkinManager.setBackgroundColor(this.X, R.color.CAM_X0109);
        String name_show = this.J.c().t().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + "...";
        }
        this.Y.setText(name_show);
        SkinManager.setViewTextColor(this.Y, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.U, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.V, (int) R.color.CAM_X0105);
        this.W.setImageBitmap(this.J.d());
        SkinManager.setImageResource(this.O, R.drawable.pic_pb_post_share_logo);
        R(false);
        super.U();
    }

    public final void d0(Context context, List<TbRichTextImageInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, list) == null) {
            int i2 = 0;
            while (i2 < list.size() && i2 != 9) {
                this.a0.addView(g0(context, h0(list.get(i2), this.J.a()), list.get(i2), i2 == 0, this.J.a().r));
                i2++;
            }
        }
    }

    public void e0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, tbRichText) == null) || tbRichText == null || tbRichText.y() == null || tbRichText.y().isEmpty()) {
            return;
        }
        Iterator<TbRichTextData> it = tbRichText.y().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                int type = next.getType();
                if (type != 1) {
                    if (type == 512) {
                        this.b0.setVoiceModel((VoiceData.VoiceModel) next.M().y());
                        if (this.Z.getVisibility() == 0 || this.a0.getVisibility() == 0) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b0.getLayoutParams();
                            if (this.Z.getVisibility() == 0 && this.a0.getVisibility() == 8) {
                                layoutParams.topMargin = n.f(context, R.dimen.tbds39);
                            } else {
                                layoutParams.topMargin = n.f(context, R.dimen.tbds42);
                            }
                            this.b0.setLayoutParams(layoutParams);
                        }
                        this.b0.setVisibility(0);
                    }
                } else if (this.Z.getVisibility() == 8) {
                    SkinManager.setViewTextColor(this.Z, (int) R.color.CAM_X0105);
                    this.Z.setText(next.G());
                    this.Z.setVisibility(0);
                }
            }
        }
        if (tbRichText.A().isEmpty()) {
            return;
        }
        if (this.Z.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a0.getLayoutParams();
            layoutParams2.topMargin = n.f(context, R.dimen.tbds37);
            this.a0.setLayoutParams(layoutParams2);
        }
        this.a0.setVisibility(0);
        d0(context, tbRichText.A());
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int f2 = this.J.f();
            if (f2 == 0) {
                if (!StringUtils.isNull(this.J.e())) {
                    this.Q.startLoad(this.J.e(), 10, false);
                    return;
                }
                this.Q.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.Q.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f2 == 11) {
                this.Q.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.Q.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f2 != 40) {
            } else {
                this.S.setVisibility(0);
                this.T.setVisibility(0);
                this.T.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.S);
                this.Q.startLoad(this.J.e(), 10, false);
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
            if (tbRichTextImageInfo.E()) {
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(true);
            }
            tbImageView.setConrers(15);
            tbImageView.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            tbImageView.startLoad(str, z2 ? 17 : 18, false);
            return tbImageView;
        }
        return (TbImageView) invokeCommon.objValue;
    }

    public final String h0(TbRichTextImageInfo tbRichTextImageInfo, c.a.q0.e1.n.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, tbRichTextImageInfo, aVar)) == null) ? aVar.c() ? tbRichTextImageInfo.w() : tbRichTextImageInfo.y() : (String) invokeLL.objValue;
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

    public final int[] k0(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i2, i3, i4)) == null) {
            int[] iArr = new int[2];
            iArr[0] = i4;
            float f2 = (i2 * 1.0f) / (i4 * 1.0f);
            iArr[1] = (int) (f2 <= 1.0f ? i3 / f2 : i3 * f2);
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }

    @Override // c.a.r0.o3.g.d
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // c.a.r0.o3.g.d
    public ShareItem s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            ShareItem shareItem = this.y.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.s = "";
            shareItem.b0 = 1;
            shareItem.i(i0(this.L));
            shareItem.g();
            this.y.put(1, shareItem);
            return super.s(i2);
        }
        return (ShareItem) invokeI.objValue;
    }
}
