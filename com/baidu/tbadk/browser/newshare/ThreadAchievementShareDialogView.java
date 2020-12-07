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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.google.gson.Gson;
/* loaded from: classes.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a acq;
    private final ThreadAchievementShareInfo eAW;
    private Gson eBJ;
    private TextView eBK;
    private TextView eBL;
    private TextView eBM;
    private TextView eBN;
    private TextView eBO;
    private TextView eBP;
    private TextView eBQ;
    private TextView eBR;
    private bd eBS;
    private Bitmap eBT;
    private View eBU;
    private ImageView eBV;
    private LinearLayout eBW;
    private FrameLayout eBX;
    private HeadImageView eBY;
    private TextView eBZ;
    private TextView eCa;
    private FrameLayout eCb;
    private int eCc;
    private ImageView eCd;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.eBJ = new Gson();
        this.mContext = context;
        this.eAW = AA(str);
    }

    private ThreadAchievementShareInfo AA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.eBJ.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.acq = aVar;
        initUI(this.mContext);
        if (this.eAW.getParams() != null && !y.isEmpty(this.eAW.getParams().getThread_list())) {
            this.eBX.addView(new a(this.mContext, this.eAW).getView());
            this.eBR.setText(this.eAW.getParams().getTitle());
            ar arVar = new ar("c13724");
            arVar.al("obj_source", 1);
            TiebaStatic.log(arVar);
            this.eCc = 2;
        } else if (this.eAW.getParams() != null) {
            if (this.eAW.getParams().getVideo_info() != null) {
                this.eBX.addView(new c(this.mContext, this.eAW).getView());
            } else {
                this.eBX.addView(new b(this.mContext, this.eAW).getView());
            }
            this.eBR.setText(this.eAW.getParams().getTitle());
            ar arVar2 = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar2.al("obj_source", 2);
            TiebaStatic.log(arVar2);
            this.eCc = 3;
        }
        blN();
        return true;
    }

    private void blN() {
        String user_img;
        if (this.eAW != null && this.eAW.getParams() != null) {
            ThreadAchievementShareInfo.UserBean user = this.eAW.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.eBY.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.eBQ.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.eAW.getParams().getUrl())) {
                AB(this.eAW.getParams().getUrl());
                this.eBV.setVisibility(0);
                return;
            }
            this.eBV.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.eBU = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eBU, R.drawable.pic_announcement_round);
        this.eBX = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.eBR = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.eBY = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.eBQ = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0101);
        ap.setViewTextColor(this.eBR, R.color.CAM_X0101);
        this.eBY.setIsRound(true);
        this.eBY.setPlaceHolder(2);
        this.eBY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eBW = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.eBV = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.eBZ = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.eCa = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.eCb = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.eCd = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.acq != null && ThreadAchievementShareDialogView.this.acq.isShowing()) {
                    ThreadAchievementShareDialogView.this.acq.dismiss();
                }
            }
        });
        ap.setImageResource(this.eCd, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.eBZ, R.color.CAM_X0109);
        ap.setViewTextColor(this.eCa, R.color.CAM_X0109);
        ap.setBackgroundColor(this.eCb, R.color.CAM_X0201);
        ap.setBackgroundResource(this.eBW, R.drawable.bg_frs_private_dialog);
        this.eBK = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.eBK, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.eBK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.blO());
            }
        });
        this.eBL = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.eBL, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.eBL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.blO(), 3);
            }
        });
        this.eBM = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.eBM, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.eBM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.blO(), 2);
            }
        });
        this.eBN = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.eBN, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.eBN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.blO(), 4);
            }
        });
        this.eBO = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.eBO, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.eBO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.blO(), 8);
            }
        });
        this.eBP = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.eBP, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.eBP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.blO(), 6);
            }
        });
    }

    private void AB(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eBV.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            ap.setViewTextColor(textView, R.color.CAM_X0106);
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

    public Bitmap blO() {
        if (this.eBT == null) {
            ap.setBackgroundColor(this.eBW, R.color.CAM_X0201);
            ap.setBackgroundResource(this.eBU, R.drawable.pic_announcement);
            this.eBW.buildDrawingCache();
            this.eBT = this.eBW.getDrawingCache();
        }
        ap.setBackgroundResource(this.eBW, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eBU, R.drawable.pic_announcement_round);
        return this.eBT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!blP()) {
            if (this.eBS == null) {
                this.eBS = new bd(this.mPageContext);
            }
            if (this.eAW.getParams() != null && !TextUtils.isEmpty(this.eAW.getParams().getUrl())) {
                this.eBS.j(this.eAW.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.eBS.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.eCd.performClick();
            ar arVar = new ar("c13724");
            arVar.al("obj_type", 1);
            arVar.al("obj_source", this.eCc);
            TiebaStatic.log(arVar);
        }
    }

    private boolean blP() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !blP()) {
            ar arVar = new ar("c13724");
            if (i == 3) {
                arVar.al("obj_type", 2);
            } else if (i == 2) {
                arVar.al("obj_type", 3);
            } else if (i == 8) {
                arVar.al("obj_type", 4);
            } else if (i == 4) {
                arVar.al("obj_type", 5);
            } else {
                arVar.al("obj_type", 6);
            }
            arVar.al("obj_source", this.eCc);
            TiebaStatic.log(arVar);
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: blQ */
                public ShareItem doInBackground() {
                    return ThreadAchievementShareDialogView.this.e(bitmap, i);
                }
            }, new m<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
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
        shareItem.fnR = false;
        shareItem.fnQ = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bAm();
        return shareItem;
    }
}
