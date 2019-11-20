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
    private bh Fs;
    private HeadPendantClickableView Hd;
    private TextView He;
    private TextView Hf;
    private UserIconBox Hg;
    private UserIconBox Hh;
    private TextView Hi;
    private TextView Hj;
    protected RelativeLayout Hk;
    private ImageView Hl;
    private View Hm;
    private FrameLayout Hn;
    private View.OnClickListener Ho;
    private View.OnClickListener Hp;
    private View Hq;
    private int Hr;
    private Runnable Hs;
    private View.OnClickListener Ht;
    private View.OnClickListener Hu;
    private View.OnClickListener Hv;
    private Context mContext;
    private int mSkinType;

    public CardUserInfoLayout(Context context) {
        this(context, null);
    }

    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.Hr = 1285;
        this.Hs = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.mf();
            }
        };
        this.Ht = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.Fs != null && CardUserInfoLayout.this.Fs.aiE() != null && CardUserInfoLayout.this.Fs.aiE().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.Fs.aiE().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.Fs.aiE().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.amO().b((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Hu = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Fs != null && CardUserInfoLayout.this.Fs.aiE() != null && !StringUtils.isNull(CardUserInfoLayout.this.Fs.aiE().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.Fs.aiE().getUserId()) && CardUserInfoLayout.this.Fs.aiJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (CardUserInfoLayout.this.Fs.ajN() != null && CardUserInfoLayout.this.Fs.ajN().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.Fs.ajN().channelId, CardUserInfoLayout.this.Fs.ajN().Zv)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.Fs.aiE().getUserId(), CardUserInfoLayout.this.Fs.aiE().getName_show(), CardUserInfoLayout.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.Fs.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (CardUserInfoLayout.this.Ho != null) {
                        CardUserInfoLayout.this.Ho.onClick(view);
                    }
                }
            }
        };
        this.Hv = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Fs != null && CardUserInfoLayout.this.Fs.aiE() != null) {
                    a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.Fs.aiE().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.Hp != null) {
                        CardUserInfoLayout.this.Ho.onClick(view);
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
        this.Hr = i;
        mc();
    }

    private void mc() {
        this.Hh.setVisibility(aN(1) ? 0 : 8);
        this.He.setVisibility(aN(4) ? 0 : 8);
        this.Hf.setVisibility(aN(16) ? 0 : 8);
        this.Hj.setVisibility(aN(8) ? 0 : 8);
        this.Hg.setVisibility(aN(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Hq.getLayoutParams();
        if (aN(128)) {
            this.Hi.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.Hi.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.Hq.setLayoutParams(layoutParams);
        if (aN(64)) {
            this.Hn.setVisibility(0);
            this.Hm = b.afa().l(getContext(), 1);
            if (this.Hm != null) {
                this.Hm.setVisibility(8);
                this.Hn.addView(this.Hm);
            }
        } else {
            this.Hn.setVisibility(8);
        }
        this.Hl.setVisibility(aN(4096) ? 0 : 8);
    }

    private boolean aN(int i) {
        return (this.Hr & i) > 0;
    }

    private void md() {
        this.Hd = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.Hd.setHasPendantStyle();
        this.Hd.getHeadView().setIsRound(true);
        this.Hd.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Hd.getHeadView().setDefaultResource(17170445);
        this.Hd.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.Hd.getHeadView().setDefaultBgResource(e.Vj());
        this.Hd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Ho != null) {
                    CardUserInfoLayout.this.Ho.onClick(view);
                }
            }
        });
        this.Hh = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.Hh.setOnClickListener(this.Ht);
        this.He = (TextView) findViewById(R.id.user_name);
        this.He.setOnClickListener(this.Hu);
        this.Hf = (TextView) findViewById(R.id.identity_view);
        this.Hj = (TextView) findViewById(R.id.thread_share_intro);
        this.Hg = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.Hg.setOnClickListener(this.Hv);
        this.Hi = (TextView) findViewById(R.id.thread_extend_info);
        this.Hn = (FrameLayout) findViewById(R.id.ala_live_info_content_layout);
        this.Hq = findViewById(R.id.user_name_and_reply_time);
        this.Hk = (RelativeLayout) findViewById(R.id.suffix_container);
        this.Hl = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.Hd.getHeadView().setDefaultBgResource(e.Vj());
        }
    }

    private void c(bh bhVar) {
        if (this.Hd != null && bhVar != null && this.Fs.aiE() != null) {
            if (!aN(1024)) {
                this.Hd.V(false);
            } else if (this.Fs.cdj > 0 && this.Fs.cdk == 0) {
                this.Hd.V(false);
            } else {
                this.Hd.V(this.Fs.aiE().isBigV());
            }
        }
    }

    public void setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return;
        }
        this.Fs = bhVar;
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
            this.Hq.post(this.Hs);
        }
    }

    private void d(bh bhVar) {
        if (aN(4096) && bhVar != null && this.Hl != null) {
            if (bhVar.cdL) {
                this.Hl.setVisibility(0);
            } else {
                this.Hl.setVisibility(8);
            }
        }
    }

    private void e(bh bhVar) {
        if (bhVar.aiE() == null) {
            this.Hd.setVisibility(8);
            return;
        }
        MetaData aiE = bhVar.aiE();
        if (!aN(256)) {
            aiE.setPendantData(null);
        }
        this.Hd.setData(bhVar);
    }

    private void f(bh bhVar) {
        if (bhVar != null && bhVar.aiE() != null && bhVar.aiE().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bhVar.aiE().getAlaUserData();
            if (this.Hm != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.bTc = alaUserData;
                aVar.type = 1;
                this.Hm.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.Hm.setVisibility(8);
                } else {
                    this.Hm.setVisibility(0);
                }
            }
        } else if (this.Hm != null) {
            this.Hm.setVisibility(8);
        }
    }

    private void g(bh bhVar) {
        if (this.He != null && bhVar != null) {
            if (!StringUtils.isNull(this.Fs.aic())) {
                this.He.setText(this.Fs.aic());
            } else {
                this.He.setText(R.string.user_name_default_txt);
            }
            me();
        }
    }

    protected void h(bh bhVar) {
        if (this.Hj != null) {
            if (bhVar == null || (!aN(8) && !aN(512))) {
                this.Hj.setVisibility(8);
            } else if (this.Fs.getType() == bh.ccp) {
                this.Hj.setVisibility(0);
                this.Hj.getPaint().setFakeBoldText(true);
                this.Hj.setText(this.mContext.getString(R.string.interview_live_info_tip_is_live));
                am.setViewTextColor(this.Hj, (int) R.color.cp_cont_b);
            } else if (aN(8)) {
                if (StringUtils.isNull(bhVar.agH())) {
                    this.Hj.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Hj.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.Hj.setLayoutParams(layoutParams);
                }
                this.Hj.setText(bhVar.agH());
                this.Hj.setVisibility(0);
            } else if (StringUtils.isNull(this.Fs.aie())) {
                this.Hj.setVisibility(8);
            } else {
                this.Hj.setVisibility(0);
                this.Hj.setText(this.Fs.aie());
            }
        }
    }

    private void i(bh bhVar) {
        if (this.Hg != null) {
            if (!aN(32)) {
                this.Hg.setVisibility(8);
            } else if (bhVar == null || bhVar.aiE() == null || (bhVar.cdj > 0 && bhVar.cdk == 0)) {
                this.Hg.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bhVar.aiE().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.Hg.setVisibility(0);
                    this.Hg.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.Hg.setVisibility(8);
            }
        }
    }

    protected String k(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void me() {
        if (this.Fs != null && this.Fs.aiE() != null) {
            if (this.Fs.cdj > 0 && this.Fs.cdk == 0) {
                am.setViewTextColor(this.He, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.Fs.aiE().getTShowInfoNew())) {
                am.setViewTextColor(this.He, (int) R.color.cp_cont_h);
            } else if (this.Fs.aiE().isBigV()) {
                if (aN(1024)) {
                    am.setViewTextColor(this.He, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.He, (int) R.color.cp_cont_f);
                }
            } else {
                am.setViewTextColor(this.He, (int) R.color.cp_cont_f);
            }
        }
    }

    private void j(bh bhVar) {
        if (this.Hh != null && bhVar != null && bhVar.aiE() != null && aN(1)) {
            ArrayList<IconData> tShowInfoNew = bhVar.aiE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.Hh.setVisibility(0);
                this.Hh.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.Hh.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.Hf != null && bhVar != null && bhVar.aiE() != null && aN(16)) {
            MetaData aiE = bhVar.aiE();
            if (aiE.getIs_bawu() == 1) {
                am.setBackgroundResource(this.Hf, R.drawable.brand_official_btn);
                am.setViewTextColor(this.Hf, (int) R.color.cp_cont_a);
                if (bhVar.cdw) {
                    this.Hf.setVisibility(0);
                    this.Hf.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aiE.getBawu_type())) {
                    this.Hf.setVisibility(0);
                    this.Hf.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aiE.getBawu_type())) {
                    this.Hf.setText(R.string.bawu_member_xbazhu_tip);
                    this.Hf.setVisibility(0);
                } else if ("pri_content_assist".equals(aiE.getBawu_type())) {
                    this.Hf.setText(R.string.bawu_content_assist_tip);
                    this.Hf.setVisibility(0);
                } else if ("pri_manage_assist".equals(aiE.getBawu_type())) {
                    this.Hf.setText(R.string.bawu_manage_assist_tip);
                    this.Hf.setVisibility(0);
                } else if (aiE.getIs_biggie()) {
                    l(bhVar);
                } else {
                    this.Hf.setVisibility(8);
                }
            } else if (aiE.getIs_biggie()) {
                l(bhVar);
            } else {
                this.Hf.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.Hd;
    }

    public View getUserName() {
        return this.He;
    }

    private void l(bh bhVar) {
        am.setBackgroundResource(this.Hf, R.drawable.brand_official_btn);
        am.setViewTextColor(this.Hf, (int) R.color.cp_cont_a);
        this.Hf.setText(R.string.video_mcn);
        if (bhVar.ajE()) {
            this.Hg.setVisibility(8);
        }
        this.Hf.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Ho = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.Hp = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.Hd != null) {
            this.Hd.setPageId(bdUniqueId);
        }
    }

    private void m(bh bhVar) {
        if (this.Hi != null) {
            if (bhVar == null || (bhVar.getAddress() == null && bhVar.aix() == 0)) {
                this.Hi.setVisibility(8);
                return;
            }
            am.setViewTextColor(this.Hi, (int) R.color.cp_cont_d);
            this.Hi.setText(bhVar.aid());
            this.Hi.setVisibility(aN(128) ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mf() {
        int width;
        if (aN(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.He.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.Hj.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.He.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, k(this.Fs.aiE().getName_show(), 12)) + this.He.getPaddingLeft() + this.He.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, k(this.Fs.aiE().getName_show(), 10)) + this.He.getPaddingLeft() + this.He.getPaddingRight();
            int measuredWidth = this.Hh.getMeasuredWidth();
            int measuredWidth2 = this.He.getMeasuredWidth();
            int measuredWidth3 = this.Hj.getMeasuredWidth();
            int measuredWidth4 = this.Hf.getMeasuredWidth();
            int measuredWidth5 = this.Hg.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.He.setText(k(this.Fs.aiE().getName_show(), 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.He.setText(k(this.Fs.aiE().getName_show(), 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.Hg.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.Hf.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.Hh.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.Hj.setVisibility(8);
                }
            }
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.Hk;
    }
}
