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
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tieba.card.k;
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
public class bd extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.f, com.baidu.tbadk.core.util.ae {
    public static final BdUniqueId YF = BdUniqueId.gen();
    public static final BdUniqueId YG = BdUniqueId.gen();
    public static final BdUniqueId YH = BdUniqueId.gen();
    public static final BdUniqueId YI = BdUniqueId.gen();
    public static final BdUniqueId YJ = BdUniqueId.gen();
    public static final BdUniqueId YK = BdUniqueId.gen();
    public static final BdUniqueId YL = BdUniqueId.gen();
    public static final BdUniqueId YM = BdUniqueId.gen();
    public static final BdUniqueId YN = BdUniqueId.gen();
    public static final BdUniqueId YO = BdUniqueId.gen();
    public static AtomicBoolean YP = new AtomicBoolean(false);
    public static AtomicBoolean YQ = new AtomicBoolean(false);
    public static AtomicBoolean YR = new AtomicBoolean(false);
    public static final BdUniqueId YS = BdUniqueId.gen();
    public static final BdUniqueId YT = BdUniqueId.gen();
    public static final BdUniqueId YU = BdUniqueId.gen();
    private static HashMap<Point, Integer> ZH = new HashMap<>();
    private static HashMap<Integer, Integer> ZI = new HashMap<>();
    public static final BdUniqueId ZT = BdUniqueId.gen();
    public static final BdUniqueId ZU = BdUniqueId.gen();
    public static final BdUniqueId ZZ = BdUniqueId.gen();
    private static HashMap<Point, Integer> aas = new HashMap<>();
    private static SparseArray<k.a> aat = new SparseArray<>(3);
    public TwZhiBoUser Xl;
    public List<TwAnchorProfitItem> Xm;
    private m ZG;
    private LiveCoverStatus ZM;
    private long ZN;
    private SkinInfo ZY;
    private SpannableStringBuilder Zf;
    public int Zj;
    private int Zk;
    private int Zn;
    private String Zq;
    private int Zr;
    private String Zs;
    private int Zu;
    private VideoInfo Zw;
    private bj Zx;
    private AlaInfoData Zy;
    private long Zz;
    private long aaB;
    private ad aaC;
    public c aaE;
    private MediaData aaF;
    public int aaG;
    public OriginalThreadInfo aaI;
    private boolean aaa;
    private String aab;
    private boolean aag;
    private boolean aah;
    public String aaj;
    public String aak;
    public String aal;
    public long aam;
    public String aao;
    private List<ReportInfo> aar;
    private boolean aax;
    private int aaz;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    public boolean isShareThread;
    private String latitude;
    private long mCreateTime;
    private String mFromType;
    private int post_num;
    public int threadType;
    private HashMap<String, MetaData> userMap;
    public int YV = 1;
    private String Zm = null;
    private int Wc = 0;
    public int ZA = 0;
    private String ZB = "";
    private String ZJ = "";
    public boolean aan = true;
    public boolean aau = false;
    public boolean aav = false;
    private int aaw = -1;
    private SparseArray<String> XE = null;
    public boolean aaD = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int YW = 0;
    private int view_num = 0;
    private String last_time = null;
    private long YX = 0;
    private int YY = 0;
    private int YZ = 0;
    private int Za = 0;
    private bh Zb = new bh();
    private MetaData Zc = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Zh = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Zi = new ArrayList<>();
    private int Zd = 0;
    private int Ze = 0;
    private String ad_url = null;
    private String Zg = null;
    private String from = null;
    private int Zl = 0;
    private PraiseData Zo = new PraiseData();
    private AnchorInfoData Zp = new AnchorInfoData();
    private long time = 0;
    private int Zt = 0;
    private ArrayList<a> ZD = new ArrayList<>();
    private bn ZE = null;
    private d ZF = null;
    private int ZK = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> Zv = new ArrayList<>();
    private boolean isHeadLive = false;
    private String ZL = null;
    private int ZC = 0;
    private PollInfo ZO = null;
    private boolean ZP = false;
    private boolean ZQ = false;
    private int ZR = 0;
    private boolean ZS = false;
    private int anchorLevel = 0;
    public int aac = 0;
    public j aad = new j();
    private List<PbContent> aae = new ArrayList();
    private List<PbContent> aaf = new ArrayList();
    private String category_name = null;
    private bb ZV = new bb();
    private ArrayList<com.baidu.tbadk.data.a> ZW = new ArrayList<>();
    private PushStatusData ZX = new PushStatusData();
    public boolean aap = false;
    public int aaq = -1;
    private int aay = 0;
    private PostData aaA = new PostData();
    private int aai = 0;
    public int aaH = 0;
    private String tieba_game_information_source = "";

    static {
        ZH.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        ZH.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        ZH.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        ZH.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        ZH.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        ZH.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        ZH.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        ZH.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        aas.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        aas.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        aas.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        aas.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        aas.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        aas.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        aas.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        aas.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        ZI.put(1, Integer.valueOf(d.f.label_interview_no));
        ZI.put(2, Integer.valueOf(d.f.label_interview_live));
        ZI.put(3, Integer.valueOf(d.f.label_interview_off));
        aat.put(1, new k.a(d.j.interview_live_status_not_start, d.C0082d.cp_other_b, d.f.pic_dot_title_red));
        aat.put(2, new k.a(d.j.interview_live_status_ing, d.C0082d.cp_other_c, d.f.pic_dot_title_green));
        aat.put(3, new k.a(d.j.interview_live_status_over, d.C0082d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.Zk = 0;
        this.Zu = 0;
        this.ZN = 0L;
        this.aaG = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.ZN = 0L;
        this.Zu = 0;
        this.Zk = 0;
        this.aaG = 0;
    }

    public boolean rc() {
        return this.Zk == 1;
    }

    public bb rd() {
        return this.ZV;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bN(int i) {
        this.anchorLevel = i;
    }

    public int re() {
        return this.Zu;
    }

    public int rf() {
        return this.aai;
    }

    public void bO(int i) {
        this.aai = i;
    }

    public boolean rg() {
        return this.ZP;
    }

    public boolean rh() {
        return this.ZQ;
    }

    public void bP(int i) {
        this.ZR = i;
    }

    public int ri() {
        return this.ZR;
    }

    public PollInfo rj() {
        return this.ZO;
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

    public long rk() {
        return this.Zz;
    }

    public String rl() {
        return this.Zq;
    }

    public PraiseData rm() {
        return this.Zo;
    }

    public void a(PraiseData praiseData) {
        this.Zo = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rn() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cD(String str) {
        this.tid = str;
    }

    public String ro() {
        return this.tieba_game_information_source;
    }

    public String getTid() {
        return (StringUtils.isNull(this.tid) || "0".equals(this.tid)) ? this.id : this.tid;
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

    public void bQ(int i) {
        this.reply_num = i;
    }

    public int rp() {
        return this.reply_num;
    }

    public int rq() {
        return this.view_num;
    }

    public void bR(int i) {
        this.view_num = i;
    }

    public long rr() {
        return this.YX;
    }

    public void m(long j) {
        this.YX = j;
    }

    public int rs() {
        return this.YY;
    }

    public void bS(int i) {
        this.YY = i;
    }

    public int rt() {
        return this.YZ;
    }

    public void bT(int i) {
        this.YZ = i;
    }

    public int ru() {
        return this.Za;
    }

    public List<PbContent> rv() {
        return this.aae;
    }

    public bh rw() {
        return this.Zb;
    }

    public MetaData rx() {
        return this.Zc;
    }

    public UserTbVipInfoData ry() {
        if (this.Zc == null) {
            return null;
        }
        return this.Zc.getUserTbVipInfoData();
    }

    public boolean rz() {
        return this.is_god != 0;
    }

    public boolean rA() {
        return this.is_god == 1;
    }

    public boolean rB() {
        return (this.Zc == null || this.Zc.getGodUserData() == null || this.Zc.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rC() {
        return (this.Zc == null || this.Zc.getGodUserData() == null || this.Zc.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.Zc = metaData;
    }

    public String rD() {
        return this.forum_name;
    }

    public void cH(String str) {
        this.forum_name = str;
    }

    public int rE() {
        return this.Ze;
    }

    public String rF() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.Zg;
    }

    public void cI(String str) {
        this.Zg = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aaf == null || this.aaf.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aaf.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aaf.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aae == null || (size = this.aae.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aae.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cJ(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.aaf != null && (size = this.aaf.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aaf.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bd.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bd.this.cN(pbContent.link);
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

    public int rG() {
        return this.Zl;
    }

    public void bU(int i) {
        this.Zl = i;
    }

    public String rH() {
        return this.Zm;
    }

    public void cK(String str) {
        this.Zm = str;
    }

    public ArrayList<MediaData> rI() {
        return this.Zh;
    }

    public ArrayList<a> rJ() {
        return this.ZD;
    }

    public void h(ArrayList<a> arrayList) {
        this.ZD = arrayList;
    }

    public bn rK() {
        return this.ZE;
    }

    public d rL() {
        return this.ZF;
    }

    public ArrayList<VoiceData.VoiceModel> rM() {
        return this.Zi;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rN() {
        return this.Zr;
    }

    public void bV(int i) {
        this.Zr = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rO() {
        return this.ZB;
    }

    public VideoInfo rP() {
        return this.Zw;
    }

    public void a(AlaInfoData alaInfoData) {
        this.Zy = alaInfoData;
    }

    public AlaInfoData rQ() {
        return this.Zy;
    }

    public String getPhotoLiveCover() {
        return this.ZJ;
    }

    public void setPhotoLiveCover(String str) {
        this.ZJ = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rR() {
        return this.Zv;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.Zv.clear();
        this.Zv.addAll(arrayList);
    }

    public String getNotice() {
        return this.ZL;
    }

    public PushStatusData rS() {
        return this.ZX;
    }

    public SkinInfo rT() {
        return this.ZY;
    }

    public long rU() {
        return this.aam;
    }

    public boolean rV() {
        return this.aan;
    }

    public String rW() {
        return this.aao;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.Zs = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.Zk = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.Zz = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.YW = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.YX = threadInfo.last_time_int.intValue();
                this.YY = threadInfo.is_top.intValue();
                this.YZ = threadInfo.is_good.intValue();
                this.Za = threadInfo.is_livepost.intValue();
                this.Zb.a(threadInfo.topic);
                this.Zc.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Zd = threadInfo.has_commented.intValue();
                this.Ze = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Zw = threadInfo.video_info;
                this.Zy = new AlaInfoData();
                this.Zy.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.Zl = threadInfo.collect_status.intValue();
                this.Zm = threadInfo.collect_mark_pid;
                this.Zn = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.Zq = threadInfo.first_post_id + "";
                this.ZB = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.Zr = threadInfo.is_ntitle.intValue();
                this.Zt = threadInfo.is_activity.intValue();
                this.aay = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aaz = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aaB = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.Zu = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aag = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aae = threadInfo.rich_title;
                this.aaf = threadInfo.rich_abstract;
                this.Zj = threadInfo.is_godthread_recommend.intValue();
                if ((this.Zc == null || this.Zc.getUserId() == null || this.Zc.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.Zc = metaData;
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
                this.Zg = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Zh.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Zw = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.Zx = new bj();
                    this.Zx.a(threadInfo.video_channel_info);
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
                        this.Zi.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.ZD.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.ZE = new bn();
                    this.ZE.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.ZF = new d();
                    this.ZF.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ZG = new m();
                    this.ZG.a(threadInfo.cartoon_info);
                }
                this.Zo.setUserMap(this.userMap);
                this.Zo.parserProtobuf(threadInfo.zan);
                this.Zp.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.Zo.setTitle(this.title);
                } else {
                    this.Zo.setTitle(this.Zg);
                }
                this.ZJ = threadInfo.livecover_src;
                this.ZK = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ZC = threadInfo.post_num.intValue();
                this.ZN = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.ev(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Zv.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.ZL = noticeInfo.notice;
                    }
                    this.ZR = zhiBoInfoTW.copythread_remind.intValue();
                    this.ZP = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.ZQ = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.ZJ)) {
                        this.ZJ = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.Xl = zhiBoInfoTW.user.tw_anchor_info;
                        this.Xm = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.ZM = threadInfo.twzhibo_info.livecover_status;
                    this.ZN = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.ZO = threadInfo.poll_info;
                this.ZS = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.ZV.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.ZW.add(aVar2);
                    }
                }
                this.ZX.parserProtobuf(threadInfo.push_status);
                this.aab = threadInfo.lego_card;
                this.ZY = threadInfo.skin_info;
                this.aac = threadInfo.is_book_chapter.intValue();
                this.aad.a(threadInfo.book_chapter);
                this.aaj = threadInfo.recom_source;
                this.aao = threadInfo.recom_reason;
                this.aak = threadInfo.recom_weight;
                this.aal = threadInfo.ab_tag;
                this.aam = threadInfo.last_read_pid.longValue();
                this.aan = threadInfo.cheak_repeat.intValue() == 1;
                this.aar = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aaA.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.v(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.XE = sparseArray;
                }
                this.aax = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aaC = new ad();
                    this.aaC.a(threadInfo.link_info);
                }
                this.aaD = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aaE = new c();
                    this.aaE.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aaF = new MediaData();
                    this.aaF.parserProtobuf(threadInfo.pic_info);
                }
                this.aai = threadInfo.is_called.intValue();
                this.aaG = threadInfo.middle_page_num.intValue();
                this.aaH = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.origin_thread_info != null) {
                    this.aaI = new OriginalThreadInfo();
                    this.aaI.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.aaI = new OriginalThreadInfo();
                    this.aaI.parser(threadInfo.origin_thread_info);
                } else {
                    this.aaI = null;
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
                this.tid = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.is_god = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.Zz = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.YW = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.YX = jSONObject.optLong("last_time_int", 0L);
                this.YY = jSONObject.optInt("is_top", 0);
                this.YZ = jSONObject.optInt("is_good", 0);
                this.Za = jSONObject.optInt("is_livepost", 0);
                this.Zb.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.Zc.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Zd = jSONObject.optInt("has_commented", 0);
                this.Ze = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.Zl = jSONObject.optInt("collect_status");
                this.Zm = jSONObject.optString("collect_mark_pid");
                this.Zn = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aay = jSONObject.optInt("agree_num");
                this.aaB = jSONObject.optLong("share_num");
                this.Zq = jSONObject.optString("first_post_id", "0");
                this.ZB = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Zr = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.ZV.parserJson(optJSONObject2);
                }
                if ((this.Zc == null || this.Zc.getUserId() == null) && this.userMap != null) {
                    this.Zc = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.Zy = new AlaInfoData();
                this.Zy.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.Zg = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Zh.add(mediaData);
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
                        this.Zi.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.ZD.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.ZE = new bn();
                    this.ZE.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.ZF = new d();
                    this.ZF.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.ZG = new m();
                    this.ZG.parserJson(optJSONObject6);
                }
                this.Zo.setUserMap(this.userMap);
                this.Zo.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.Zp.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.Zo.setTitle(this.title);
                } else {
                    this.Zo.setTitle(this.Zg);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.ZV.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ZW.add(aVar2);
                    }
                }
                this.aac = jSONObject.optInt("is_book_chapter", 0);
                this.aad.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.aaj = jSONObject.optString("recom_source");
                this.aao = jSONObject.optString("recom_reason");
                this.aak = jSONObject.optString("recom_weight");
                this.aam = jSONObject.optLong("last_read_pid");
                this.aan = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.Zx = new bj();
                    this.Zx.f(optJSONObject8);
                }
                this.aax = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aaC = new ad();
                    this.aaC.parserJson(optJSONObject9);
                }
                this.aaD = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aaE = new c();
                    this.aaE.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aaF = new MediaData();
                    this.aaF.parserJson(optJSONObject11);
                }
                this.aai = jSONObject.optInt("is_called", 0);
                this.aaG = jSONObject.optInt("middle_page_num", 0);
                this.aaH = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject12 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject12.optString("video_md5");
                    builder.video_url = optJSONObject12.optString("video_url");
                    builder.video_duration = new Integer(optJSONObject12.optInt("video_duration", 0));
                    builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    this.Zw = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.aaI = new OriginalThreadInfo();
                        this.aaI.parserJson(optJSONObject13);
                        return;
                    }
                    this.aaI = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rX() {
        return this.Zf;
    }

    public boolean rY() {
        return rs() != 0;
    }

    public int rZ() {
        if (this.ZV != null) {
            long qX = this.ZV.qX();
            long qY = this.ZV.qY();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qX) {
                return 1;
            }
            if (currentTimeMillis > qY) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sa() {
        if (sc() && this.ZD.size() >= 1) {
            a aVar = this.ZD.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pr = aVar.pr();
            int ps = aVar.ps();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pr) {
                return 4;
            }
            return currentTimeMillis > ps ? 2 : 1;
        }
        return -1;
    }

    public int sb() {
        if (!sc() || this.ZD.size() < 1 || this.ZD.get(0) == null) {
            return -1;
        }
        return this.ZD.get(0).pq();
    }

    public boolean sc() {
        return this.Zt == 1;
    }

    public String sd() {
        return (!sc() || this.ZD.size() < 1 || this.ZD.get(0) == null) ? "" : this.ZD.get(0).getUrl();
    }

    private com.baidu.adp.widget.b cL(String str) {
        com.baidu.adp.widget.b bVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(d.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(d.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0082d.cp_cont_f_1));
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
            if (getThreadType() == 42 && se()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (rs() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (rs() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (ru() == 1 || this.Zb.sY() != 0) {
                if (rd() != null && getThreadType() == 41) {
                    if (rZ() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && sq()) {
                Integer num = ZI.get(Integer.valueOf(rZ()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rt() == 1 && !rY() && YJ != getType() && YO != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (getType() == YS || getType() == YT) {
                arrayList.add(Integer.valueOf(d.f.icon_vote_blue));
            }
            if (this.Zp != null && this.Zp.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (rE() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            if (!z && sb() == 2) {
                arrayList.add(Integer.valueOf(d.f.label_frs_activity_shai));
            } else {
                Integer num2 = ZH.get(new Point(sb(), sa()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rK() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (rL() != null) {
                arrayList.add(Integer.valueOf(d.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = cL(this.category_name);
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
                Bitmap cR = com.baidu.tbadk.core.util.aj.cR(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.YV));
                spannableString.setSpan(iVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder c = !z && rs() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.Zf = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<k.a> arrayList) {
        if (sk() || !rz() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new k.a(d.j.god_title));
        }
        return com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean se() {
        return com.baidu.adp.lib.b.d.eV().af("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.v(a(z, z2, z3, false)) > 0) {
            f(z, z3);
            return;
        }
        String g = g(this.title, false);
        SpannableString a = a(new SpannableString(g + " "));
        if (z) {
            spannableStringBuilder = a(g, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.Zf = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<k.a> a = a(z, z2, z3, z4);
        if (a == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), str, a, false);
        if (a.size() > 0) {
            if (a2 == null) {
                a2 = new SpannableStringBuilder();
            }
            if (this.Zr == 1) {
                this.Zf = a2;
                return a2;
            }
        } else if (this.Zr == 1) {
            this.Zf = new SpannableStringBuilder();
            return a2;
        }
        if (spannableString != null) {
            a2.append((CharSequence) spannableString);
            return a2;
        } else if (a.size() > 0 || a2.length() == 0) {
            a2.append((CharSequence) str);
            return a2;
        } else {
            return a2;
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.aae != null && this.aae.size() > 0) {
            int size = this.aae.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aae.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (sk()) {
                            if (pbContent.text != null) {
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, cM(pbContent.text)) { // from class: com.baidu.tbadk.core.data.bd.2
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view) {
                                        bd.this.cN(getLink());
                                    }
                                }, i3, pbContent.text.length() + i3, 33);
                            }
                        } else {
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bd.3
                                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    bd.this.cN(pbContent.link);
                                }
                            }, i3, pbContent.text.length() + i3, 33);
                        }
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

    private String cM(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, str));
        }
    }

    public void sf() {
        d(false, false);
    }

    public void sg() {
        d(true, false);
    }

    public void sh() {
        d(false, true);
    }

    public AnchorInfoData si() {
        return this.Zp;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sj() {
        return this.threadType == 36;
    }

    public boolean sk() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sl() {
        return this.ZC;
    }

    public void bW(int i) {
        this.ZC = i;
    }

    public long sm() {
        return this.ZN;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rI = rI();
        if (rI == null || rY()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rI.size() || i2 >= 3) {
                break;
            }
            if (rI.get(i2) != null && rI.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rI.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rI.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rI.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.Zw != null && !StringUtils.isNull(this.Zw.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.Zw.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.Zc != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.Zc.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean sn() {
        String userId;
        return this.Zc == null || (userId = this.Zc.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        int rs = rs();
        if (this.Zy != null && this.threadType == 60) {
            return YM;
        }
        if (this.Zy != null && this.threadType == 49) {
            return YK;
        }
        if (this.threadType == 51) {
            return YL;
        }
        if (rs == 2 || rs == 1) {
            return YF;
        }
        if (this.Zw != null && sy()) {
            return YU;
        }
        if (this.Zw != null) {
            if (rB()) {
                return YO;
            }
            return YJ;
        } else if (this.isShareThread) {
            return YN;
        } else {
            if (rj() != null && getThreadType() == 36 && rj().type.intValue() == 2) {
                return YS;
            }
            if (rj() != null && getThreadType() == 36 && rj().type.intValue() == 1) {
                return YT;
            }
            if (so()) {
                return YP.get() ? ZU : YG;
            } else if (sc() && sb() == 1) {
                return YP.get() ? ZZ : YG;
            } else if (sc() && sb() == 2) {
                return YP.get() ? ZT : YG;
            } else if (isLinkThread()) {
                return YH;
            } else {
                if (rB()) {
                    return YI;
                }
                return YG;
            }
        }
    }

    public boolean so() {
        return rd() != null && getThreadType() == 41 && ru() == 1 && rZ() == 2;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sp() {
        return this.ZM;
    }

    public List<TwAnchorProfitItem> qa() {
        return this.Xm;
    }

    public void i(ArrayList<n> arrayList) {
        if (this.Zr == 1) {
            this.Wc = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Wc = 0;
        } else {
            this.Wc = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.pJ() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pJ().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Wc = next.pK();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sq() {
        return this.threadType == 41;
    }

    public boolean sr() {
        return this.threadType == 48;
    }

    public boolean ss() {
        return this.aaa;
    }

    public void al(boolean z) {
        this.aaa = z;
    }

    public String st() {
        return this.aab;
    }

    public m su() {
        return this.ZG;
    }

    public boolean sv() {
        return ru() == 1 || rt() == 1 || rs() == 1 || sc() || this.aac == 1 || rB() || rL() != null || rK() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || sr() || rA();
    }

    public void sw() {
        if (this.ZA == 0) {
            this.ZA = 1;
        }
    }

    public boolean sx() {
        return this.aag;
    }

    public void am(boolean z) {
        this.aap = z;
    }

    public boolean sy() {
        return this.aap;
    }

    public void bX(int i) {
        this.aaq = i + 1;
    }

    public int sz() {
        return this.aaq;
    }

    public List<ReportInfo> sA() {
        return this.aar;
    }

    public boolean sB() {
        return this.aah;
    }

    public void an(boolean z) {
        this.aah = z;
    }

    public bj sC() {
        return this.Zx;
    }

    public void a(bj bjVar) {
        this.Zx = bjVar;
    }

    public void bY(int i) {
        if (this.Zx != null) {
            this.Zx.mCurrentPage = i;
        }
    }

    public boolean sD() {
        return getThreadType() == 49;
    }

    public boolean sE() {
        return getThreadType() == 40;
    }

    public boolean sF() {
        return getThreadType() == 50;
    }

    public boolean sG() {
        return getThreadType() == 60;
    }

    public boolean sH() {
        return getThreadType() == 40 && sC() != null && sC().channelId > 0;
    }

    public int sI() {
        return this.aaw;
    }

    public void setSmartFrsPosition(int i) {
        this.aaw = i;
    }

    public SparseArray<String> qn() {
        return this.XE;
    }

    public void a(SparseArray<String> sparseArray) {
        this.XE = sparseArray;
    }

    public String sJ() {
        return this.aaj;
    }

    public boolean sK() {
        return this.aax;
    }

    public int sL() {
        return this.aay;
    }

    public int sM() {
        return this.aaz;
    }

    public void bZ(int i) {
        this.aaz = i;
    }

    public void ca(int i) {
        this.aay = i;
    }

    public long sN() {
        return this.aaB;
    }

    public void n(long j) {
        this.aaB = j;
    }

    public PostData sO() {
        return this.aaA;
    }

    public ad sP() {
        return this.aaC;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.Zr == 1) {
            g = g(this.Zg, false);
            a = cJ(this.Zg);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.Zf = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        SpannableString cJ;
        if (!StringUtils.isNull(this.title)) {
            cJ = a(new SpannableString(g(this.title, false) + " "));
        } else {
            g(this.Zg, false);
            cJ = cJ(this.Zg);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cJ);
        this.Zf = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<k.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<k.a> arrayList = new ArrayList<>();
        boolean rz = rz();
        if (z2) {
            if (z) {
                if (rz && !sk()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if (ru() == 1 || getThreadType() == 33 || (rw() != null && rw().sY() != 0)) {
                    if (rd() != null && sq()) {
                        if (rZ() == 2) {
                            arrayList.add(new k.a(d.j.interview_live));
                        }
                    } else if (!rz) {
                        arrayList.add(new k.a(d.j.photo_live_tips));
                    }
                }
                if (rs() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (rt() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (sq()) {
                    arrayList.add(aat.get(rZ()));
                }
                if (sc()) {
                    Integer num = aas.get(new Point(sb(), sa()));
                    if (num != null) {
                        arrayList.add(new k.a(num.intValue(), d.C0082d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (sr()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (rK() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0082d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
            } else {
                if (rz && rs() != 1 && !sk()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if ((ru() == 1 || getThreadType() == 33) && !sq() && !rz) {
                    arrayList.add(new k.a(d.j.photo_live_tips));
                }
                if (rt() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (rs() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (sq() && rd() != null && rZ() == 2) {
                    arrayList.add(new k.a(d.j.interview_live));
                }
                if (sc()) {
                    Integer num2 = aas.get(new Point(sb(), sa()));
                    if (num2 != null) {
                        arrayList.add(new k.a(num2.intValue(), d.C0082d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (this.aac == 1) {
                    arrayList.add(new k.a(d.j.card_tbread_text));
                }
                if (rL() != null) {
                    arrayList.add(new k.a(d.j.send_app_code_gift, d.C0082d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (rK() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0082d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (sr()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
                if (z3 && sD()) {
                    arrayList.add(new k.a(d.j.ala_live));
                }
                if (sH()) {
                    arrayList.add(new k.a(d.j.frs_channel_tip));
                } else if (z3 && sF()) {
                    arrayList.add(new k.a(d.j.live_record));
                } else if (sE()) {
                    arrayList.add(new k.a(d.j.video_title_str));
                }
                if (z4) {
                    arrayList.add(new k.a(d.j.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public MediaData sQ() {
        return this.aaF;
    }

    public void j(ArrayList<MediaData> arrayList) {
        this.Zh = arrayList;
    }
}
