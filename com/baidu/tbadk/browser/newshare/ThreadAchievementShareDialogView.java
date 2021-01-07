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
    private com.baidu.tbadk.core.dialog.a adc;
    public final ThreadAchievementShareInfo eKz;
    private FrameLayout eLA;
    private HeadImageView eLB;
    private TextView eLC;
    private TextView eLD;
    private FrameLayout eLE;
    private int eLF;
    private ImageView eLG;
    private Gson eLm;
    private TextView eLn;
    private TextView eLo;
    private TextView eLp;
    private TextView eLq;
    private TextView eLr;
    private TextView eLs;
    private TextView eLt;
    private TextView eLu;
    private at eLv;
    private Bitmap eLw;
    private View eLx;
    private ImageView eLy;
    private LinearLayout eLz;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.eLm = new Gson();
        this.mContext = context;
        this.eKz = Ay(str);
    }

    private ThreadAchievementShareInfo Ay(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.eLm.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.adc = aVar;
        initUI(this.mContext);
        if (this.eKz.getParams() != null && !x.isEmpty(this.eKz.getParams().getThread_list())) {
            this.eLA.addView(new a(this.mContext, this.eKz).getView());
            this.eLu.setText(this.eKz.getParams().getTitle());
            aq aqVar = new aq("c13724");
            aqVar.an("obj_source", 1);
            TiebaStatic.log(aqVar);
            this.eLF = 2;
        } else if (this.eKz.getParams() != null) {
            if (this.eKz.getParams().getVideo_info() != null) {
                this.eLA.addView(new c(this.mContext, this.eKz).getView());
            } else {
                this.eLA.addView(new b(this.mContext, this.eKz).getView());
            }
            this.eLu.setText(this.eKz.getParams().getTitle());
            aq aqVar2 = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar2.an("obj_source", 2);
            TiebaStatic.log(aqVar2);
            this.eLF = 3;
        }
        bon();
        return true;
    }

    private void bon() {
        String user_img;
        if (this.eKz != null && this.eKz.getParams() != null) {
            ThreadAchievementShareInfo.UserBean user = this.eKz.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.eLB.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.eLt.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.eKz.getParams().getUrl())) {
                Az(this.eKz.getParams().getUrl());
                this.eLy.setVisibility(0);
                return;
            }
            this.eLy.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.eLx = this.mRootView.findViewById(R.id.poster_head_bg);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ao.setBackgroundResource(this.eLx, R.drawable.pic_announcement_round);
        this.eLA = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.eLu = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.eLB = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.eLt = (TextView) this.mRootView.findViewById(R.id.user_name);
        ao.setViewTextColor(this.eLt, R.color.CAM_X0101);
        ao.setViewTextColor(this.eLu, R.color.CAM_X0101);
        this.eLB.setIsRound(true);
        this.eLB.setPlaceHolder(2);
        this.eLB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eLz = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.eLy = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.eLC = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.eLD = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.eLE = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.eLG = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.adc != null && ThreadAchievementShareDialogView.this.adc.isShowing()) {
                    ThreadAchievementShareDialogView.this.adc.dismiss();
                }
            }
        });
        ao.setImageResource(this.eLG, R.drawable.icon_popup_shut_n);
        ao.setViewTextColor(this.eLC, R.color.CAM_X0109);
        ao.setViewTextColor(this.eLD, R.color.CAM_X0109);
        ao.setBackgroundColor(this.eLE, R.color.CAM_X0201);
        ao.setBackgroundResource(this.eLz, R.drawable.bg_frs_private_dialog);
        this.eLn = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.eLn, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.eLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.u(ThreadAchievementShareDialogView.this.boo());
            }
        });
        this.eLo = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.eLo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        this.eLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.boo(), 3);
            }
        });
        this.eLp = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.eLp, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        this.eLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.boo(), 2);
            }
        });
        this.eLq = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.eLq, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.eLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.boo(), 4);
            }
        });
        this.eLr = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.eLr, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        this.eLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.boo(), 8);
            }
        });
        this.eLs = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.eLs, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        this.eLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.boo(), 6);
            }
        });
    }

    private void Az(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eLy.setImageBitmap((Bitmap) runTask.getData());
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

    public Bitmap boo() {
        if (this.eLw == null) {
            ao.setBackgroundColor(this.eLz, R.color.CAM_X0201);
            ao.setBackgroundResource(this.eLx, R.drawable.pic_announcement);
            this.eLz.buildDrawingCache();
            this.eLw = this.eLz.getDrawingCache();
        }
        ao.setBackgroundResource(this.eLz, R.drawable.bg_frs_private_dialog);
        ao.setBackgroundResource(this.eLx, R.drawable.pic_announcement_round);
        return this.eLw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Bitmap bitmap) {
        if (!bop()) {
            if (this.eLv == null) {
                this.eLv = new at(this.mPageContext);
            }
            if (this.eKz.getParams() != null && !TextUtils.isEmpty(this.eKz.getParams().getUrl())) {
                this.eLv.p(this.eKz.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.eLv.p("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.eLG.performClick();
            aq aqVar = new aq("c13724");
            aqVar.an("obj_type", 1);
            aqVar.an("obj_source", this.eLF);
            TiebaStatic.log(aqVar);
        }
    }

    private boolean bop() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bop()) {
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
            aqVar.an("obj_source", this.eLF);
            TiebaStatic.log(aqVar);
            ac.a(new ab<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: boq */
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
        shareItem.fxB = false;
        shareItem.fxA = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.x(bitmap);
        shareItem.bCH();
        return shareItem;
    }
}
