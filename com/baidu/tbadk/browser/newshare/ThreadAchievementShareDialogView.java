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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.google.gson.Gson;
/* loaded from: classes.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a aaa;
    private final ThreadAchievementShareInfo dDR;
    private Gson dEE;
    private TextView dEF;
    private TextView dEG;
    private TextView dEH;
    private TextView dEI;
    private TextView dEJ;
    private TextView dEK;
    private TextView dEL;
    private TextView dEM;
    private az dEN;
    private Bitmap dEO;
    private View dEP;
    private ImageView dEQ;
    private LinearLayout dER;
    private FrameLayout dES;
    private HeadImageView dET;
    private TextView dEU;
    private TextView dEV;
    private FrameLayout dEW;
    private int dEX;
    private ImageView dEY;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.dEE = new Gson();
        this.mContext = context;
        this.dDR = vw(str);
    }

    private ThreadAchievementShareInfo vw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.dEE.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.aaa = aVar;
        initUI(this.mContext);
        if (this.dDR.getParams() != null && !w.isEmpty(this.dDR.getParams().getThread_list())) {
            this.dES.addView(new a(this.mContext, this.dDR).getView());
            this.dEM.setText(this.dDR.getParams().getTitle());
            ao aoVar = new ao("c13724");
            aoVar.ag("obj_source", 1);
            TiebaStatic.log(aoVar);
            this.dEX = 2;
        } else if (this.dDR.getParams() != null) {
            if (this.dDR.getParams().getVideo_info() != null) {
                this.dES.addView(new c(this.mContext, this.dDR).getView());
            } else {
                this.dES.addView(new b(this.mContext, this.dDR).getView());
            }
            this.dEM.setText(this.dDR.getParams().getTitle());
            ao aoVar2 = new ao(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aoVar2.ag("obj_source", 2);
            TiebaStatic.log(aoVar2);
            this.dEX = 3;
        }
        aPs();
        return true;
    }

    private void aPs() {
        String user_img;
        if (this.dDR != null) {
            ThreadAchievementShareInfo.UserBean user = this.dDR.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.dET.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.dEL.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.dDR.getParams().getUrl())) {
                vx(this.dDR.getParams().getUrl());
                this.dEQ.setVisibility(0);
                return;
            }
            this.dEQ.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.dEP = this.mRootView.findViewById(R.id.poster_head_bg);
        an.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        an.setBackgroundResource(this.dEP, R.drawable.pic_announcement_round);
        this.dES = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.dEM = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.dET = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.dEL = (TextView) this.mRootView.findViewById(R.id.user_name);
        an.setViewTextColor(this.dEL, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.dEM, (int) R.color.cp_cont_a);
        this.dET.setIsRound(true);
        this.dET.setPlaceHolder(2);
        this.dET.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dER = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.dEQ = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.dEU = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.dEV = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.dEW = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.dEY = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.aaa != null && ThreadAchievementShareDialogView.this.aaa.isShowing()) {
                    ThreadAchievementShareDialogView.this.aaa.dismiss();
                }
            }
        });
        an.setImageResource(this.dEY, R.drawable.icon_popup_shut_n);
        an.setViewTextColor(this.dEU, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.dEV, (int) R.color.cp_cont_d);
        an.setBackgroundColor(this.dEW, R.color.cp_bg_line_d);
        an.setBackgroundResource(this.dER, R.drawable.bg_frs_private_dialog);
        this.dEF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.dEF, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.dEF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.q(ThreadAchievementShareDialogView.this.aPt());
            }
        });
        this.dEG = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.dEG, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.dEG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.c(ThreadAchievementShareDialogView.this.aPt(), 3);
            }
        });
        this.dEH = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.dEH, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.dEH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.c(ThreadAchievementShareDialogView.this.aPt(), 2);
            }
        });
        this.dEI = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.dEI, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.dEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.c(ThreadAchievementShareDialogView.this.aPt(), 4);
            }
        });
        this.dEJ = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.dEJ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.dEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.c(ThreadAchievementShareDialogView.this.aPt(), 8);
            }
        });
        this.dEK = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.dEK, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.dEK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.c(ThreadAchievementShareDialogView.this.aPt(), 6);
            }
        });
    }

    private void vx(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dEQ.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            an.setViewTextColor(textView, (int) R.color.cp_cont_f);
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

    public Bitmap aPt() {
        if (this.dEO == null) {
            an.setBackgroundColor(this.dER, R.color.cp_bg_line_d);
            an.setBackgroundResource(this.dEP, R.drawable.pic_announcement);
            this.dER.buildDrawingCache();
            this.dEO = this.dER.getDrawingCache();
        }
        return this.dEO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Bitmap bitmap) {
        if (!aPu()) {
            if (this.dEN == null) {
                this.dEN = new az(this.mPageContext);
            }
            if (this.dDR.getParams() != null && !TextUtils.isEmpty(this.dDR.getParams().getUrl())) {
                this.dEN.j(this.dDR.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.dEN.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.dEY.performClick();
            ao aoVar = new ao("c13724");
            aoVar.ag("obj_type", 1);
            aoVar.ag("obj_source", this.dEX);
            TiebaStatic.log(aoVar);
        }
    }

    private boolean aPu() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        if (bitmap != null && !aPu()) {
            ao aoVar = new ao("c13724");
            if (i == 3) {
                aoVar.ag("obj_type", 2);
            } else if (i == 2) {
                aoVar.ag("obj_type", 3);
            } else if (i == 8) {
                aoVar.ag("obj_type", 4);
            } else if (i == 4) {
                aoVar.ag("obj_type", 5);
            } else {
                aoVar.ag("obj_type", 6);
            }
            aoVar.ag("obj_source", this.dEX);
            TiebaStatic.log(aoVar);
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: aPv */
                public ShareItem doInBackground() {
                    return ThreadAchievementShareDialogView.this.d(bitmap, i);
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
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.enT = false;
        shareItem.enS = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.t(bitmap);
        shareItem.bdh();
        return shareItem;
    }
}
