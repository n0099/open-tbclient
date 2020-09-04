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
/* loaded from: classes.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a aaD;
    private Gson dTN;
    private TextView dTO;
    private TextView dTP;
    private TextView dTQ;
    private TextView dTR;
    private TextView dTS;
    private TextView dTT;
    private TextView dTU;
    private TextView dTV;
    private bd dTW;
    private Bitmap dTX;
    private View dTY;
    private ImageView dTZ;
    private final ThreadAchievementShareInfo dTa;
    private LinearLayout dUa;
    private FrameLayout dUb;
    private HeadImageView dUc;
    private TextView dUd;
    private TextView dUe;
    private FrameLayout dUf;
    private int dUg;
    private ImageView dUh;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.dTN = new Gson();
        this.mContext = context;
        this.dTa = yK(str);
    }

    private ThreadAchievementShareInfo yK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.dTN.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.aaD = aVar;
        initUI(this.mContext);
        if (this.dTa.getParams() != null && !y.isEmpty(this.dTa.getParams().getThread_list())) {
            this.dUb.addView(new a(this.mContext, this.dTa).getView());
            this.dTV.setText(this.dTa.getParams().getTitle());
            aq aqVar = new aq("c13724");
            aqVar.ai("obj_source", 1);
            TiebaStatic.log(aqVar);
            this.dUg = 2;
        } else if (this.dTa.getParams() != null) {
            if (this.dTa.getParams().getVideo_info() != null) {
                this.dUb.addView(new c(this.mContext, this.dTa).getView());
            } else {
                this.dUb.addView(new b(this.mContext, this.dTa).getView());
            }
            this.dTV.setText(this.dTa.getParams().getTitle());
            aq aqVar2 = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar2.ai("obj_source", 2);
            TiebaStatic.log(aqVar2);
            this.dUg = 3;
        }
        bbE();
        return true;
    }

    private void bbE() {
        String user_img;
        if (this.dTa != null) {
            ThreadAchievementShareInfo.UserBean user = this.dTa.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.dUc.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.dTU.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.dTa.getParams().getUrl())) {
                yL(this.dTa.getParams().getUrl());
                this.dTZ.setVisibility(0);
                return;
            }
            this.dTZ.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.dTY = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.dTY, R.drawable.pic_announcement_round);
        this.dUb = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.dTV = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.dUc = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.dTU = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.dTU, R.color.cp_cont_a);
        ap.setViewTextColor(this.dTV, R.color.cp_cont_a);
        this.dUc.setIsRound(true);
        this.dUc.setPlaceHolder(2);
        this.dUc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dUa = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.dTZ = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.dUd = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.dUe = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.dUf = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.dUh = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dUh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.aaD != null && ThreadAchievementShareDialogView.this.aaD.isShowing()) {
                    ThreadAchievementShareDialogView.this.aaD.dismiss();
                }
            }
        });
        ap.setImageResource(this.dUh, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.dUd, R.color.cp_cont_d);
        ap.setViewTextColor(this.dUe, R.color.cp_cont_d);
        ap.setBackgroundColor(this.dUf, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.dUa, R.drawable.bg_frs_private_dialog);
        this.dTO = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.dTO, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.dTO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.bbF());
            }
        });
        this.dTP = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.dTP, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.dTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 3);
            }
        });
        this.dTQ = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.dTQ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.dTQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 2);
            }
        });
        this.dTR = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.dTR, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.dTR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 4);
            }
        });
        this.dTS = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.dTS, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.dTS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 8);
            }
        });
        this.dTT = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.dTT, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.dTT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bbF(), 6);
            }
        });
    }

    private void yL(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dTZ.setImageBitmap((Bitmap) runTask.getData());
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
        if (this.dTX == null) {
            ap.setBackgroundColor(this.dUa, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dTY, R.drawable.pic_announcement);
            this.dUa.buildDrawingCache();
            this.dTX = this.dUa.getDrawingCache();
        }
        ap.setBackgroundResource(this.dUa, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.dTY, R.drawable.pic_announcement_round);
        return this.dTX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bbG()) {
            if (this.dTW == null) {
                this.dTW = new bd(this.mPageContext);
            }
            if (this.dTa.getParams() != null && !TextUtils.isEmpty(this.dTa.getParams().getUrl())) {
                this.dTW.j(this.dTa.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.dTW.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.dUh.performClick();
            aq aqVar = new aq("c13724");
            aqVar.ai("obj_type", 1);
            aqVar.ai("obj_source", this.dUg);
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
            aqVar.ai("obj_source", this.dUg);
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
        shareItem.eEJ = false;
        shareItem.eEI = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bpA();
        return shareItem;
    }
}
