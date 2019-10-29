package com.baidu.card.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.b;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.util.e;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CardUserInfoLayout extends LinearLayout implements j {
    private bh FT;
    private HeadPendantClickableView HD;
    private TextView HE;
    private TextView HF;
    private UserIconBox HG;
    private UserIconBox HH;
    private TextView HI;
    private TextView HJ;
    protected RelativeLayout HK;
    private ImageView HL;
    private View HM;
    private FrameLayout HN;
    private View.OnClickListener HO;
    private View.OnClickListener HP;
    private View HQ;
    private int HR;
    private Runnable HS;
    private View.OnClickListener HU;
    private View.OnClickListener HV;
    private View.OnClickListener HW;
    private Context mContext;
    private int mSkinType;

    public CardUserInfoLayout(Context context) {
        this(context, null);
    }

    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.HR = 1285;
        this.HS = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.mf();
            }
        };
        this.HU = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.FT != null && CardUserInfoLayout.this.FT.aiG() != null && CardUserInfoLayout.this.FT.aiG().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.FT.aiG().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.FT.aiG().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.amQ().b((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.HV = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.FT != null && CardUserInfoLayout.this.FT.aiG() != null && !StringUtils.isNull(CardUserInfoLayout.this.FT.aiG().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.FT.aiG().getUserId()) && CardUserInfoLayout.this.FT.aiL() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (CardUserInfoLayout.this.FT.ajP() != null && CardUserInfoLayout.this.FT.ajP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.FT.ajP().channelId, CardUserInfoLayout.this.FT.ajP().ZN)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.FT.aiG().getUserId(), CardUserInfoLayout.this.FT.aiG().getName_show(), CardUserInfoLayout.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.FT.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (CardUserInfoLayout.this.HO != null) {
                        CardUserInfoLayout.this.HO.onClick(view);
                    }
                }
            }
        };
        this.HW = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.FT != null && CardUserInfoLayout.this.FT.aiG() != null) {
                    a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.FT.aiG().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.HP != null) {
                        CardUserInfoLayout.this.HO.onClick(view);
                    }
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(16);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds92));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
        md();
    }

    public void setShowFlag(int i) {
        this.HR = i;
        mc();
    }

    private void mc() {
        this.HH.setVisibility(aN(1) ? 0 : 8);
        this.HE.setVisibility(aN(4) ? 0 : 8);
        this.HF.setVisibility(aN(16) ? 0 : 8);
        this.HJ.setVisibility(aN(8) ? 0 : 8);
        this.HG.setVisibility(aN(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HQ.getLayoutParams();
        if (aN(128)) {
            this.HI.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.HI.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.HQ.setLayoutParams(layoutParams);
        if (aN(64)) {
            this.HN.setVisibility(0);
            this.HM = b.afc().l(getContext(), 1);
            if (this.HM != null) {
                this.HM.setVisibility(8);
                this.HN.addView(this.HM);
            }
        } else {
            this.HN.setVisibility(8);
        }
        this.HL.setVisibility(aN(4096) ? 0 : 8);
    }

    private boolean aN(int i) {
        return (this.HR & i) > 0;
    }

    private void md() {
        this.HD = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.HD.setHasPendantStyle();
        this.HD.getHeadView().setIsRound(true);
        this.HD.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.HD.getHeadView().setDefaultResource(17170445);
        this.HD.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.HD.getHeadView().setDefaultBgResource(e.Vl());
        this.HD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.HO != null) {
                    CardUserInfoLayout.this.HO.onClick(view);
                }
            }
        });
        this.HH = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.HH.setOnClickListener(this.HU);
        this.HE = (TextView) findViewById(R.id.user_name);
        this.HE.setOnClickListener(this.HV);
        this.HF = (TextView) findViewById(R.id.identity_view);
        this.HJ = (TextView) findViewById(R.id.thread_share_intro);
        this.HG = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.HG.setOnClickListener(this.HW);
        this.HI = (TextView) findViewById(R.id.thread_extend_info);
        this.HN = (FrameLayout) findViewById(R.id.ala_live_info_content_layout);
        this.HQ = findViewById(R.id.user_name_and_reply_time);
        this.HK = (RelativeLayout) findViewById(R.id.suffix_container);
        this.HL = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.HD.getHeadView().setDefaultBgResource(e.Vl());
        }
    }

    private void c(bh bhVar) {
        if (this.HD != null && bhVar != null && this.FT.aiG() != null) {
            if (!aN(1024)) {
                this.HD.V(false);
            } else if (this.FT.cea > 0 && this.FT.ceb == 0) {
                this.HD.V(false);
            } else {
                this.HD.V(this.FT.aiG().isBigV());
            }
        }
    }

    public void setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return;
        }
        this.FT = bhVar;
        e(bhVar);
        j(bhVar);
        k(bhVar);
        g(bhVar);
        i(bhVar);
        c(bhVar);
        m(bhVar);
        h(bhVar);
        setVisibility(0);
        f(bhVar);
        d(bhVar);
        if (aN(128)) {
            this.HQ.post(this.HS);
        }
    }

    private void d(bh bhVar) {
        if (aN(4096) && bhVar != null && this.HL != null) {
            if (bhVar.ceC) {
                this.HL.setVisibility(0);
            } else {
                this.HL.setVisibility(8);
            }
        }
    }

    private void e(bh bhVar) {
        if (bhVar.aiG() == null) {
            this.HD.setVisibility(8);
            return;
        }
        MetaData aiG = bhVar.aiG();
        if (!aN(256)) {
            aiG.setPendantData(null);
        }
        this.HD.setData(bhVar);
    }

    private void f(bh bhVar) {
        if (bhVar != null && bhVar.aiG() != null && bhVar.aiG().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bhVar.aiG().getAlaUserData();
            if (this.HM != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.bTT = alaUserData;
                aVar.type = 1;
                this.HM.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.HM.setVisibility(8);
                } else {
                    this.HM.setVisibility(0);
                }
            }
        } else if (this.HM != null) {
            this.HM.setVisibility(8);
        }
    }

    private void g(bh bhVar) {
        if (this.HE != null && bhVar != null) {
            if (!StringUtils.isNull(this.FT.aie())) {
                this.HE.setText(this.FT.aie());
            } else {
                this.HE.setText(R.string.user_name_default_txt);
            }
            me();
        }
    }

    protected void h(bh bhVar) {
        if (this.HJ != null) {
            if (bhVar == null || (!aN(8) && !aN(512))) {
                this.HJ.setVisibility(8);
            } else if (this.FT.getType() == bh.cdh) {
                this.HJ.setVisibility(0);
                this.HJ.getPaint().setFakeBoldText(true);
                this.HJ.setText(this.mContext.getString(R.string.interview_live_info_tip_is_live));
                am.setViewTextColor(this.HJ, (int) R.color.cp_cont_b);
            } else if (aN(8)) {
                if (StringUtils.isNull(bhVar.agJ())) {
                    this.HJ.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HJ.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.HJ.setLayoutParams(layoutParams);
                }
                this.HJ.setText(bhVar.agJ());
                this.HJ.setVisibility(0);
            } else if (StringUtils.isNull(this.FT.aig())) {
                this.HJ.setVisibility(8);
            } else {
                this.HJ.setVisibility(0);
                this.HJ.setText(this.FT.aig());
            }
        }
    }

    private void i(bh bhVar) {
        if (this.HG != null) {
            if (!aN(32)) {
                this.HG.setVisibility(8);
            } else if (bhVar == null || bhVar.aiG() == null || (bhVar.cea > 0 && bhVar.ceb == 0)) {
                this.HG.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bhVar.aiG().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.HG.setVisibility(0);
                    this.HG.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.HG.setVisibility(8);
            }
        }
    }

    protected String k(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void me() {
        if (this.FT != null && this.FT.aiG() != null) {
            if (this.FT.cea > 0 && this.FT.ceb == 0) {
                am.setViewTextColor(this.HE, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.FT.aiG().getTShowInfoNew())) {
                am.setViewTextColor(this.HE, (int) R.color.cp_cont_h);
            } else if (this.FT.aiG().isBigV()) {
                if (aN(1024)) {
                    am.setViewTextColor(this.HE, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.HE, (int) R.color.cp_cont_f);
                }
            } else {
                am.setViewTextColor(this.HE, (int) R.color.cp_cont_f);
            }
        }
    }

    private void j(bh bhVar) {
        if (this.HH != null && bhVar != null && bhVar.aiG() != null && aN(1)) {
            ArrayList<IconData> tShowInfoNew = bhVar.aiG().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.HH.setVisibility(0);
                this.HH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.HH.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.HF != null && bhVar != null && bhVar.aiG() != null && aN(16)) {
            MetaData aiG = bhVar.aiG();
            if (aiG.getIs_bawu() == 1) {
                am.setBackgroundResource(this.HF, R.drawable.brand_official_btn);
                am.setViewTextColor(this.HF, (int) R.color.cp_cont_a);
                if (bhVar.cen) {
                    this.HF.setVisibility(0);
                    this.HF.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aiG.getBawu_type())) {
                    this.HF.setVisibility(0);
                    this.HF.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aiG.getBawu_type())) {
                    this.HF.setText(R.string.bawu_member_xbazhu_tip);
                    this.HF.setVisibility(0);
                } else if ("pri_content_assist".equals(aiG.getBawu_type())) {
                    this.HF.setText(R.string.bawu_content_assist_tip);
                    this.HF.setVisibility(0);
                } else if ("pri_manage_assist".equals(aiG.getBawu_type())) {
                    this.HF.setText(R.string.bawu_manage_assist_tip);
                    this.HF.setVisibility(0);
                } else if (aiG.getIs_biggie()) {
                    l(bhVar);
                } else {
                    this.HF.setVisibility(8);
                }
            } else if (aiG.getIs_biggie()) {
                l(bhVar);
            } else {
                this.HF.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.HD;
    }

    public View getUserName() {
        return this.HE;
    }

    private void l(bh bhVar) {
        am.setBackgroundResource(this.HF, R.drawable.brand_official_btn);
        am.setViewTextColor(this.HF, (int) R.color.cp_cont_a);
        this.HF.setText(R.string.video_mcn);
        if (bhVar.ajG()) {
            this.HG.setVisibility(8);
        }
        this.HF.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.HO = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.HP = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.HD != null) {
            this.HD.setPageId(bdUniqueId);
        }
    }

    private void m(bh bhVar) {
        if (this.HI != null) {
            if (bhVar == null || (bhVar.getAddress() == null && bhVar.aiz() == 0)) {
                this.HI.setVisibility(8);
                return;
            }
            am.setViewTextColor(this.HI, (int) R.color.cp_cont_d);
            this.HI.setText(bhVar.aif());
            this.HI.setVisibility(aN(128) ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mf() {
        int width;
        if (aN(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.HE.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.HJ.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.HE.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, k(this.FT.aiG().getName_show(), 12)) + this.HE.getPaddingLeft() + this.HE.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, k(this.FT.aiG().getName_show(), 10)) + this.HE.getPaddingLeft() + this.HE.getPaddingRight();
            int measuredWidth = this.HH.getMeasuredWidth();
            int measuredWidth2 = this.HE.getMeasuredWidth();
            int measuredWidth3 = this.HJ.getMeasuredWidth();
            int measuredWidth4 = this.HF.getMeasuredWidth();
            int measuredWidth5 = this.HG.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.HE.setText(k(this.FT.aiG().getName_show(), 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.HE.setText(k(this.FT.aiG().getName_show(), 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.HG.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.HF.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.HH.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.HJ.setVisibility(8);
                }
            }
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.HK;
    }
}
