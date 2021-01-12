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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.google.gson.Gson;
/* loaded from: classes.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a ada;
    public final ThreadAchievementShareInfo eFO;
    private Gson eGB;
    private TextView eGC;
    private TextView eGD;
    private TextView eGE;
    private TextView eGF;
    private TextView eGG;
    private TextView eGH;
    private TextView eGI;
    private TextView eGJ;
    private at eGK;
    private Bitmap eGL;
    private View eGM;
    private ImageView eGN;
    private LinearLayout eGO;
    private FrameLayout eGP;
    private HeadImageView eGQ;
    private TextView eGR;
    private TextView eGS;
    private FrameLayout eGT;
    private int eGU;
    private ImageView eGV;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.eGB = new Gson();
        this.mContext = context;
        this.eFO = zn(str);
    }

    private ThreadAchievementShareInfo zn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.eGB.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.ada = aVar;
        initUI(this.mContext);
        if (this.eFO.getParams() != null && !x.isEmpty(this.eFO.getParams().getThread_list())) {
            this.eGP.addView(new a(this.mContext, this.eFO).getView());
            this.eGJ.setText(this.eFO.getParams().getTitle());
            aq aqVar = new aq("c13724");
            aqVar.an("obj_source", 1);
            TiebaStatic.log(aqVar);
            this.eGU = 2;
        } else if (this.eFO.getParams() != null) {
            if (this.eFO.getParams().getVideo_info() != null) {
                this.eGP.addView(new c(this.mContext, this.eFO).getView());
            } else {
                this.eGP.addView(new b(this.mContext, this.eFO).getView());
            }
            this.eGJ.setText(this.eFO.getParams().getTitle());
            aq aqVar2 = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar2.an("obj_source", 2);
            TiebaStatic.log(aqVar2);
            this.eGU = 3;
        }
        bkt();
        return true;
    }

    private void bkt() {
        String user_img;
        if (this.eFO != null && this.eFO.getParams() != null) {
            ThreadAchievementShareInfo.UserBean user = this.eFO.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.eGQ.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.eGI.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.eFO.getParams().getUrl())) {
                zo(this.eFO.getParams().getUrl());
                this.eGN.setVisibility(0);
                return;
            }
            this.eGN.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.eGM = this.mRootView.findViewById(R.id.poster_head_bg);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ao.setBackgroundResource(this.eGM, R.drawable.pic_announcement_round);
        this.eGP = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.eGJ = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.eGQ = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.eGI = (TextView) this.mRootView.findViewById(R.id.user_name);
        ao.setViewTextColor(this.eGI, R.color.CAM_X0101);
        ao.setViewTextColor(this.eGJ, R.color.CAM_X0101);
        this.eGQ.setIsRound(true);
        this.eGQ.setPlaceHolder(2);
        this.eGQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eGO = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.eGN = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.eGR = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.eGS = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.eGT = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.eGV = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eGV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.ada != null && ThreadAchievementShareDialogView.this.ada.isShowing()) {
                    ThreadAchievementShareDialogView.this.ada.dismiss();
                }
            }
        });
        ao.setImageResource(this.eGV, R.drawable.icon_popup_shut_n);
        ao.setViewTextColor(this.eGR, R.color.CAM_X0109);
        ao.setViewTextColor(this.eGS, R.color.CAM_X0109);
        ao.setBackgroundColor(this.eGT, R.color.CAM_X0201);
        ao.setBackgroundResource(this.eGO, R.drawable.bg_frs_private_dialog);
        this.eGC = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.eGC, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.eGC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.u(ThreadAchievementShareDialogView.this.bku());
            }
        });
        this.eGD = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.eGD, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        this.eGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bku(), 3);
            }
        });
        this.eGE = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.eGE, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        this.eGE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bku(), 2);
            }
        });
        this.eGF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.eGF, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.eGF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bku(), 4);
            }
        });
        this.eGG = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.eGG, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        this.eGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bku(), 8);
            }
        });
        this.eGH = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.eGH, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        this.eGH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bku(), 6);
            }
        });
    }

    private void zo(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eGN.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.e.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            ao.setViewTextColor(textView, R.color.CAM_X0106);
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

    public Bitmap bku() {
        if (this.eGL == null) {
            ao.setBackgroundColor(this.eGO, R.color.CAM_X0201);
            ao.setBackgroundResource(this.eGM, R.drawable.pic_announcement);
            this.eGO.buildDrawingCache();
            this.eGL = this.eGO.getDrawingCache();
        }
        ao.setBackgroundResource(this.eGO, R.drawable.bg_frs_private_dialog);
        ao.setBackgroundResource(this.eGM, R.drawable.pic_announcement_round);
        return this.eGL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Bitmap bitmap) {
        if (!bkv()) {
            if (this.eGK == null) {
                this.eGK = new at(this.mPageContext);
            }
            if (this.eFO.getParams() != null && !TextUtils.isEmpty(this.eFO.getParams().getUrl())) {
                this.eGK.p(this.eFO.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.eGK.p("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.eGV.performClick();
            aq aqVar = new aq("c13724");
            aqVar.an("obj_type", 1);
            aqVar.an("obj_source", this.eGU);
            TiebaStatic.log(aqVar);
        }
    }

    private boolean bkv() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bkv()) {
            aq aqVar = new aq("c13724");
            if (i == 3) {
                aqVar.an("obj_type", 2);
            } else if (i == 2) {
                aqVar.an("obj_type", 3);
            } else if (i == 8) {
                aqVar.an("obj_type", 4);
            } else if (i == 4) {
                aqVar.an("obj_type", 5);
            } else {
                aqVar.an("obj_type", 6);
            }
            aqVar.an("obj_source", this.eGU);
            TiebaStatic.log(aqVar);
            ac.a(new ab<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: bkw */
                public ShareItem doInBackground() {
                    return ThreadAchievementShareDialogView.this.e(bitmap, i);
                }
            }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(ThreadAchievementShareDialogView.this.mContext, i, shareItem, false));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem e(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.fsS = false;
        shareItem.fsR = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.x(bitmap);
        shareItem.byN();
        return shareItem;
    }
}
