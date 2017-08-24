package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.DislikeInfo;
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PbContent;
import tbclient.PollInfo;
import tbclient.ReportInfo;
import tbclient.SkinInfo;
import tbclient.ThreadInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class bl extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.f, com.baidu.tbadk.core.util.ad {
    public TwZhiBoUser XC;
    public List<TwAnchorProfitItem> XD;
    private SpannableStringBuilder ZA;
    public int ZE;
    private int ZF;
    private int ZH;
    private String ZK;
    private int ZL;
    private String ZM;
    private int ZO;
    private VideoInfo ZQ;
    private bq ZR;
    private c ZS;
    private boolean aaA;
    private boolean aaB;
    public String aaC;
    public String aaD;
    public String aaE;
    public long aaF;
    public String aaH;
    private List<ReportInfo> aaK;
    private p aaQ;
    private boolean aaR;
    private int aaT;
    private aj aaV;
    public d aaX;
    private MediaData aaY;
    private n aaa;
    private LiveCoverStatus aag;
    private long aah;
    private SkinInfo aas;
    private boolean aau;
    private String aav;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    private String latitude;
    private long mCreateTime;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Zc = BdUniqueId.gen();
    public static final BdUniqueId Zd = BdUniqueId.gen();
    public static final BdUniqueId Ze = BdUniqueId.gen();
    public static final BdUniqueId Zf = BdUniqueId.gen();
    public static final BdUniqueId Zg = BdUniqueId.gen();
    public static final BdUniqueId Zh = BdUniqueId.gen();
    public static final BdUniqueId Zi = BdUniqueId.gen();
    public static final BdUniqueId Zj = BdUniqueId.gen();
    public static final BdUniqueId Zk = BdUniqueId.gen();
    public static AtomicBoolean Zl = new AtomicBoolean(false);
    public static AtomicBoolean Zm = new AtomicBoolean(false);
    public static AtomicBoolean Zn = new AtomicBoolean(false);
    public static final BdUniqueId Zo = BdUniqueId.gen();
    public static final BdUniqueId Zp = BdUniqueId.gen();
    public static final BdUniqueId Zq = BdUniqueId.gen();
    private static HashMap<Point, Integer> aab = new HashMap<>();
    private static HashMap<Integer, Integer> aac = new HashMap<>();
    public static final BdUniqueId aan = BdUniqueId.gen();
    public static final BdUniqueId aao = BdUniqueId.gen();
    public static final BdUniqueId aat = BdUniqueId.gen();
    private static HashMap<Point, Integer> aaL = new HashMap<>();
    private static SparseArray<m.a> aaM = new SparseArray<>(3);
    public int Zr = 1;
    private String ZG = null;
    private int VY = 0;
    public int ZU = 0;
    private String ZV = "";
    private String aad = "";
    public boolean aaG = true;
    public boolean aaN = false;
    public boolean aaO = false;
    private int aaP = -1;
    private SparseArray<String> XW = null;
    public boolean aaW = false;
    private String id = null;
    private String XV = null;
    private long fid = 0;
    private String title = null;
    private int ZT = 0;
    private int reply_num = 0;
    private int Zs = 0;
    private int view_num = 0;
    private String last_time = null;
    private long Zt = 0;
    private int Zu = 0;
    private int Zv = 0;
    private int Zw = 0;
    private bo Zx = new bo();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> ZC = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> ZD = new ArrayList<>();
    private int Zy = 0;
    private int Zz = 0;
    private String ad_url = null;
    private String ZB = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData ZI = new PraiseData();
    private AnchorInfoData ZJ = new AnchorInfoData();
    private long time = 0;
    private int ZN = 0;
    private ArrayList<a> ZX = new ArrayList<>();
    private bu ZY = null;
    private e ZZ = null;
    private int aae = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> ZP = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aaf = null;
    private int ZW = 0;
    private PollInfo aai = null;
    private boolean aaj = false;
    private boolean aak = false;
    private int aal = 0;
    private boolean aam = false;
    private int anchorLevel = 0;
    public int aaw = 0;
    public k aax = new k();
    private List<PbContent> aay = new ArrayList();
    private List<PbContent> aaz = new ArrayList();
    private String category_name = null;
    private bj aap = new bj();
    private ArrayList<com.baidu.tbadk.data.a> aaq = new ArrayList<>();
    private PushStatusData aar = new PushStatusData();
    public boolean aaI = false;
    public int aaJ = -1;
    private int aaS = 0;
    private PostData aaU = new PostData();

    static {
        aab.put(new Point(1, 1), Integer.valueOf(d.g.label_frs_lottery_ing));
        aab.put(new Point(1, 2), Integer.valueOf(d.g.label_frs_lottery_over));
        aab.put(new Point(1, 3), Integer.valueOf(d.g.label_frs_lottery_off));
        aab.put(new Point(1, 4), Integer.valueOf(d.g.label_frs_lottery_d));
        aab.put(new Point(2, 1), Integer.valueOf(d.g.label_frs_activity_shaiing));
        aab.put(new Point(2, 2), Integer.valueOf(d.g.label_frs_activity_shai_over));
        aab.put(new Point(2, 3), Integer.valueOf(d.g.label_frs_activity_shai_off));
        aab.put(new Point(2, 4), Integer.valueOf(d.g.label_frs_activity_shai_d));
        aaL.put(new Point(1, 1), Integer.valueOf(d.l.lottery_status_ing));
        aaL.put(new Point(1, 2), Integer.valueOf(d.l.lottery_status_over));
        aaL.put(new Point(1, 3), Integer.valueOf(d.l.lottery_status_off));
        aaL.put(new Point(1, 4), Integer.valueOf(d.l.lottery_status_not_start));
        aaL.put(new Point(2, 1), Integer.valueOf(d.l.share_picture_status_ing));
        aaL.put(new Point(2, 2), Integer.valueOf(d.l.share_picture_status_over));
        aaL.put(new Point(2, 3), Integer.valueOf(d.l.share_picture_status_off));
        aaL.put(new Point(2, 4), Integer.valueOf(d.l.share_picture_status_not_start));
        aac.put(1, Integer.valueOf(d.g.label_interview_no));
        aac.put(2, Integer.valueOf(d.g.label_interview_live));
        aac.put(3, Integer.valueOf(d.g.label_interview_off));
        aaM.put(1, new m.a(d.l.interview_live_status_not_start, d.e.cp_other_b, d.g.pic_dot_title_red));
        aaM.put(2, new m.a(d.l.interview_live_status_ing, d.e.cp_other_c, d.g.pic_dot_title_green));
        aaM.put(3, new m.a(d.l.interview_live_status_over, d.e.cp_other_d, d.g.pic_dot_title_blue));
    }

    public bl() {
        this.ZF = 0;
        this.ZO = 0;
        this.aah = 0L;
        this.post_num = 0;
        this.post_num = 0;
        this.aah = 0L;
        this.ZO = 0;
        this.ZF = 0;
    }

    public boolean rn() {
        return this.ZF == 1;
    }

    public bj ro() {
        return this.aap;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bP(int i) {
        this.anchorLevel = i;
    }

    public int rp() {
        return this.ZO;
    }

    public boolean rq() {
        return this.aam;
    }

    public boolean rr() {
        return this.aaj;
    }

    public boolean rs() {
        return this.aak;
    }

    public void bQ(int i) {
        this.aal = i;
    }

    public int rt() {
        return this.aal;
    }

    public PollInfo ru() {
        return this.aai;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public String rv() {
        return this.ZK;
    }

    public PraiseData rw() {
        return this.ZI;
    }

    public void a(PraiseData praiseData) {
        this.ZI = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rx() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cI(String str) {
        this.XV = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.XV) || "0".equals(this.XV)) ? this.id : this.XV;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String getCategory() {
        return this.category_name;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void bR(int i) {
        this.reply_num = i;
    }

    public int ry() {
        return this.reply_num;
    }

    public int rz() {
        return this.view_num;
    }

    public void bS(int i) {
        this.view_num = i;
    }

    public long rA() {
        return this.Zt;
    }

    public void m(long j) {
        this.Zt = j;
    }

    public int rB() {
        return this.Zu;
    }

    public void bT(int i) {
        this.Zu = i;
    }

    public int rC() {
        return this.Zv;
    }

    public void bU(int i) {
        this.Zv = i;
    }

    public int rD() {
        return this.Zw;
    }

    public List<PbContent> rE() {
        return this.aay;
    }

    public bo rF() {
        return this.Zx;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rG() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rH() {
        return this.ZT != 0;
    }

    public boolean rI() {
        return this.ZT == 1;
    }

    public boolean rJ() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rK() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rL() {
        return this.forum_name;
    }

    public void cM(String str) {
        this.forum_name = str;
    }

    public int rM() {
        return this.Zz;
    }

    public String rN() {
        return this.ad_url;
    }

    public String rO() {
        return this.ZB;
    }

    public void cN(String str) {
        this.ZB = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aaz == null || this.aaz.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aaz.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aaz.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aay == null || (size = this.aay.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aay.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cO(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.aaz != null && (size = this.aaz.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aaz.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bl.1
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bl.this.cR(pbContent.link);
                            }
                        }, i3, pbContent.text.length() + i3, 33);
                    }
                    i = pbContent.text.length() + i3;
                }
                i2++;
                i3 = i;
            }
        }
        return spannableString;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String rP() {
        return this.ZG;
    }

    public void cP(String str) {
        this.ZG = str;
    }

    public ArrayList<MediaData> rQ() {
        return this.ZC;
    }

    public ArrayList<a> rR() {
        return this.ZX;
    }

    public void h(ArrayList<a> arrayList) {
        this.ZX = arrayList;
    }

    public bu rS() {
        return this.ZY;
    }

    public e rT() {
        return this.ZZ;
    }

    public ArrayList<VoiceData.VoiceModel> rU() {
        return this.ZD;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rV() {
        return this.ZL;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rW() {
        return this.ZV;
    }

    public VideoInfo rX() {
        return this.ZQ;
    }

    public void a(c cVar) {
        this.ZS = cVar;
    }

    public c rY() {
        return this.ZS;
    }

    public String getPhotoLiveCover() {
        return this.aad;
    }

    public void setPhotoLiveCover(String str) {
        this.aad = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rZ() {
        return this.ZP;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.ZP.clear();
        this.ZP.addAll(arrayList);
    }

    public String getNotice() {
        return this.aaf;
    }

    public PushStatusData sa() {
        return this.aar;
    }

    public SkinInfo sb() {
        return this.aas;
    }

    public long sc() {
        return this.aaF;
    }

    public boolean sd() {
        return this.aaG;
    }

    public String se() {
        return this.aaH;
    }

    public p sf() {
        return this.aaQ;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.ZM = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.ZF = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.XV = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.ZT = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Zs = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.Zt = threadInfo.last_time_int.intValue();
                this.Zu = threadInfo.is_top.intValue();
                this.Zv = threadInfo.is_good.intValue();
                this.Zw = threadInfo.is_livepost.intValue();
                this.Zx.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Zy = threadInfo.has_commented.intValue();
                this.Zz = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.ZQ = threadInfo.video_info;
                this.ZS = new c();
                this.ZS.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.ZG = threadInfo.collect_mark_pid;
                this.ZH = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.ZK = threadInfo.first_post_id + "";
                this.ZV = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.ZL = threadInfo.is_ntitle.intValue();
                this.ZN = threadInfo.is_activity.intValue();
                this.aaS = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aaT = threadInfo.agree.has_agree.intValue();
                }
                this.category_name = threadInfo.category_name;
                this.ZO = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aaA = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aay = threadInfo.rich_title;
                this.aaz = threadInfo.rich_abstract;
                this.ZE = threadInfo.is_godthread_recommend.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                StringBuilder sb = new StringBuilder();
                List<Abstract> list = threadInfo._abstract;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) != null && list.get(i).type.intValue() == 0) {
                            sb.append(list.get(i).text);
                        }
                    }
                }
                this.ZB = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.ZC.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.ZQ = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.ZR = new bq();
                    this.ZR.a(threadInfo.video_channel_info);
                }
                List<Voice> list3 = threadInfo.voice_info;
                if (list3 != null) {
                    int size = list3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        Voice voice = list3.get(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = voice.voice_md5;
                        voiceModel.duration = voice.during_time.intValue() / 1000;
                        this.ZD.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.ZX.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.ZY = new bu();
                    this.ZY.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.ZZ = new e();
                    this.ZZ.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aaa = new n();
                    this.aaa.a(threadInfo.cartoon_info);
                }
                this.ZI.setUserMap(this.userMap);
                this.ZI.parserProtobuf(threadInfo.zan);
                this.ZJ.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.ZI.setTitle(this.title);
                } else {
                    this.ZI.setTitle(this.ZB);
                }
                this.aad = threadInfo.livecover_src;
                this.aae = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ZW = threadInfo.post_num.intValue();
                this.aah = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.em(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.ZP.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aaf = noticeInfo.notice;
                    }
                    this.aal = zhiBoInfoTW.copythread_remind.intValue();
                    this.aaj = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aak = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aad)) {
                        this.aad = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.XC = zhiBoInfoTW.user.tw_anchor_info;
                        this.XD = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aag = threadInfo.twzhibo_info.livecover_status;
                    this.aah = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aai = threadInfo.poll_info;
                this.aam = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aap.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.aaq.add(aVar2);
                    }
                }
                this.aar.parserProtobuf(threadInfo.push_status);
                this.aav = threadInfo.lego_card;
                this.aas = threadInfo.skin_info;
                this.aaw = threadInfo.is_book_chapter.intValue();
                this.aax.a(threadInfo.book_chapter);
                this.aaC = threadInfo.recom_source;
                this.aaH = threadInfo.recom_reason;
                this.aaD = threadInfo.recom_weight;
                this.aaE = threadInfo.ab_tag;
                this.aaF = threadInfo.last_read_pid.longValue();
                this.aaG = threadInfo.cheak_repeat.intValue() == 1;
                this.aaK = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aaU.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.u.u(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.XW = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.u.v(threadInfo.declare_list)) {
                    this.aaQ = new p();
                    this.aaQ.a(threadInfo);
                }
                this.aaR = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aaV = new aj();
                    this.aaV.a(threadInfo.link_info);
                }
                this.aaW = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aaX = new d();
                    this.aaX.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aaY = new MediaData();
                    this.aaY.parserProtobuf(threadInfo.pic_info);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.XV = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.ZT = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Zs = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.Zt = jSONObject.optLong("last_time_int", 0L);
                this.Zu = jSONObject.optInt("is_top", 0);
                this.Zv = jSONObject.optInt("is_good", 0);
                this.Zw = jSONObject.optInt("is_livepost", 0);
                this.Zx.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Zy = jSONObject.optInt("has_commented", 0);
                this.Zz = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.ZG = jSONObject.optString("collect_mark_pid");
                this.ZH = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.ZK = jSONObject.optString("first_post_id", "0");
                this.ZV = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.ZL = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aap.parserJson(optJSONObject2);
                }
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.ZS = new c();
                this.ZS.parserJson(jSONObject.optJSONObject("ala_info"));
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                            sb.append(optJSONArray.getJSONObject(i).optString("text"));
                        }
                    }
                }
                this.ZB = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.ZC.add(mediaData);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                        this.ZD.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.ZX.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.ZY = new bu();
                    this.ZY.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.ZZ = new e();
                    this.ZZ.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aaa = new n();
                    this.aaa.parserJson(optJSONObject6);
                }
                this.ZI.setUserMap(this.userMap);
                this.ZI.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.ZJ.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.ZI.setTitle(this.title);
                } else {
                    this.ZI.setTitle(this.ZB);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aap.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aaq.add(aVar2);
                    }
                }
                this.aaw = jSONObject.optInt("is_book_chapter", 0);
                this.aax.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.aaC = jSONObject.optString("recom_source");
                this.aaH = jSONObject.optString("recom_reason");
                this.aaD = jSONObject.optString("recom_weight");
                this.aaF = jSONObject.optLong("last_read_pid");
                this.aaG = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.ZR = new bq();
                    this.ZR.j(optJSONObject8);
                }
                this.aaR = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aaV = new aj();
                    this.aaV.parserJson(optJSONObject9);
                }
                this.aaW = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aaX = new d();
                    this.aaX.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aaY = new MediaData();
                    this.aaY.parserJson(optJSONObject11);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sg() {
        return this.ZA;
    }

    public boolean sh() {
        return rB() != 0;
    }

    public int si() {
        if (this.aap != null) {
            long rh = this.aap.rh();
            long ri = this.aap.ri();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rh) {
                return 1;
            }
            if (currentTimeMillis > ri) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sj() {
        if (sl() && this.ZX.size() >= 1) {
            a aVar = this.ZX.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pq = aVar.pq();
            int pr = aVar.pr();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pq) {
                return 4;
            }
            return currentTimeMillis > pr ? 2 : 1;
        }
        return -1;
    }

    public int sk() {
        if (!sl() || this.ZX.size() < 1 || this.ZX.get(0) == null) {
            return -1;
        }
        return this.ZX.get(0).pp();
    }

    public boolean sl() {
        return this.ZN == 1;
    }

    public String sm() {
        return (!sl() || this.ZX.size() < 1 || this.ZX.get(0) == null) ? "" : this.ZX.get(0).getUrl();
    }

    private com.baidu.adp.widget.b cQ(String str) {
        com.baidu.adp.widget.b bVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(d.j.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(d.h.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.e.cp_cont_f_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                bVar = new com.baidu.adp.widget.b(bitmapDrawable, 1);
            } else {
                bVar = null;
            }
            return bVar;
        }
        return null;
    }

    private void d(boolean z, boolean z2) {
        SpannableString spannableString;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && sn()) {
                arrayList.add(Integer.valueOf(d.g.icon_convene));
            }
            if (rB() == 1) {
                arrayList.add(Integer.valueOf(d.g.icon_top));
            } else if (rB() == 2) {
                arrayList.add(Integer.valueOf(d.g.icon_notice));
            }
            if (rD() == 1 || this.Zx.tf() != 0) {
                if (ro() != null && getThreadType() == 41) {
                    if (si() == 2) {
                        arrayList.add(Integer.valueOf(d.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.g.icon_zhibo));
                }
            }
            if (z && sy()) {
                Integer num = aac.get(Integer.valueOf(si()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rC() == 1 && !sh() && Zg != getType() && Zk != getType()) {
                arrayList.add(Integer.valueOf(d.g.icon_elite));
            }
            if (getType() == Zo || getType() == Zp) {
                arrayList.add(Integer.valueOf(d.g.icon_vote_blue));
            }
            if (this.ZJ != null && this.ZJ.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.g.icon_live_on));
            }
            if (rM() == 1) {
                arrayList.add(Integer.valueOf(d.g.frs_post_ding));
            }
            if (!z && sk() == 2) {
                arrayList.add(Integer.valueOf(d.g.label_frs_activity_shai));
            } else {
                Integer num2 = aab.get(new Point(sk(), sj()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rS() != null) {
                arrayList.add(Integer.valueOf(d.g.tag_act));
            }
            if (rT() != null) {
                arrayList.add(Integer.valueOf(d.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                bVar = cQ(this.category_name);
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append("1 ");
            }
            String sb2 = sb.toString();
            if (bVar != null) {
                spannableString = new SpannableString(sb2 + this.category_name + " ");
            } else {
                spannableString = new SpannableString(sb2);
            }
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i4 >= arrayList.size()) {
                    break;
                }
                Bitmap cS = com.baidu.tbadk.core.util.ai.cS(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cS);
                if (cS != null) {
                    bitmapDrawable.setBounds(0, 0, cS.getWidth(), cS.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.Zr));
                spannableString.setSpan(mVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(g + " "));
        if (a != null) {
            SpannableStringBuilder c = !z && rB() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.ZA = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<m.a> arrayList) {
        if (st() || !rH() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new m.a(d.l.god_title));
        }
        return com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean sn() {
        return com.baidu.adp.lib.b.d.fh().am("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        if (com.baidu.tbadk.core.util.u.u(c(z, z2, z3)) > 0) {
            f(z, z3);
            return;
        }
        String g = g(this.title, false);
        this.ZA = a(g, a(new SpannableString(g + " ")), z, z2, z3);
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3) {
        ArrayList<m.a> c = c(z, z2, z3);
        if (c == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, c, false);
        if (c.size() > 0) {
            if (a == null) {
                a = new SpannableStringBuilder();
            }
            if (this.ZL == 1) {
                this.ZA = a;
                return a;
            }
        } else if (this.ZL == 1) {
            this.ZA = new SpannableStringBuilder();
            return a;
        }
        if (spannableString != null) {
            a.append((CharSequence) spannableString);
            return a;
        } else if (c.size() > 0 || a.length() == 0) {
            a.append((CharSequence) str);
            return a;
        } else {
            return a;
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.aay != null && this.aay.size() > 0) {
            int size = this.aay.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aay.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bl.2
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bl.this.cR(pbContent.link);
                            }
                        }, i3, pbContent.text.length() + i3, 33);
                    }
                    i = pbContent.text.length() + i3;
                } else {
                    return spannableString;
                }
                i2++;
                i3 = i;
            }
            return spannableString;
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, str));
        }
    }

    public void so() {
        d(false, false);
    }

    public void sp() {
        d(true, false);
    }

    public void sq() {
        d(false, true);
    }

    public AnchorInfoData sr() {
        return this.ZJ;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean ss() {
        return this.threadType == 36;
    }

    public boolean st() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int su() {
        return this.ZW;
    }

    public void bV(int i) {
        this.ZW = i;
    }

    public long sv() {
        return this.aah;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rQ = rQ();
        if (rQ == null || sh()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rQ.size() || i2 >= 3) {
                break;
            }
            if (rQ.get(i2) != null && rQ.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rQ.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rQ.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rQ.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.ZQ != null && !StringUtils.isNull(this.ZQ.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.ZQ.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.author != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.author.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean sw() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        int rB = rB();
        if (this.ZS != null && this.threadType == 60) {
            return Zj;
        }
        if (this.ZS != null && this.threadType == 49) {
            return Zh;
        }
        if (this.threadType == 51) {
            return Zi;
        }
        if (rB == 2 || rB == 1) {
            return Zc;
        }
        if (this.ZQ != null && sG()) {
            return Zq;
        }
        if (this.ZQ != null) {
            if (rJ()) {
                return Zk;
            }
            return Zg;
        } else if (ru() != null && getThreadType() == 36 && ru().type.intValue() == 2) {
            return Zo;
        } else {
            if (ru() != null && getThreadType() == 36 && ru().type.intValue() == 1) {
                return Zp;
            }
            if (ro() != null && getThreadType() == 41 && rD() == 1 && si() == 2) {
                return Zl.get() ? aao : Zd;
            } else if (sl() && sk() == 1) {
                return Zl.get() ? aat : Zd;
            } else if (sl() && sk() == 2) {
                return Zl.get() ? aan : Zd;
            } else if (isLinkThread()) {
                return Ze;
            } else {
                if (rJ()) {
                    return Zf;
                }
                return Zd;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sx() {
        return this.aag;
    }

    public List<TwAnchorProfitItem> qk() {
        return this.XD;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.ZL == 1) {
            this.VY = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.VY = 0;
        } else {
            this.VY = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.pJ() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pJ().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.VY = next.pK();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sy() {
        return this.threadType == 41;
    }

    public boolean sz() {
        return this.threadType == 48;
    }

    public boolean sA() {
        return this.aau;
    }

    public void ao(boolean z) {
        this.aau = z;
    }

    public String sB() {
        return this.aav;
    }

    public n sC() {
        return this.aaa;
    }

    public boolean sD() {
        return rD() == 1 || rC() == 1 || rB() == 1 || sl() || this.aaw == 1 || rJ() || rT() != null || rS() != null || !com.baidu.adp.lib.util.j.isEmpty(getCategory()) || sz() || rI();
    }

    public void sE() {
        if (this.ZU == 0) {
            this.ZU = 1;
        }
    }

    public boolean sF() {
        return this.aaA;
    }

    public void ap(boolean z) {
        this.aaI = z;
    }

    public boolean sG() {
        return this.aaI;
    }

    public void bW(int i) {
        this.aaJ = i + 1;
    }

    public int sH() {
        return this.aaJ;
    }

    public List<ReportInfo> sI() {
        return this.aaK;
    }

    public boolean sJ() {
        return this.aaB;
    }

    public void aq(boolean z) {
        this.aaB = z;
    }

    public bq sK() {
        return this.ZR;
    }

    public void a(bq bqVar) {
        this.ZR = bqVar;
    }

    public void bX(int i) {
        if (this.ZR != null) {
            this.ZR.mCurrentPage = i;
        }
    }

    public boolean sL() {
        return getThreadType() == 49;
    }

    public boolean sM() {
        return getThreadType() == 40;
    }

    public boolean sN() {
        return getThreadType() == 50;
    }

    public boolean sO() {
        return getThreadType() == 60;
    }

    public boolean sP() {
        return getThreadType() == 40 && sK() != null && sK().channelId > 0;
    }

    public int sQ() {
        return this.aaP;
    }

    public void setSmartFrsPosition(int i) {
        this.aaP = i;
    }

    public SparseArray<String> qx() {
        return this.XW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.XW = sparseArray;
    }

    public String sR() {
        return this.aaC;
    }

    public boolean sS() {
        return this.aaR;
    }

    public int sT() {
        return this.aaS;
    }

    public int sU() {
        return this.aaT;
    }

    public void bY(int i) {
        this.aaT = i;
    }

    public void bZ(int i) {
        this.aaS = i;
    }

    public PostData sV() {
        return this.aaU;
    }

    public aj sW() {
        return this.aaV;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        String g;
        SpannableString a;
        if (this.ZL == 1) {
            g = g(this.ZB, false);
            a = cO(this.ZB);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        SpannableStringBuilder a2 = a(g, a, z, true, z2);
        this.ZA = a2;
        return a2;
    }

    private ArrayList<m.a> c(boolean z, boolean z2, boolean z3) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean rH = rH();
        if (z2) {
            if (z) {
                if (rH && !st()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if (rD() == 1 || getThreadType() == 33 || (rF() != null && rF().tf() != 0)) {
                    if (ro() != null && sy()) {
                        if (si() == 2) {
                            arrayList.add(new m.a(d.l.interview_live));
                        }
                    } else if (!rH) {
                        arrayList.add(new m.a(d.l.photo_live_tips));
                    }
                }
                if (rB() == 1) {
                    arrayList.add(new m.a(d.l.commit_top));
                }
                if (rC() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (sy()) {
                    arrayList.add(aaM.get(si()));
                }
                if (sl()) {
                    Integer num = aaL.get(new Point(sk(), sj()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (sz()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (rS() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.al.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (rH && rB() != 1 && !st()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if ((rD() == 1 || getThreadType() == 33) && !sy() && !rH) {
                    arrayList.add(new m.a(d.l.photo_live_tips));
                }
                if (rC() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (rB() == 1) {
                    arrayList.add(new m.a(d.l.commit_top));
                }
                if (sy() && ro() != null && si() == 2) {
                    arrayList.add(new m.a(d.l.interview_live));
                }
                if (sl()) {
                    Integer num2 = aaL.get(new Point(sk(), sj()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (this.aaw == 1) {
                    arrayList.add(new m.a(d.l.card_tbread_text));
                }
                if (rT() != null) {
                    arrayList.add(new m.a(d.l.send_app_code_gift, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (rS() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (sz()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.al.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && sL()) {
                    arrayList.add(new m.a(d.l.frs_ala_live_title_prefix));
                }
                if (sP()) {
                    arrayList.add(new m.a(d.l.frs_channel_tip));
                } else if (z3 && sN()) {
                    arrayList.add(new m.a(d.l.frs_ala_record_title_prefix));
                } else if (sM()) {
                    arrayList.add(new m.a(d.l.frs_video_title_prefix));
                }
            }
        }
        return arrayList;
    }

    public MediaData sX() {
        return this.aaY;
    }
}
