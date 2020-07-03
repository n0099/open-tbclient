package com.baidu.tbadk.core.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
/* loaded from: classes8.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bu aeK;
    protected TextView agZ;
    private int ahR;
    protected ImageView cpN;
    protected TextView dEA;
    private int dYs;
    protected ImageView edA;
    protected View edB;
    protected ab edC;
    protected TextView edD;
    protected LinearLayout edE;
    protected boolean edF;
    protected boolean edG;
    protected boolean edH;
    protected boolean edI;
    protected boolean edJ;
    protected boolean edK;
    protected boolean edL;
    protected boolean edM;
    protected boolean edN;
    protected boolean edO;
    protected boolean edP;
    private int edQ;
    public int edR;
    public String edS;
    private String edT;
    private View.OnClickListener edU;
    protected int edV;
    protected int edW;
    private b edX;
    private a edY;
    private boolean edZ;
    protected int edp;
    private TextView edq;
    protected AgreeView edr;
    protected ImageView eds;
    protected View edt;
    protected TextView edu;
    protected ImageView edv;
    protected View edw;
    protected FrameLayout edx;
    protected ImageView edy;
    protected TextView edz;
    CustomMessageListener eea;
    CustomMessageListener eeb;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;

    /* loaded from: classes8.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void hy(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.edT = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.edr != null) {
            this.edr.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.edQ = i;
    }

    public void setGameId(int i) {
        this.dYs = i;
        if (this.edr != null) {
            this.edr.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.edr != null) {
            this.edr.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eea);
        MessageManager.getInstance().registerListener(this.eeb);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eea);
        MessageManager.getInstance().unRegisterListener(this.eeb);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.edp = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ahR = 11;
        this.edF = false;
        this.edG = true;
        this.edH = true;
        this.edI = true;
        this.edJ = false;
        this.edK = false;
        this.edL = true;
        this.edM = false;
        this.edN = true;
        this.edO = false;
        this.edP = true;
        this.mFrom = 2;
        this.edQ = 1;
        this.mSkinType = 3;
        this.edX = null;
        this.edZ = true;
        this.eea = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bu)) {
                    bu buVar = (bu) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aeK != null && buVar != null) {
                        String str = buVar.getBaijiahaoData() != null ? buVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aeK.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aeK.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aeK.kG(buVar.aSg());
                                ThreadCommentAndPraiseInfoLayout.this.y(buVar);
                                return;
                            }
                            return;
                        }
                        String id = buVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aeK.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aeK.kG(buVar.aSg());
                            ThreadCommentAndPraiseInfoLayout.this.y(buVar);
                        }
                    }
                }
            }
        };
        this.eeb = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aeK != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aeK.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aeK.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aeK.aTG() || ThreadCommentAndPraiseInfoLayout.this.aeK.aTJ()) && ThreadCommentAndPraiseInfoLayout.this.aeK.aSJ() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aeK.aSJ() != null && ThreadCommentAndPraiseInfoLayout.this.aeK.aSJ().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aeK.aSJ().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aeK.ce(ThreadCommentAndPraiseInfoLayout.this.aeK.aTR() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.x(ThreadCommentAndPraiseInfoLayout.this.aeK);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.edp = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ahR = 11;
        this.edF = false;
        this.edG = true;
        this.edH = true;
        this.edI = true;
        this.edJ = false;
        this.edK = false;
        this.edL = true;
        this.edM = false;
        this.edN = true;
        this.edO = false;
        this.edP = true;
        this.mFrom = 2;
        this.edQ = 1;
        this.mSkinType = 3;
        this.edX = null;
        this.edZ = true;
        this.eea = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bu)) {
                    bu buVar = (bu) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aeK != null && buVar != null) {
                        String str = buVar.getBaijiahaoData() != null ? buVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aeK.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aeK.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aeK.kG(buVar.aSg());
                                ThreadCommentAndPraiseInfoLayout.this.y(buVar);
                                return;
                            }
                            return;
                        }
                        String id = buVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aeK.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aeK.kG(buVar.aSg());
                            ThreadCommentAndPraiseInfoLayout.this.y(buVar);
                        }
                    }
                }
            }
        };
        this.eeb = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aeK != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aeK.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aeK.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aeK.aTG() || ThreadCommentAndPraiseInfoLayout.this.aeK.aTJ()) && ThreadCommentAndPraiseInfoLayout.this.aeK.aSJ() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aeK.aSJ() != null && ThreadCommentAndPraiseInfoLayout.this.aeK.aSJ().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aeK.aSJ().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aeK.ce(ThreadCommentAndPraiseInfoLayout.this.aeK.aTR() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.x(ThreadCommentAndPraiseInfoLayout.this.aeK);
                    }
                }
            }
        };
        init(context);
    }

    protected View dL(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.edW = R.drawable.icon_home_card_share;
        this.edV = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.edp = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aYx();
    }

    protected void aYx() {
        ag(dL(this.mContext));
    }

    protected void ag(View view) {
        this.agZ = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.edq = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.dEA = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eds = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.edt = view.findViewById(R.id.thread_info_commont_container);
        this.edu = (TextView) view.findViewById(R.id.share_num);
        this.edv = (ImageView) view.findViewById(R.id.share_num_img);
        this.edw = view.findViewById(R.id.share_num_container);
        this.edx = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.edy = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.edr = (AgreeView) findViewById;
            this.edr.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.edU != null) {
                        ThreadCommentAndPraiseInfoLayout.this.edU.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.aeK);
                }
            });
        }
        this.edB = view.findViewById(R.id.manage_view_container);
        this.edz = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.edA = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.cpN = (ImageView) view.findViewById(R.id.manage_select_img);
        this.edD = (TextView) view.findViewById(R.id.manage_select_text);
        this.edE = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.edE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cpN.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.edD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.cpN.performClick();
            }
        });
        this.edE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.cpN.performClick();
            }
        });
        this.edt.setOnClickListener(this);
        this.edw.setOnClickListener(this);
        this.edB.setOnClickListener(this);
        this.cpN.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.ahR = i;
        sp();
    }

    private void sp() {
        int i;
        this.edw.setVisibility(isShow(1) ? 0 : 8);
        this.edt.setVisibility(isShow(2) ? 0 : 8);
        View view = this.edB;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.edr.setVisibility(isShow(8) ? 0 : 8);
        this.edr.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.ahR & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.agZ) {
            aX(view);
        } else if (view == this.edt) {
            aU(view);
        } else if (view == this.edw) {
            aV(view);
        } else if (view == this.edy) {
            aZ(view);
        } else if (view == this.edB) {
            aY(view);
        } else if (view == this.cpN) {
            aW(view);
        }
    }

    protected void aW(View view) {
        if (this.cpN != null && this.aeK != null && this.edD != null && !this.aeK.aUc()) {
            if (!this.aeK.aUa() && com.baidu.tieba.frs.b.bXc().bWW()) {
                if (com.baidu.tieba.frs.b.bXc().al(this.aeK)) {
                    this.aeK.ha(true);
                }
            } else if (!this.aeK.aUb() && com.baidu.tieba.frs.a.bWV().bWW()) {
                if (com.baidu.tieba.frs.a.bWV().al(this.aeK)) {
                    this.aeK.hb(true);
                }
            } else {
                com.baidu.tieba.frs.b.bXc().am(this.aeK);
                this.aeK.ha(false);
                com.baidu.tieba.frs.a.bWV().am(this.aeK);
                this.aeK.hb(false);
            }
            an.setViewTextColor(this.edD, (this.aeK.aUa() || this.aeK.aUb()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cpN.setImageDrawable(an.getDrawable((this.aeK.aUa() || this.aeK.aUb()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.edX != null) {
                this.edX.hy(this.aeK.aUa() || this.aeK.aUb());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.edt != null) {
            this.edt.setClickable(z);
            this.eds.setEnabled(z);
            this.dEA.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.edw != null) {
            this.edw.setClickable(z);
            this.edv.setEnabled(z);
            this.edu.setEnabled(z);
        }
    }

    private void aX(View view) {
        if (this.aeK != null && !StringUtils.isNull(this.aeK.aSt())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.edT)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.aeK.aSt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aeK.aSt(), this.mStType, this.edT)));
            }
            if (this.edU != null) {
                this.edU.onClick(view);
            }
        }
    }

    private boolean u(bu buVar) {
        return (buVar == null || !buVar.aQV() || buVar.aSH() == null) ? false : true;
    }

    protected void aU(View view) {
        if (this.aeK != null && this.mContext != null) {
            m.DO(this.aeK.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aeK, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aeK.getFid()));
            addLocateParam.setForumName(this.aeK.aSt());
            if (this.aeK.aUe() && this.aeK.aUd() != null) {
                addLocateParam.setForumId(this.aeK.aUd().getForumId());
                addLocateParam.setForumName(this.aeK.aUd().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.edY != null) {
                this.edY.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && u(this.aeK)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.k.an(this.aeK);
            }
            if (this.aeK.dOv) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.aeK.aTw() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.edR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ao aoVar = new ao("c12291");
            aoVar.ag("obj_locate", this.mFrom);
            TiebaStatic.log(aoVar);
            ao aoVar2 = new ao("c12942");
            aoVar2.ag("obj_locate", this.mFrom);
            aoVar2.ag("obj_type", getThreadType());
            aoVar2.dk("tid", this.aeK.getTid());
            aoVar2.dk("nid", this.aeK.getNid());
            if (this.mFrom == 18) {
                aoVar2.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar2.s("fid", this.aeK.getFid());
                aoVar2.ag("obj_locate", 18);
                aoVar2.dk("resource_id", this.mTabName);
            }
            TiebaStatic.log(aoVar2);
            aYy();
            a(view, this.aeK);
            if (this.edU != null) {
                this.edU.onClick(view);
            }
        }
    }

    private void aYy() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            ao aoVar = new ao("c13568");
            aoVar.ag("obj_source", threadSourceForDynamicAndBjh);
            aoVar.ag("obj_type", threadTypeForDynamicAndBjh);
            TiebaStatic.log(aoVar);
        }
    }

    private int getThreadSourceForDynamicAndBjh() {
        if (this.mFrom == 4 || this.mFrom == 9) {
            return 1;
        }
        if (this.mFrom == 1) {
            return 2;
        }
        if (this.mFrom == 8 || this.mFrom == 13) {
            return 3;
        }
        return 0;
    }

    private int getThreadTypeForDynamicAndBjh() {
        if (this.aeK == null) {
            return 0;
        }
        if (this.aeK.aQX()) {
            return 1;
        }
        if (this.aeK.aQY()) {
            return 2;
        }
        if (this.aeK.aUl()) {
            return 3;
        }
        return this.aeK.aUm() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.aeK == null) {
            return 0;
        }
        if (this.aeK.isShareThread) {
            return 4;
        }
        if (this.aeK.getThreadType() == 49) {
            return 5;
        }
        if (this.aeK.aSH() != null) {
            return 1;
        }
        if (this.aeK.getType() == bu.dLm || this.aeK.getType() == bu.dLG) {
            if (w.getCount(this.aeK.aSC()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aeK != null || i >= 0) {
            ao mu = mu(i);
            mu.ag("thread_type", this.aeK.getThreadType());
            TiebaStatic.log(mu);
        }
    }

    private ao mu(int i) {
        if (this.aeK == null && i < 0) {
            return null;
        }
        ao aoVar = new ao("c12003");
        aoVar.dk("tid", this.aeK.getTid());
        if (this.aeK.getThreadType() == 40) {
            aoVar.dk("obj_param1", "2");
        } else if (this.aeK.getThreadType() == 0) {
            aoVar.dk("obj_param1", "1");
        }
        aoVar.dk("obj_source", "1");
        aoVar.s("fid", this.aeK.getFid());
        aoVar.ag("obj_locate", this.mFrom);
        aoVar.ag("obj_id", i);
        if (!ar.isEmpty(this.edS)) {
            aoVar.dk("obj_floor", this.edS);
        }
        if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aoVar.dk("nid", this.aeK.getNid());
        aoVar.ag(IntentConfig.CARD_TYPE, this.aeK.aUp());
        aoVar.dk(IntentConfig.RECOM_SOURCE, this.aeK.mRecomSource);
        aoVar.dk("ab_tag", this.aeK.mRecomAbTag);
        aoVar.dk("weight", this.aeK.mRecomWeight);
        aoVar.dk("extra", this.aeK.mRecomExtra);
        if (this.aeK.getBaijiahaoData() != null && !ar.isEmpty(this.aeK.getBaijiahaoData().oriUgcVid)) {
            aoVar.dk("obj_param6", this.aeK.getBaijiahaoData().oriUgcVid);
            return aoVar;
        }
        return aoVar;
    }

    protected void aV(View view) {
        if ((ShareSwitch.isOn() || be.checkUpIsLogin(this.mContext)) && this.aeK != null) {
            aYz();
            a(view, this.aeK);
            if (!AntiHelper.d(getContext(), this.aeK)) {
                aYB();
                if (this.edU != null) {
                    this.edU.onClick(view);
                }
            }
        }
    }

    private void aYz() {
        if (this.aeK != null) {
            ao aYA = aYA();
            aYA.ag("thread_type", this.aeK.getThreadType());
            TiebaStatic.log(aYA);
        }
    }

    private ao aYA() {
        if (this.aeK == null) {
            return null;
        }
        int i = 0;
        if (this.edQ == 1) {
            i = 4;
        } else if (this.edQ == 2) {
            i = 5;
        } else if (this.edQ == 3) {
            i = 3;
        } else if (this.edQ == 4) {
            i = 2;
        } else if (this.edQ == 6) {
            i = 8;
        } else if (this.edQ == 7) {
            i = 9;
        } else if (this.edQ == 9) {
            i = 10;
        } else if (this.edQ == 10) {
            i = 17;
        } else if (this.edQ == 18) {
            i = 20;
        }
        ao aoVar = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aoVar.s("fid", this.aeK.getFid());
        aoVar.dk("tid", this.aeK.getTid());
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        aoVar.ag("obj_locate", i);
        aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, this.dYs);
        if (!ar.isEmpty(this.edS)) {
            aoVar.dk("obj_floor", this.edS);
        }
        if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.aeK.aSJ() != null && this.aeK.aSJ().user_info != null && this.aeK.aSJ().user_info.is_official == 2) {
            aoVar.ag("obj_isofficial", this.aeK.aSJ().user_info.is_official);
        }
        aoVar.ag(IntentConfig.CARD_TYPE, this.aeK.aUp()).dk("ab_tag", this.aeK.mRecomAbTag).dk(IntentConfig.RECOM_SOURCE, this.aeK.mRecomSource).dk("weight", this.aeK.mRecomWeight).dk("extra", this.aeK.mRecomExtra);
        if (this.aeK.aQX()) {
            aoVar.ag("obj_type", 10);
        } else if (this.aeK.aQY()) {
            aoVar.ag("obj_type", 9);
        } else if (this.aeK.aUm()) {
            aoVar.ag("obj_type", 8);
        } else if (this.aeK.aUl()) {
            aoVar.ag("obj_type", 7);
        } else if (this.aeK.isShareThread) {
            aoVar.ag("obj_type", 6);
        } else if (this.aeK.threadType == 0) {
            aoVar.ag("obj_type", 1);
        } else if (this.aeK.threadType == 40) {
            aoVar.ag("obj_type", 2);
        } else if (this.aeK.threadType == 49) {
            aoVar.ag("obj_type", 3);
        } else if (this.aeK.threadType == 54) {
            aoVar.ag("obj_type", 4);
        } else {
            aoVar.ag("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            aoVar.dk("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            aoVar.dk("obj_tab", "a099");
            aoVar.dk("resource_id", this.mTabName);
        }
        if (this.aeK.getBaijiahaoData() != null) {
            aoVar.dk("obj_param4", this.aeK.getBaijiahaoData().oriUgcNid);
            if (this.aeK.aQY() || this.aeK.aUm()) {
                aoVar.dk("obj_param6", this.aeK.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.aeK.aUk()) {
            aoVar.ag("obj_param5", 2);
        } else if (this.aeK.aQX() || this.aeK.aQY()) {
            aoVar.ag("obj_param5", 3);
        } else if (this.aeK.threadType == 0 || this.aeK.threadType == 40) {
            aoVar.ag("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), aoVar);
        }
        aoVar.dk("nid", this.aeK.getNid());
        return aoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bu buVar) {
        int i;
        int i2 = 1;
        if (buVar != null) {
            int id = view.getId();
            if (id == R.id.thread_info_commont_container) {
                i = 3;
            } else if (id == R.id.share_num_container) {
                i = 4;
            } else if (id == R.id.img_agree) {
                i = 1;
            } else {
                i = id == R.id.img_disagree ? 2 : 0;
            }
            switch (this.mFrom) {
                case 1:
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    i2 = 0;
                    break;
                case 4:
                case 9:
                    i2 = 3;
                    break;
                case 8:
                    i2 = 4;
                    break;
            }
            if (i > 0 && i2 > 0) {
                TiebaStatic.log(com.baidu.tieba.s.a.a("c13694", buVar, i2, i));
            }
        }
    }

    private void aYB() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.aeK != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aeK.getFid());
            String aSt = this.aeK.aSt();
            if (this.aeK.dOi != null) {
                valueOf = this.aeK.dOi.id;
                aSt = this.aeK.dOi.ori_fname;
            }
            String title = this.aeK.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aeK.getAbstract();
            }
            if (this.aeK.aQZ()) {
                tid = this.aeK.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.aeK.getBaijiahaoData().oriUgcType + "&dvid=" + this.aeK.getBaijiahaoData().oriUgcVid + "&nid=" + this.aeK.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.aeK.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.aeK.aSJ() != null && this.aeK.aSJ().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.aeK.aSJ().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.aeK.aSJ().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String A = A(this.aeK);
            Uri parse = A == null ? null : Uri.parse(A);
            String str4 = this.aeK.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.aeK.aQZ() || this.aeK.aSp() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.aeK.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.aeK.aSp().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = ar.cutString(title, 100);
            String cutString2 = ar.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int B = B(this.aeK);
            if (this.aeK.aQZ()) {
                shareItem.readCount = -1L;
                shareItem.enE = cutString2;
            } else {
                if (B == 2 && this.aeK.aSH() != null) {
                    shareItem.readCount = this.aeK.aSH().play_count.intValue();
                } else if (B == 1) {
                    shareItem.readCount = this.aeK.aSh();
                }
                shareItem.enE = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aSt;
            shareItem.tid = tid;
            shareItem.enu = true;
            shareItem.dOP = this.edQ;
            shareItem.enG = getShareObjSource();
            shareItem.enL = B;
            shareItem.enH = 3;
            shareItem.enI = z(this.aeK);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.aeK.aQZ()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.enV = this.aeK.getShareImageUrl();
            }
            aYC();
            shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aeK);
            if (this.mFrom == 13) {
                shareItem.enP = ShareItem.ForwardInfo.generateForwardInfo(this.aeK, 2);
            } else {
                shareItem.enP = ShareItem.ForwardInfo.generateForwardInfo(this.aeK);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.enH);
            bundle.putInt("obj_type", shareItem.enL);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dOP);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.aeK.getThreadType() == 49 || this.aeK.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.f.bPD().b(shareDialogConfig);
        }
    }

    private void aYC() {
        ItemInfo bXp;
        if ((this.mContext instanceof am) && ((am) this.mContext).bXq() && this.aeK != null && this.aeK.aUu() == null && (bXp = ((am) this.mContext).bXp()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(bXp.id.longValue());
            builder.item_name = bXp.name;
            builder.icon_size = bXp.icon_size;
            builder.icon_url = bXp.icon_url;
            builder.tags = bXp.tags;
            if (bXp.score != null && bXp.score.item_point != null) {
                Iterator<ItemPoint> it = bXp.score.item_point.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ItemPoint next = it.next();
                    if (next.time_intval.equals(SchemeCollecter.CLASSIFY_ALL)) {
                        builder.score = next.point;
                        builder.star = Integer.valueOf((int) (next.point.doubleValue() / 2.0d));
                        break;
                    }
                }
            }
            Item build = builder.build(false);
            ItemData itemData = new ItemData();
            itemData.parseProto(build);
            this.aeK.a(itemData);
        }
    }

    private int z(bu buVar) {
        if (buVar == null) {
            return 0;
        }
        if (buVar.aQX()) {
            return 10;
        }
        if (buVar.aQY()) {
            return 9;
        }
        if (buVar.aUm()) {
            return 8;
        }
        if (buVar.aUl()) {
            return 7;
        }
        if (buVar.isShareThread) {
            return 6;
        }
        if (buVar.threadType == 0) {
            return 1;
        }
        if (buVar.threadType == 40) {
            return 2;
        }
        if (buVar.threadType == 49) {
            return 3;
        }
        if (buVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private void a(ShareDialogConfig shareDialogConfig) {
        switch (this.mFrom) {
            case 1:
                shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
                return;
            case 2:
                shareDialogConfig.setFrom(ShareDialogConfig.From.FRS);
                return;
            case 3:
            case 5:
            case 6:
            case 10:
            case 11:
            case 14:
            case 15:
            default:
                shareDialogConfig.setFrom(ShareDialogConfig.From.Default);
                return;
            case 4:
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                return;
            case 7:
                shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
                return;
            case 8:
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                return;
            case 9:
                shareDialogConfig.setFrom(ShareDialogConfig.From.Concern);
                return;
            case 12:
                shareDialogConfig.setFrom(ShareDialogConfig.From.HomeGameTab);
                return;
            case 13:
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                return;
            case 16:
                shareDialogConfig.setFrom(ShareDialogConfig.From.HomeVideoTab);
                return;
        }
    }

    private int getShareObjSource() {
        if (this.edQ == 1) {
            return 5;
        }
        if (this.edQ != 3) {
            if (this.edQ == 4) {
                return 4;
            }
            if (this.edQ == 6) {
                return 8;
            }
            if (this.edQ != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String A(bu buVar) {
        String str;
        if (buVar == null) {
            return null;
        }
        if (buVar.aSJ() != null && !TextUtils.isEmpty(buVar.aSJ().cover)) {
            return buVar.aSJ().cover;
        }
        if (buVar.aSy() == null) {
            return null;
        }
        ArrayList<MediaData> aSy = buVar.aSy();
        int size = aSy.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aSy.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    str = mediaData.getThumbnails_url();
                    break;
                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                    break;
                }
            }
            i++;
        }
        if (str == null && buVar.aSH() != null && !TextUtils.isEmpty(buVar.aSH().thumbnail_url)) {
            return buVar.aSH().thumbnail_url;
        }
        return str;
    }

    private int B(bu buVar) {
        if (buVar != null) {
            if (buVar.aSr()) {
                return 4;
            }
            if (buVar.aSm() == 1) {
                return 3;
            }
            if (buVar.aQX()) {
                return 5;
            }
            if (buVar.aQY()) {
                return 6;
            }
            if (buVar.aUl()) {
                return 7;
            }
            if (buVar.aUm()) {
                return 8;
            }
            if (!buVar.isShareThread || buVar.dNX == null) {
                return buVar.aTH() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aY(View view) {
        if (this.edC == null) {
            this.edC = new ab(this.mPageContext, isShow(16));
        }
        this.edC.setData(this.aeK);
        this.edC.showDialog();
        if (this.aeK != null) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).s("uid", TbadkCoreApplication.getCurrentAccountId()).s("fid", this.aeK.getFid()).dk("tid", this.aeK.getId()));
        }
    }

    private void aZ(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.edI = z;
        if (this.agZ != null) {
            this.agZ.setClickable(this.edI);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(bu buVar) {
        if (buVar == null) {
            setVisibility(8);
            return false;
        }
        this.aeK = buVar;
        aYu();
        C(buVar);
        E(buVar);
        y(buVar);
        x(buVar);
        updatePraiseNum(buVar);
        D(buVar);
        F(buVar);
        setVisibility(this.edF ? 0 : 8);
        aYv();
        return this.edF;
    }

    protected void aYv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aYu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(bu buVar) {
        this.agZ.setVisibility(8);
    }

    protected void D(bu buVar) {
        if (this.edE != null && this.cpN != null && this.edD != null && buVar != null) {
            if (!this.edZ) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.edE.setVisibility(8);
            } else if (this.edP && (com.baidu.tieba.frs.b.bXc().bWW() || com.baidu.tieba.frs.a.bWV().bWW())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    an.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cpN.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cpN.performClick();
                        }
                    });
                }
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMaskView.getLayoutParams();
                if (layoutParams == null) {
                    this.mMaskView.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, -1));
                } else {
                    layoutParams.width = equipmentWidth;
                    requestLayout();
                }
                an.setViewTextColor(this.edD, (this.aeK.aUa() || this.aeK.aUb()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cpN.setImageDrawable(an.getDrawable((buVar.aUa() || this.aeK.aUb()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.edE.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.edE.setVisibility(8);
            }
        }
    }

    private void E(bu buVar) {
        String aRS;
        if (this.edq != null && buVar != null) {
            if (buVar.aSi() <= 0 || !this.edG) {
                this.edq.setVisibility(8);
                return;
            }
            this.edq.setVisibility(0);
            if (this.mFrom == 3) {
                aRS = buVar.aRT();
            } else {
                aRS = buVar.aRS();
            }
            this.edq.setText(aRS);
            this.edF = true;
        }
    }

    public boolean isVisible() {
        return this.edF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(bu buVar) {
        if (this.dEA != null && buVar != null) {
            if (this.edL) {
                this.edt.setVisibility(0);
                if (buVar.aSg() > 0) {
                    this.dEA.setVisibility(0);
                    String numFormatOverWan = ar.numFormatOverWan(buVar.aSg());
                    if (this.edJ) {
                        updateReplyStateUI();
                        this.dEA.setText(numFormatOverWan);
                    } else {
                        this.dEA.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dEA.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.edF = true;
                    return;
                } else if (this.edJ) {
                    updateReplyStateUI();
                    this.dEA.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dEA.setVisibility(0);
                    this.edF = true;
                    return;
                } else {
                    this.dEA.setVisibility(8);
                    return;
                }
            }
            this.edt.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.edJ) {
            SvgManager.aWQ().a(this.eds, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        an.setViewTextColor(this.dEA, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bu buVar) {
        setAgreeViewType(buVar);
        if (buVar.aUg() != null) {
            buVar.aUg().isInThread = true;
            this.edr.setCardType(buVar.aUp());
            this.edr.setThreadData(buVar);
            this.edr.setData(buVar.aUg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(bu buVar) {
        if (this.edw != null && this.edu != null && buVar != null) {
            if (this.edN) {
                this.edw.setVisibility(0);
                long aTR = buVar.aTR();
                if ((buVar.aTG() || buVar.aTJ()) && buVar.aSJ() != null && buVar.aSJ().share_info != null) {
                    aTR = buVar.aSJ().share_info.share_count;
                }
                this.edu.setText(aTR > 0 ? ar.numFormatOverWan(aTR) : this.mContext.getString(R.string.share));
                this.edF = true;
                updateShareStateUI(buVar);
                return;
            }
            this.edw.setVisibility(8);
        }
    }

    public void updateShareStateUI(bu buVar) {
        if (AntiHelper.ba(buVar)) {
            setShareClickable(true);
            SvgManager.aWQ().a(this.edv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            an.setViewTextColor(this.edu, (int) R.color.cp_cont_e);
        } else if (buVar != null && buVar.dNX != null && this.aeK.dNX.dID) {
            setShareClickable(false);
            SvgManager.aWQ().a(this.edv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            an.setViewTextColor(this.edu, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aWQ().a(this.edv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            an.setViewTextColor(this.edu, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void F(bu buVar) {
        if (this.edB != null && buVar != null) {
            this.edO = isShow(4);
            if (buVar.dOi != null) {
                this.edO = false;
            }
            if (this.edO && (this.edE == null || this.edE.getVisibility() == 8)) {
                this.edB.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.edz.setText(string);
                this.edz.setContentDescription(string);
                this.edF = true;
                return;
            }
            this.edB.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.edr != null) {
            this.edr.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            an.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            an.setViewTextColor(this.agZ, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.edq, (int) R.color.cp_cont_j);
            an.setViewTextColor(this.edz, (int) R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.aeK);
            SvgManager.aWQ().a(this.edy, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aWQ().a(this.edA, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.edC != null) {
                this.edC.onChangeSkinType();
            }
            if (this.edr != null) {
                this.edr.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.edU = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.agZ;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.edM = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.edG = z;
    }

    public View getCommentNumView() {
        return this.dEA;
    }

    public View getCommentContainer() {
        return this.edt;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.edJ = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.edK = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.edN = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eds.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.eds.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.edN = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eds.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.eds.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.edP = z;
    }

    public void setManageVisible(boolean z) {
        this.edO = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.edX = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.cpN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.edZ = z;
    }

    public boolean isInFrsAllThread() {
        return this.edZ;
    }

    public void setShowCommonView() {
        setReplyTimeVisible(false);
        setIsBarViewVisible(false);
        setShowPraiseNum(true);
        setNeedAddPraiseIcon(true);
        setNeedAddReplyIcon(true);
        setShareVisible(true);
    }

    public void onDestroy() {
        if (this.edC != null) {
            this.edC.destory();
        }
    }

    public void setAgreeViewType(bu buVar) {
        if (buVar != null && buVar.aQZ()) {
            this.edr.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.edr.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.edY = aVar;
    }
}
