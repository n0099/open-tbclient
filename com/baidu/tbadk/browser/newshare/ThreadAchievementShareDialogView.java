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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.google.gson.Gson;
/* loaded from: classes.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a aaV;
    private Gson dVX;
    private TextView dVY;
    private TextView dVZ;
    private final ThreadAchievementShareInfo dVk;
    private TextView dWa;
    private TextView dWb;
    private TextView dWc;
    private TextView dWd;
    private TextView dWe;
    private TextView dWf;
    private bd dWg;
    private Bitmap dWh;
    private View dWi;
    private ImageView dWj;
    private LinearLayout dWk;
    private FrameLayout dWl;
    private HeadImageView dWm;
    private TextView dWn;
    private TextView dWo;
    private FrameLayout dWp;
    private int dWq;
    private ImageView dWr;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.dVX = new Gson();
        this.mContext = context;
        this.dVk = zf(str);
    }

    private ThreadAchievementShareInfo zf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.dVX.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.aaV = aVar;
        initUI(this.mContext);
        if (this.dVk.getParams() != null && !y.isEmpty(this.dVk.getParams().getThread_list())) {
            this.dWl.addView(new a(this.mContext, this.dVk).getView());
            this.dWf.setText(this.dVk.getParams().getTitle());
            aq aqVar = new aq("c13724");
            aqVar.ai("obj_source", 1);
            TiebaStatic.log(aqVar);
            this.dWq = 2;
        } else if (this.dVk.getParams() != null) {
            if (this.dVk.getParams().getVideo_info() != null) {
                this.dWl.addView(new c(this.mContext, this.dVk).getView());
            } else {
                this.dWl.addView(new b(this.mContext, this.dVk).getView());
            }
            this.dWf.setText(this.dVk.getParams().getTitle());
            aq aqVar2 = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar2.ai("obj_source", 2);
            TiebaStatic.log(aqVar2);
            this.dWq = 3;
        }
        bcy();
        return true;
    }

    private void bcy() {
        String user_img;
        if (this.dVk != null) {
            ThreadAchievementShareInfo.UserBean user = this.dVk.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.dWm.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.dWe.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.dVk.getParams().getUrl())) {
                zg(this.dVk.getParams().getUrl());
                this.dWj.setVisibility(0);
                return;
            }
            this.dWj.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.dWi = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.dWi, R.drawable.pic_announcement_round);
        this.dWl = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.dWf = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.dWm = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.dWe = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.dWe, R.color.cp_cont_a);
        ap.setViewTextColor(this.dWf, R.color.cp_cont_a);
        this.dWm.setIsRound(true);
        this.dWm.setPlaceHolder(2);
        this.dWm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dWk = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.dWj = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.dWn = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.dWo = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.dWp = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.dWr = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dWr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.aaV != null && ThreadAchievementShareDialogView.this.aaV.isShowing()) {
                    ThreadAchievementShareDialogView.this.aaV.dismiss();
                }
            }
        });
        ap.setImageResource(this.dWr, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.dWn, R.color.cp_cont_d);
        ap.setViewTextColor(this.dWo, R.color.cp_cont_d);
        ap.setBackgroundColor(this.dWp, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.dWk, R.drawable.bg_frs_private_dialog);
        this.dVY = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.dVY, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.dVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.bcz());
            }
        });
        this.dVZ = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.dVZ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.dVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bcz(), 3);
            }
        });
        this.dWa = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.dWa, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.dWa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bcz(), 2);
            }
        });
        this.dWb = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.dWb, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.dWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bcz(), 4);
            }
        });
        this.dWc = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.dWc, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.dWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bcz(), 8);
            }
        });
        this.dWd = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.dWd, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.dWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bcz(), 6);
            }
        });
    }

    private void zg(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dWj.setImageBitmap((Bitmap) runTask.getData());
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

    public Bitmap bcz() {
        if (this.dWh == null) {
            ap.setBackgroundColor(this.dWk, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dWi, R.drawable.pic_announcement);
            this.dWk.buildDrawingCache();
            this.dWh = this.dWk.getDrawingCache();
        }
        ap.setBackgroundResource(this.dWk, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.dWi, R.drawable.pic_announcement_round);
        return this.dWh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bcA()) {
            if (this.dWg == null) {
                this.dWg = new bd(this.mPageContext);
            }
            if (this.dVk.getParams() != null && !TextUtils.isEmpty(this.dVk.getParams().getUrl())) {
                this.dWg.j(this.dVk.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.dWg.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.dWr.performClick();
            aq aqVar = new aq("c13724");
            aqVar.ai("obj_type", 1);
            aqVar.ai("obj_source", this.dWq);
            TiebaStatic.log(aqVar);
        }
    }

    private boolean bcA() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bcA()) {
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
            aqVar.ai("obj_source", this.dWq);
            TiebaStatic.log(aqVar);
            ae.a(new ad<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bcB */
                public ShareItem doInBackground() {
                    return ThreadAchievementShareDialogView.this.e(bitmap, i);
                }
            }, new m<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
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
        shareItem.eGP = false;
        shareItem.eGO = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bqu();
        return shareItem;
    }
}
