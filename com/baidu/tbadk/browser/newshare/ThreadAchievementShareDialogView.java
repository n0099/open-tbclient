package com.baidu.tbadk.browser.newshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.google.gson.Gson;
/* loaded from: classes2.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a aaB;
    private final ThreadAchievementShareInfo dSW;
    private Gson dTJ;
    private TextView dTK;
    private TextView dTL;
    private TextView dTM;
    private TextView dTN;
    private TextView dTO;
    private TextView dTP;
    private TextView dTQ;
    private TextView dTR;
    private bd dTS;
    private Bitmap dTT;
    private View dTU;
    private ImageView dTV;
    private LinearLayout dTW;
    private FrameLayout dTX;
    private HeadImageView dTY;
    private TextView dTZ;
    private TextView dUa;
    private FrameLayout dUb;
    private int dUc;
    private ImageView dUd;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.dTJ = new Gson();
        this.mContext = context;
        this.dSW = yJ(str);
    }

    private ThreadAchievementShareInfo yJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.dTJ.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.aaB = aVar;
        initUI(this.mContext);
        if (this.dSW.getParams() != null && !y.isEmpty(this.dSW.getParams().getThread_list())) {
            this.dTX.addView(new a(this.mContext, this.dSW).getView());
            this.dTR.setText(this.dSW.getParams().getTitle());
            aq aqVar = new aq("c13724");
            aqVar.ai("obj_source", 1);
            TiebaStatic.log(aqVar);
            this.dUc = 2;
        } else if (this.dSW.getParams() != null) {
            if (this.dSW.getParams().getVideo_info() != null) {
                this.dTX.addView(new c(this.mContext, this.dSW).getView());
            } else {
                this.dTX.addView(new b(this.mContext, this.dSW).getView());
            }
            this.dTR.setText(this.dSW.getParams().getTitle());
            aq aqVar2 = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar2.ai("obj_source", 2);
            TiebaStatic.log(aqVar2);
            this.dUc = 3;
        }
        bbE();
        return true;
    }

    private void bbE() {
        String user_img;
        if (this.dSW != null) {
            ThreadAchievementShareInfo.UserBean user = this.dSW.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.dTY.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.dTQ.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.dSW.getParams().getUrl())) {
                yK(this.dSW.getParams().getUrl());
                this.dTV.setVisibility(0);
                return;
            }
            this.dTV.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.dTU = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.dTU, R.drawable.pic_announcement_round);
        this.dTX = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.dTR = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.dTY = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.dTQ = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.dTQ, R.color.cp_cont_a);
        ap.setViewTextColor(this.dTR, R.color.cp_cont_a);
        this.dTY.setIsRound(true);
        this.dTY.setPlaceHolder(2);
        this.dTY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dTW = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.dTV = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.dTZ = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.dUa = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.dUb = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.dUd = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dUd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.aaB != null && ThreadAchievementShareDialogView.this.aaB.isShowing()) {
                    ThreadAchievementShareDialogView.this.aaB.dismiss();
                }
            }
        });
        ap.setImageResource(this.dUd, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.dTZ, R.color.cp_cont_d);
        ap.setViewTextColor(this.dUa, R.color.cp_cont_d);
        ap.setBackgroundColor(this.dUb, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.dTW, R.drawable.bg_frs_private_dialog);
        this.dTK = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.dTK, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.dTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.bbF());
            }
        });
        this.dTL = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.dTL, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.dTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 3);
            }
        });
        this.dTM = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.dTM, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.dTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 2);
            }
        });
        this.dTN = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.dTN, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.dTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 4);
            }
        });
        this.dTO = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.dTO, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.dTO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 8);
            }
        });
        this.dTP = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.dTP, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.dTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 6);
            }
        });
    }

    private void yK(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dTV.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            ap.setViewTextColor(textView, R.color.cp_cont_f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = getTextViewWidth();
            textView.setLayoutParams(layoutParams);
        }
    }

    private int getTextViewWidth() {
        int equipmentWidth;
        int dimens = l.getDimens(this.mContext, R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            equipmentWidth = (l.getEquipmentHeight(this.mContext) - (dimens * 2)) - dimens2;
        } else {
            equipmentWidth = (l.getEquipmentWidth(this.mContext) - (dimens * 2)) - dimens2;
        }
        return equipmentWidth / 6;
    }

    public Bitmap bbF() {
        if (this.dTT == null) {
            ap.setBackgroundColor(this.dTW, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dTU, R.drawable.pic_announcement);
            this.dTW.buildDrawingCache();
            this.dTT = this.dTW.getDrawingCache();
        }
        ap.setBackgroundResource(this.dTW, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.dTU, R.drawable.pic_announcement_round);
        return this.dTT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bbG()) {
            if (this.dTS == null) {
                this.dTS = new bd(this.mPageContext);
            }
            if (this.dSW.getParams() != null && !TextUtils.isEmpty(this.dSW.getParams().getUrl())) {
                this.dTS.j(this.dSW.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.dTS.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.dUd.performClick();
            aq aqVar = new aq("c13724");
            aqVar.ai("obj_type", 1);
            aqVar.ai("obj_source", this.dUc);
            TiebaStatic.log(aqVar);
        }
    }

    private boolean bbG() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bbG()) {
            aq aqVar = new aq("c13724");
            if (i == 3) {
                aqVar.ai("obj_type", 2);
            } else if (i == 2) {
                aqVar.ai("obj_type", 3);
            } else if (i == 8) {
                aqVar.ai("obj_type", 4);
            } else if (i == 4) {
                aqVar.ai("obj_type", 5);
            } else {
                aqVar.ai("obj_type", 6);
            }
            aqVar.ai("obj_source", this.dUc);
            TiebaStatic.log(aqVar);
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bbH */
                public ShareItem doInBackground() {
                    return ThreadAchievementShareDialogView.this.e(bitmap, i);
                }
            }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(ThreadAchievementShareDialogView.this.mContext, i, shareItem, false));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem e(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.eEF = false;
        shareItem.eEE = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bpz();
        return shareItem;
    }
}
