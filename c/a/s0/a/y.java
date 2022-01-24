package c.a.s0.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.s0.a.e;
import c.a.s0.d1.s0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.CardDialog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile y f12330b;
    public transient /* synthetic */ FieldHolder $fh;
    public CardDialog a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserData f12331e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f12332f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ y f12333g;

        public a(y yVar, UserData userData, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, userData, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12333g = yVar;
            this.f12331e = userData;
            this.f12332f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f12333g.a != null) {
                    this.f12333g.a.dismissDialog();
                }
                if (TextUtils.isEmpty(this.f12331e.getName_show()) || TextUtils.isEmpty(this.f12331e.getUserId())) {
                    return;
                }
                String name_show = this.f12331e.getName_show();
                String userId = this.f12331e.getUserId();
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TIEBA_UID_SHARE_DIALOG_CLICK);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.addParam("obj_param1", userId);
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f12332f.getPageActivity(), userId, name_show)));
            }
        }
    }

    public y() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public static TbPageContext c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public static y d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f12330b == null) {
                synchronized (y.class) {
                    if (f12330b == null) {
                        f12330b = new y();
                    }
                }
            }
            return f12330b;
        }
        return (y) invokeV.objValue;
    }

    public void b() {
        CardDialog cardDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cardDialog = this.a) != null && cardDialog.isShowing()) {
            this.a.dismissDialog();
        }
    }

    public void e(UserData userData, e.l lVar) {
        TbPageContext c2;
        boolean z;
        boolean z2;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userData, lVar) == null) || (c2 = c(TbadkCoreApplication.getInst().getCurrentActivity())) == null || c2.getPageActivity() == null || userData == null || lVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TIEBA_UID_SHARE_DIALOG_SHOW);
        statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.addParam("obj_param1", userData.getUserId());
        TiebaStatic.log(statisticItem);
        Activity pageActivity = c2.getPageActivity();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(c2.getPageActivity()).inflate(R.layout.content_tieba_uid_info, (ViewGroup) null, false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.who_share_info);
        textView.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.tieba_uid_share_info), lVar.a()));
        textView.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
        View findViewById = viewGroup.findViewById(R.id.left_divider);
        View findViewById2 = viewGroup.findViewById(R.id.right_divider);
        findViewById.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
        findViewById2.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
        HeadImageView headImageView = (HeadImageView) viewGroup.findViewById(R.id.user_averter);
        headImageView.setDefaultResource(R.drawable.transparent_bg);
        headImageView.setGodIconWidth(R.dimen.tbds68);
        headImageView.setAutoChangeStyle(false);
        UtilHelper.showHeadImageViewBigV(headImageView, userData);
        headImageView.setIsRound(true);
        headImageView.startLoad(userData.getAvater(), 25, false);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.user_name);
        textView2.setText(userData.getName_show());
        textView2.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0105));
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.user_tieba_uid);
        textView3.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.tieba_uid_info), lVar.b()));
        textView3.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0109));
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.container_authentication);
        if (ListUtils.isEmpty(userData.getManagerForum()) && !userData.isNewGod()) {
            linearLayout.setVisibility(8);
            z2 = true;
        } else {
            linearLayout.setVisibility(0);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X001);
            boolean z3 = userData.isNewGod() && !ListUtils.isEmpty(userData.getManagerForum());
            if (userData.isNewGod()) {
                TextView textView4 = new TextView(pageActivity);
                textView4.setPadding(dimenPixelSize, dimenPixelSize2, dimenPixelSize, dimenPixelSize2);
                textView4.setText(userData.getNewGodData().getFieldName() + s0.a(userData.getNewGodData()));
                textView4.setTextSize(0, (float) UtilHelper.getDimenPixelSize(R.dimen.T_X09));
                linearLayout.addView(textView4);
                textView4.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
                int i2 = R.dimen.tbds26;
                int i3 = R.color.CAM_X0623;
                SkinManager.setBackgroundShapeDrawable(textView4, i2, i3, i3, 0);
                z = true;
            } else {
                z = false;
            }
            if (!ListUtils.isEmpty(userData.getManagerForum())) {
                TextView textView5 = new TextView(pageActivity);
                textView5.setPadding(dimenPixelSize, dimenPixelSize2, dimenPixelSize, dimenPixelSize2);
                String desc = userData.getManagerForum().get(0).getDesc();
                if (userData.getManagerForum().size() > 1) {
                    if (z3) {
                        desc = StringHelper.cutChineseAndEnglishWithSuffix(desc, 6, "...");
                    }
                    format = String.format(TbadkCoreApplication.getInst().getString(R.string.multi_bazhu_sign), desc, Integer.valueOf(userData.getManagerForum().size()));
                } else {
                    if (z3) {
                        desc = StringHelper.cutChineseAndEnglishWithSuffix(desc, 8, "...");
                    }
                    format = String.format(TbadkCoreApplication.getInst().getString(R.string.single_bazhu_sign), desc);
                }
                textView5.setText(format);
                textView5.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X09));
                if (z) {
                    View view = new View(pageActivity);
                    view.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006), 1));
                    linearLayout.addView(view);
                }
                linearLayout.addView(textView5);
                textView5.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
                int i4 = R.dimen.tbds26;
                int i5 = R.color.CAM_X0623;
                SkinManager.setBackgroundShapeDrawable(textView5, i4, i5, i5, 0);
            }
            z2 = false;
        }
        TextView textView6 = (TextView) viewGroup.findViewById(R.id.user_simple_intro);
        String intro = userData.getIntro();
        if (TextUtils.isEmpty(userData.getIntro()) && z2) {
            intro = StringHelper.getBaAgeAutoYearAndMonth(userData.getTb_age());
        }
        textView6.setText(intro);
        if (linearLayout.getVisibility() == 0) {
            textView6.setMaxLines(1);
        } else {
            textView6.setMaxLines(2);
        }
        textView6.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) viewGroup.findViewById(R.id.jump_user_detail_btn);
        c.a.s0.s.k0.n.b bVar = new c.a.s0.s.k0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        tBSpecificationBtn.setTextSize(R.dimen.T_X05);
        tBSpecificationBtn.setConfig(bVar);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.browse_user_detail));
        tBSpecificationBtn.setOnClickListener(new a(this, userData, c2));
        this.a = new CardDialog(c2);
        this.a.setContentBackground(WebPManager.getMaskDrawable(R.drawable.mask_popup_background, false));
        this.a.setRealView(viewGroup);
        this.a.showDialog();
    }
}
