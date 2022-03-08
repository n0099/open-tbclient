package c.a.r0.u2.k;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.c1.o0;
import c.a.q0.r.r.e2;
import c.a.q0.r.v.c;
import c.a.q0.t.g;
import c.a.r0.f0.m;
import c.a.r0.u2.h.f;
import c.a.r0.u2.k.f.s0;
import c.a.r0.u2.p.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23183b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23184e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f23185f;

        public a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23184e = pbCommenFloorItemViewHolder;
            this.f23185f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.f23184e.ownerInfoRootView.getMeasuredWidth();
                String str = this.f23185f;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.f23184e;
                s0.a(measuredWidth, str, pbCommenFloorItemViewHolder.mUserNameView, pbCommenFloorItemViewHolder.mFloorAuthorView, pbCommenFloorItemViewHolder.mForumLevelIcon, pbCommenFloorItemViewHolder.mTshowIconBox, pbCommenFloorItemViewHolder.mVipIconBox);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1031188868, "Lc/a/r0/u2/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1031188868, "Lc/a/r0/u2/k/b;");
                return;
            }
        }
        new SparseArray();
        a = new SparseIntArray();
        f23183b = i(R.dimen.tbds16);
    }

    public static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65537, null, tbRichTextView, view, z) == null) || tbRichTextView == null || view == null) {
            return;
        }
        int k = (((n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int i2 = k - (z ? i(R.dimen.tbds90) : 0);
        tbRichTextView.getLayoutStrategy().q(i2);
        tbRichTextView.getLayoutStrategy().G = i2 - i(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public static void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, pbCommenFloorItemViewHolder, postData, z) == null) {
            if (!TextUtils.isEmpty(postData.u()) && z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
                layoutParams.topMargin = i(R.dimen.ds20);
                layoutParams.bottomMargin = i(R.dimen.ds20);
                pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.mRichTextView.startLoad(postData.u());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.mRichTextView.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.mRichTextView.startLoad(null);
            }
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewCheckSelection(false);
        }
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{pbCommenFloorItemViewHolder, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (imageView = pbCommenFloorItemViewHolder.mShareView) == null || postData == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(8);
            if (z) {
                pbCommenFloorItemViewHolder.mBottomCommentText.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
                return;
            }
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public static void d(c.a.r0.u2.k.a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, e2 e2Var) {
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, pbCommenFloorItemViewHolder, postData, e2Var) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && e2Var != null && !e2Var.U1()) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.mFloorNum.setVisibility(0);
            pbCommenFloorItemViewHolder.mFloorNum.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.mFloorNum.setVisibility(8);
            z = false;
        }
        g K = postData.K();
        z2 = (K == null || StringUtils.isNull(K.b()) || e2Var == null || e2Var.U1()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.mPointRightFloor.setVisibility(0);
            i2 = f23183b;
        } else {
            pbCommenFloorItemViewHolder.mPointRightFloor.setVisibility(8);
            i2 = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.mPointRightPostTime.setVisibility(0);
            i3 = f23183b;
        } else {
            pbCommenFloorItemViewHolder.mPointRightPostTime.setVisibility(8);
            i3 = 0;
        }
        pbCommenFloorItemViewHolder.mReplyTimeView.setPadding(i2, 0, i3, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.V()), "yyyy"))) {
            pbCommenFloorItemViewHolder.mReplyTimeView.setText(StringHelper.getFormatTimeShort(postData.V()));
        } else {
            pbCommenFloorItemViewHolder.mReplyTimeView.setText(StringHelper.getFormatTime(postData.V()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.mLocationView.setVisibility(0);
            pbCommenFloorItemViewHolder.mLocationView.setPadding(f23183b, 0, 0, 0);
            pbCommenFloorItemViewHolder.mLocationView.setText(K.b());
            return;
        }
        pbCommenFloorItemViewHolder.mLocationView.setVisibility(8);
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, e2 e2Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbCommenFloorItemViewHolder, postData, e2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        if (e2Var != null) {
            postData.q().threadId = e2Var.w1();
            postData.q().forumId = String.valueOf(e2Var.U());
        }
        if (i2 == 0) {
            postData.q().objType = 1;
        } else {
            postData.q().objType = 2;
        }
        postData.q().isInPost = true;
        if (z) {
            pbCommenFloorItemViewHolder.mBottomAgreeView.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.mBottomAgreeView.setData(postData.q());
        }
        if (e2Var != null && e2Var.H2()) {
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.mPbFloorPraiseView.setData(postData.q());
    }

    public static void f(c.a.r0.u2.k.a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{aVar, pbCommenFloorItemViewHolder, postData, view, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), sVar}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        Activity pageActivity = aVar.getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = n.f(pageActivity, R.dimen.M_W_X007);
        layoutParams.leftMargin = n.f(pageActivity, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        if (z) {
            pbCommenFloorItemViewHolder.mRichTextView.startLoad(null);
            pbCommenFloorItemViewHolder.mRichTextView.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().x(R.drawable.pic_video);
        a(pbCommenFloorItemViewHolder.mRichTextView, view, !StringUtils.isNull(postData.u()));
        pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.mRichTextView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.mRichTextView.setIsFromCDN(z2);
        pbCommenFloorItemViewHolder.mRichTextView.setText(postData.N(), true, sVar);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.mRichTextView.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
        pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
        pbCommenFloorItemViewHolder.pbItemViewRoot.setTag(R.id.tag_from, sparseArray);
    }

    public static void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.S() != null) {
                TbRichText N = postData.N();
                h.c(postData.S(), pbCommenFloorItemViewHolder.mTailContent, false, false, N != null && StringUtils.isNull(N.toString()) && StringUtils.isNull(postData.u()));
                return;
            }
            pbCommenFloorItemViewHolder.mTailContent.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2, c.a.r0.u2.k.a aVar, e2 e2Var, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{pbCommenFloorItemViewHolder, postData, view, Integer.valueOf(i2), aVar, e2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.t() != null) {
            postData.t().isBaijiahaoUser();
        }
        boolean z8 = false;
        if (postData.T) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
        }
        String userId = (e2Var == null || e2Var.J() == null) ? null : e2Var.J().getUserId();
        pbCommenFloorItemViewHolder.mHeadPhotoView.setTag(null);
        pbCommenFloorItemViewHolder.mHeadPhotoView.setUserId(null);
        pbCommenFloorItemViewHolder.mUserNameView.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.mRichTextView.setIsHost(false);
        if (postData.t() != null) {
            if (userId != null && !userId.equals("0") && userId.equals(postData.t().getUserId())) {
                pbCommenFloorItemViewHolder.mRichTextView.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.t().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.t().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.mTshowIconBox;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, postData.t().getUserId());
                pbCommenFloorItemViewHolder.mTshowIconBox.setOnClickListener(aVar.getEventController().f23481c);
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.mTshowIconBox;
                i3 = R.id.tag_user_id;
                userIconBox2.loadIcon(iconInfo, 2, f2, f2, f3);
            } else {
                i3 = R.id.tag_user_id;
            }
            if (pbCommenFloorItemViewHolder.mVipIconBox != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.mVipIconBox.setTag(tShowInfoNew.get(0).getUrl());
                }
                pbCommenFloorItemViewHolder.mVipIconBox.setOnClickListener(aVar.getEventController().f23482d);
                int f4 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.mVipIconBox.loadIcon(tShowInfoNew, 3, f4, f4, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.t().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        s0.k(pbCommenFloorItemViewHolder.mUserNameView);
                    } else {
                        c.d(pbCommenFloorItemViewHolder.mUserNameView).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0106, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0301, 1);
            }
            String avater = postData.t().getAvater();
            pbCommenFloorItemViewHolder.mUserNameView.setTag(i3, postData.t().getUserId());
            pbCommenFloorItemViewHolder.mUserNameView.setTag(R.id.tag_user_name, postData.t().getUserName());
            pbCommenFloorItemViewHolder.mUserNameView.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
            String name_show = postData.t().getName_show();
            String userName = postData.t().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.mUserNameView.setText(c.a.r0.u2.c.b(aVar.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.mUserNameView.getText().toString()));
                pbCommenFloorItemViewHolder.mUserNameView.setGravity(16);
                pbCommenFloorItemViewHolder.mUserNameView.setTag(R.id.tag_nick_name_activity, c.a.r0.u2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0312, 1);
            }
            if (postData.t().getPendantData() != null && !StringUtils.isNull(postData.t().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.mPendantHeadView.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.mPendantHeadView.showHeadPendantAndBigV(postData.t(), 4);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setVisibility(8);
                pbCommenFloorItemViewHolder.mPendantHeadView.setVisibility(0);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserName(postData.t().getUserName());
                pbCommenFloorItemViewHolder.mPendantHeadView.startLoadPendantUrl(postData.t().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.mHeadPhotoView.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.mHeadPhotoView, postData.t(), 4);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setUserName(postData.t().getUserName(), postData.X());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setImageDrawable(null);
                pbCommenFloorItemViewHolder.mHeadPhotoView.startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setVisibility(0);
                pbCommenFloorItemViewHolder.mPendantHeadView.setVisibility(8);
            }
            m(pbCommenFloorItemViewHolder.mFloorAuthorView, postData, userId, e2Var);
        }
        int level_id = (!aVar.isSimpleForum() || postData.t() == null) ? 0 : postData.t().getLevel_id();
        if (e2Var != null && e2Var.H2()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.mForumLevelIcon.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.mForumLevelIcon, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.mForumLevelIcon.setVisibility(8);
        }
        if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() != 1) {
            pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount();
        }
        pbCommenFloorItemViewHolder.mFloorAuthorView.getVisibility();
        pbCommenFloorItemViewHolder.mVipIconBox.getChildCount();
        int e2 = s0.e();
        String name_show2 = postData.t() != null ? postData.t().getName_show() : "";
        int d2 = o0.d(name_show2);
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            int i4 = e2 - 2;
            if (d2 > i4) {
                name_show2 = o0.n(name_show2, i4) + "...";
            }
        } else if (d2 > e2) {
            name_show2 = o0.n(name_show2, e2) + "...";
        }
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            pbCommenFloorItemViewHolder.mUserNameView.setText(j(aVar, postData.t().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.mUserNameView.setText(name_show2);
            pbCommenFloorItemViewHolder.ownerInfoRootView.post(new a(pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.G());
        boolean z9 = (postData.t() == null || StringUtils.isNull(postData.t().getVirtualUserUrl())) ? false : true;
        if (e2Var == null || aVar.getUserIdentify() == 0 || k(e2Var)) {
            z3 = false;
            z4 = false;
        } else {
            z3 = (aVar.getUserIdentify() == 1002 || aVar.getUserIdentify() == 3) ? false : true;
            z4 = (aVar.getUserIdentify() == 3 || e2Var.U1()) ? false : true;
            if (postData != null && postData.t() != null) {
                String userId2 = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z3 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z3 = false;
                }
            }
        }
        if (e2Var != null && e2Var.J() != null && postData.t() != null) {
            String userId3 = e2Var.J().getUserId();
            String userId4 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId3)) {
                if (UtilHelper.isCurrentAccount(userId4)) {
                    z5 = false;
                    z4 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData != null && postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z9) {
                    z3 = false;
                    z5 = false;
                    z4 = false;
                }
                int i5 = postData.A() != 1 ? 0 : 1;
                if (e2Var != null && e2Var.H2()) {
                    z3 = false;
                    z5 = false;
                }
                if (!z3) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.getUserIdentify()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                    }
                    sparseArray.put(R.id.tag_user_mute_thread_id, e2Var.h0());
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.G());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z4 && e2Var != null) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.getUserIdentify()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                    sparseArray.put(R.id.tag_del_post_id, postData.G());
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf((z2 || postData.b0()) ? true : true));
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
                if (z) {
                    return;
                }
                pbCommenFloorItemViewHolder.mFeedBackImg.setTag(sparseArray);
                return;
            }
        }
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData != null) {
            z4 = true;
            z6 = true;
        }
        if (z9) {
        }
        if (postData.A() != 1) {
        }
        if (e2Var != null) {
            z3 = false;
            z5 = false;
        }
        if (!z3) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
        if (z) {
        }
    }

    public static int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            int i3 = a.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
            a.put(i2, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public static SpannableStringBuilder j(c.a.r0.u2.k.a aVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, aVar, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.h(aVar.getPageContext().getPageActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static boolean k(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, e2Var)) == null) {
            if (e2Var == null) {
                return false;
            }
            return e2Var.W1();
        }
        return invokeL.booleanValue;
    }

    public static void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65548, null, pbCommenFloorItemViewHolder, fVar, z) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    s0.k(pbCommenFloorItemViewHolder.mUserNameView);
                } else {
                    c.d(pbCommenFloorItemViewHolder.mUserNameView).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0106, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyTimeView, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mPointRightFloor, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mPointRightPostTime, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mFloorNum, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mLocationView, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.mRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.mImagesView.onChangeSkinType();
            if (z) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(pbCommenFloorItemViewHolder.mFeedBackImg, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mBottomCommentImg, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mBottomShareImg, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mBottomShareText, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mBottomCommentText, (int) R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mCommentView, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mShareView, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (fVar != null) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyCountView, (int) R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.mReplyCountView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0108), null), (Drawable) null);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyView, (int) R.color.CAM_X0108);
                SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.mReplyContentView, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                pbCommenFloorItemViewHolder.mReplyContentView.onChangeSkinType();
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mRecommendLiveTitleView, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mRecommendLivePrefixTv, R.color.CAM_X0106, 1);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.mRecommendLiveLayout, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.mRecommendLiveDividerView, R.color.CAM_X0109);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.mRecommendLiveArrowView, R.drawable.icon_arrow_more_gray);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mFoldTitleView, (int) R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.mAllContent.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.mReplyCountView.setVisibility(8);
                    pbCommenFloorItemViewHolder.mReplyView.setVisibility(8);
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(R.string.close_content);
                } else if (StringUtils.isNull(fVar.k())) {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(fVar.k());
                } else {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(R.string.expand_content);
                }
            } else {
                pbCommenFloorItemViewHolder.mReplyContentView.setVisibility(8);
                pbCommenFloorItemViewHolder.mReplyCountView.setVisibility(8);
                pbCommenFloorItemViewHolder.mReplyView.setVisibility(8);
                pbCommenFloorItemViewHolder.mRecommendLiveLayout.setVisibility(8);
                pbCommenFloorItemViewHolder.mFoldTitleView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void m(TextView textView, PostData postData, String str, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, textView, postData, str, e2Var) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            if (e2Var != null && e2Var.H2()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                if (str != null && !str.equals("0") && str.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c d2 = c.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.c0()) {
                    c d3 = c.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    c d4 = c.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    c d5 = c.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    c d6 = c.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    c d7 = c.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
