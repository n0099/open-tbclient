package c.a.p0.t0.c;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import c.a.p0.i3.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.FrsMemberHeaderViewHolder;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g extends c.a.p0.v0.k<h, FrsMemberHeaderViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public LikeModel x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24230e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24230e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    c.a.e.k.e.n z = this.f24230e.z(((Integer) tag).intValue());
                    if (z instanceof h) {
                        h hVar = (h) z;
                        if (view.getId() == R.id.like_btn) {
                            if (ViewHelper.checkUpIsLogin(this.f24230e.o.getPageActivity())) {
                                if (!c.a.e.e.p.j.z()) {
                                    this.f24230e.o.showToast(R.string.neterror);
                                    return;
                                }
                                String b2 = hVar.b();
                                this.f24230e.x.L(hVar.c(), b2);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
                            String b3 = hVar.b();
                            this.f24230e.o.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(this.f24230e.f2904e, hVar.c(), b3)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f24231a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24231a = gVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof w) || this.f24231a.x.getErrorCode() != 0) {
                    if (AntiHelper.m(this.f24231a.x.getErrorCode(), this.f24231a.x.getErrorString())) {
                        AntiHelper.u(this.f24231a.o.getPageActivity(), this.f24231a.x.getErrorString());
                        return;
                    } else {
                        this.f24231a.o.showToast(this.f24231a.x.getErrorString());
                        return;
                    }
                }
                w wVar = (w) obj;
                wVar.v(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = 0;
        this.z = 0;
        this.A = new a(this);
    }

    public final int[] B0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    public final void C0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.o) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.x = likeModel;
        likeModel.setLoadDataCallBack(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: D0 */
    public FrsMemberHeaderViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (this.x == null) {
                C0();
            }
            return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.f2904e).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.A);
        }
        return (FrsMemberHeaderViewHolder) invokeL.objValue;
    }

    public View E0(int i2, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, frsMemberHeaderViewHolder})) == null) {
            super.a0(i2, view, viewGroup, hVar, frsMemberHeaderViewHolder);
            if (hVar != null && hVar.d() != null) {
                int parseColor = Color.parseColor("#56cfa1");
                int color = SkinManager.getColor(R.color.CAM_X0109);
                w d2 = hVar.d();
                if (TbadkCoreApplication.isLogin()) {
                    if (d2.l() == 1) {
                        frsMemberHeaderViewHolder.mLikeButton.setVisibility(8);
                        frsMemberHeaderViewHolder.mLevelTipView.setVisibility(0);
                        frsMemberHeaderViewHolder.mLevelTipView.setText(R.string.mydegree);
                        SkinManager.setImageResource(frsMemberHeaderViewHolder.mLevelIcon, BitmapHelper.getSmallGradeResourceIdNew(d2.k()));
                        if (StringUtils.isNull(d2.h())) {
                            frsMemberHeaderViewHolder.mLevelNameView.setVisibility(8);
                        } else {
                            frsMemberHeaderViewHolder.mLevelNameView.setText(d2.h());
                            frsMemberHeaderViewHolder.mLevelNameView.setVisibility(0);
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        SpannableString spannableString = new SpannableString(d2.c() + "");
                        spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                        SpannableString spannableString2 = new SpannableString("/" + d2.i());
                        spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                        spannableStringBuilder.append((CharSequence) spannableString);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                        frsMemberHeaderViewHolder.mScoreView.setText(spannableStringBuilder);
                        frsMemberHeaderViewHolder.mScoreView.setVisibility(0);
                        frsMemberHeaderViewHolder.mLevelTopImage.setVisibility(0);
                        frsMemberHeaderViewHolder.mLevelTopImageBg.setVisibility(0);
                    } else {
                        frsMemberHeaderViewHolder.mLikeButton.setVisibility(0);
                        frsMemberHeaderViewHolder.mLevelTipView.setVisibility(8);
                        frsMemberHeaderViewHolder.mLevelIcon.setVisibility(8);
                        frsMemberHeaderViewHolder.mLevelNameView.setVisibility(8);
                        frsMemberHeaderViewHolder.mScoreView.setVisibility(8);
                        frsMemberHeaderViewHolder.mLevelTopImage.setVisibility(8);
                        frsMemberHeaderViewHolder.mLevelTopImageBg.setVisibility(8);
                    }
                } else {
                    frsMemberHeaderViewHolder.mLikeButton.setVisibility(8);
                    frsMemberHeaderViewHolder.mLevelTipView.setVisibility(8);
                    frsMemberHeaderViewHolder.mLevelIcon.setVisibility(8);
                    frsMemberHeaderViewHolder.mLevelNameView.setVisibility(8);
                    frsMemberHeaderViewHolder.mScoreView.setVisibility(8);
                    frsMemberHeaderViewHolder.mLevelTopImage.setVisibility(8);
                    frsMemberHeaderViewHolder.mLevelTopImageBg.setVisibility(8);
                }
                frsMemberHeaderViewHolder.mLikeButton.setTag(Integer.valueOf(i2));
                frsMemberHeaderViewHolder.mLevelNameView.setTag(Integer.valueOf(i2));
                frsMemberHeaderViewHolder.mLevelNameView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.rootForumMemberHeader, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.mDivider, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.headerDividerLine3, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.mLikeButton, R.drawable.frs_btn_like);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.mLikeButton, R.color.white_alpha100, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.mLevelTipView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.mLevelNameView, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(frsMemberHeaderViewHolder.tipExperience, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.mLevelTopImage, R.drawable.forum_member_exp_progress);
                SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.mLevelTopImageBg, R.color.CAM_X0204);
                if (this.y != d2.k() || this.z != d2.c()) {
                    this.y = d2.k();
                    this.z = d2.c();
                    frsMemberHeaderViewHolder.mLevelTopImage.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, B0(this.y)));
                    int c2 = d2.c();
                    this.z = c2;
                    if (c2 > d2.i()) {
                        this.z = d2.i();
                    }
                    float i3 = d2.i() != 0 ? this.z / d2.i() : 0.0f;
                    if (i3 > 0.999f) {
                        i3 = 1.0f;
                    }
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, i3, 1.0f, 1.0f);
                    scaleAnimation.setFillAfter(true);
                    scaleAnimation.setDuration(1000L);
                    c.a.p0.i3.a.b((TbPageContextSupport) this.o.getPageActivity(), frsMemberHeaderViewHolder.mLevelTopImage, scaleAnimation, null);
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.p0.v0.k, c.a.e.k.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        E0(i2, view, viewGroup, (h) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view;
    }
}
