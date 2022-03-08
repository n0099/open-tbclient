package c.a.r0.b1.c;

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
import c.a.r0.y3.y;
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
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.FrsMemberHeaderViewHolder;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g extends c.a.r0.d1.k<h, FrsMemberHeaderViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public LikeModel x;
    public int y;
    public int z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f15109e;

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
            this.f15109e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    c.a.d.o.e.n z = this.f15109e.z(((Integer) tag).intValue());
                    if (z instanceof h) {
                        h hVar = (h) z;
                        if (view.getId() == R.id.like_btn) {
                            if (ViewHelper.checkUpIsLogin(this.f15109e.o.getPageActivity())) {
                                if (!c.a.d.f.p.l.z()) {
                                    this.f15109e.o.showToast(R.string.neterror);
                                    return;
                                }
                                String a = hVar.a();
                                this.f15109e.x.N(hVar.d(), a);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
                            String a2 = hVar.a();
                            this.f15109e.o.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(this.f15109e.f3076e, hVar.d(), a2)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof y) || this.a.x.getErrorCode() != 0) {
                    if (AntiHelper.m(this.a.x.getErrorCode(), this.a.x.getErrorString())) {
                        AntiHelper.u(this.a.o.getPageActivity(), this.a.x.getErrorString());
                        return;
                    } else {
                        this.a.o.showToast(this.a.x.getErrorString());
                        return;
                    }
                }
                y yVar = (y) obj;
                yVar.x(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, yVar));
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

    @Override // c.a.r0.d1.k, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        w0(i2, view, viewGroup, (h) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view;
    }

    public final int[] t0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    public final void u0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = this.o) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.x = likeModel;
        likeModel.setLoadDataCallBack(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: v0 */
    public FrsMemberHeaderViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            if (this.x == null) {
                u0();
            }
            return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.f3076e).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.A);
        }
        return (FrsMemberHeaderViewHolder) invokeL.objValue;
    }

    public View w0(int i2, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, frsMemberHeaderViewHolder})) == null) {
            super.S(i2, view, viewGroup, hVar, frsMemberHeaderViewHolder);
            if (hVar != null && hVar.e() != null) {
                int parseColor = Color.parseColor("#56cfa1");
                int color = SkinManager.getColor(R.color.CAM_X0109);
                y e2 = hVar.e();
                if (TbadkCoreApplication.isLogin()) {
                    if (e2.m() == 1) {
                        frsMemberHeaderViewHolder.mLikeButton.setVisibility(8);
                        frsMemberHeaderViewHolder.mLevelTipView.setVisibility(0);
                        frsMemberHeaderViewHolder.mLevelTipView.setText(R.string.mydegree);
                        SkinManager.setImageResource(frsMemberHeaderViewHolder.mLevelIcon, BitmapHelper.getSmallGradeResourceIdNew(e2.l()));
                        if (StringUtils.isNull(e2.h())) {
                            frsMemberHeaderViewHolder.mLevelNameView.setVisibility(8);
                        } else {
                            frsMemberHeaderViewHolder.mLevelNameView.setText(e2.h());
                            frsMemberHeaderViewHolder.mLevelNameView.setVisibility(0);
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        SpannableString spannableString = new SpannableString(e2.c() + "");
                        spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                        SpannableString spannableString2 = new SpannableString("/" + e2.i());
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
                if (this.y != e2.l() || this.z != e2.c()) {
                    this.y = e2.l();
                    this.z = e2.c();
                    frsMemberHeaderViewHolder.mLevelTopImage.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, t0(this.y)));
                    int c2 = e2.c();
                    this.z = c2;
                    if (c2 > e2.i()) {
                        this.z = e2.i();
                    }
                    float i3 = e2.i() != 0 ? this.z / e2.i() : 0.0f;
                    if (i3 > 0.999f) {
                        i3 = 1.0f;
                    }
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, i3, 1.0f, 1.0f);
                    scaleAnimation.setFillAfter(true);
                    scaleAnimation.setDuration(1000L);
                    c.a.r0.y3.a.c((TbPageContextSupport) this.o.getPageActivity(), frsMemberHeaderViewHolder.mLevelTopImage, scaleAnimation, null);
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
