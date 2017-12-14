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
    public TwZhiBoUser Xf;
    public List<TwAnchorProfitItem> Xg;
    private SpannableStringBuilder YZ;
    private m ZA;
    private LiveCoverStatus ZG;
    private long ZH;
    private SkinInfo ZS;
    private boolean ZU;
    private String ZV;
    public int Zd;
    private int Ze;
    private int Zh;
    private String Zk;
    private int Zl;
    private String Zm;
    private int Zo;
    private VideoInfo Zq;
    private bj Zr;
    private AlaInfoData Zs;
    private long Zt;
    public int aaA;
    public OriginalThreadInfo aaC;
    private boolean aaa;
    private boolean aab;
    public String aad;
    public String aae;
    public String aaf;
    public long aag;
    public String aai;
    private List<ReportInfo> aal;
    private boolean aar;
    private int aat;
    private long aav;
    private ad aaw;
    public c aay;
    private MediaData aaz;
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
    public static final BdUniqueId Yz = BdUniqueId.gen();
    public static final BdUniqueId YA = BdUniqueId.gen();
    public static final BdUniqueId YB = BdUniqueId.gen();
    public static final BdUniqueId YC = BdUniqueId.gen();
    public static final BdUniqueId YD = BdUniqueId.gen();
    public static final BdUniqueId YE = BdUniqueId.gen();
    public static final BdUniqueId YF = BdUniqueId.gen();
    public static final BdUniqueId YG = BdUniqueId.gen();
    public static final BdUniqueId YH = BdUniqueId.gen();
    public static final BdUniqueId YI = BdUniqueId.gen();
    public static AtomicBoolean YJ = new AtomicBoolean(false);
    public static AtomicBoolean YK = new AtomicBoolean(false);
    public static AtomicBoolean YL = new AtomicBoolean(false);
    public static final BdUniqueId YM = BdUniqueId.gen();
    public static final BdUniqueId YN = BdUniqueId.gen();
    public static final BdUniqueId YO = BdUniqueId.gen();
    private static HashMap<Point, Integer> ZB = new HashMap<>();
    private static HashMap<Integer, Integer> ZC = new HashMap<>();
    public static final BdUniqueId ZN = BdUniqueId.gen();
    public static final BdUniqueId ZO = BdUniqueId.gen();
    public static final BdUniqueId ZT = BdUniqueId.gen();
    private static HashMap<Point, Integer> aam = new HashMap<>();
    private static SparseArray<k.a> aan = new SparseArray<>(3);
    public int YP = 1;
    private String Zg = null;
    private int VW = 0;
    public int Zu = 0;
    private String Zv = "";
    private String ZD = "";
    public boolean aah = true;
    public boolean aao = false;
    public boolean aap = false;
    private int aaq = -1;
    private SparseArray<String> Xy = null;
    public boolean aax = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int YQ = 0;
    private int view_num = 0;
    private String last_time = null;
    private long YR = 0;
    private int YS = 0;
    private int YT = 0;
    private int YU = 0;
    private bh YV = new bh();
    private MetaData YW = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Zb = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Zc = new ArrayList<>();
    private int YX = 0;
    private int YY = 0;
    private String ad_url = null;
    private String Za = null;
    private String from = null;
    private int Zf = 0;
    private PraiseData Zi = new PraiseData();
    private AnchorInfoData Zj = new AnchorInfoData();
    private long time = 0;
    private int Zn = 0;
    private ArrayList<a> Zx = new ArrayList<>();
    private bn Zy = null;
    private d Zz = null;
    private int ZE = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> Zp = new ArrayList<>();
    private boolean isHeadLive = false;
    private String ZF = null;
    private int Zw = 0;
    private PollInfo ZI = null;
    private boolean ZJ = false;
    private boolean ZK = false;
    private int ZL = 0;
    private boolean ZM = false;
    private int anchorLevel = 0;
    public int ZW = 0;
    public j ZX = new j();
    private List<PbContent> ZY = new ArrayList();
    private List<PbContent> ZZ = new ArrayList();
    private String category_name = null;
    private bb ZP = new bb();
    private ArrayList<com.baidu.tbadk.data.a> ZQ = new ArrayList<>();
    private PushStatusData ZR = new PushStatusData();
    public boolean aaj = false;
    public int aak = -1;
    private int aas = 0;
    private PostData aau = new PostData();
    private int aac = 0;
    public int aaB = 0;
    private String tieba_game_information_source = "";

    static {
        ZB.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        ZB.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        ZB.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        ZB.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        ZB.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        ZB.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        ZB.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        ZB.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        aam.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        aam.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        aam.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        aam.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        aam.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        aam.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        aam.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        aam.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        ZC.put(1, Integer.valueOf(d.f.label_interview_no));
        ZC.put(2, Integer.valueOf(d.f.label_interview_live));
        ZC.put(3, Integer.valueOf(d.f.label_interview_off));
        aan.put(1, new k.a(d.j.interview_live_status_not_start, d.C0096d.cp_other_b, d.f.pic_dot_title_red));
        aan.put(2, new k.a(d.j.interview_live_status_ing, d.C0096d.cp_other_c, d.f.pic_dot_title_green));
        aan.put(3, new k.a(d.j.interview_live_status_over, d.C0096d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.Ze = 0;
        this.Zo = 0;
        this.ZH = 0L;
        this.aaA = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.ZH = 0L;
        this.Zo = 0;
        this.Ze = 0;
        this.aaA = 0;
    }

    public boolean ra() {
        return this.Ze == 1;
    }

    public bb rb() {
        return this.ZP;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bN(int i) {
        this.anchorLevel = i;
    }

    public int rc() {
        return this.Zo;
    }

    public int rd() {
        return this.aac;
    }

    public void bO(int i) {
        this.aac = i;
    }

    public boolean re() {
        return this.ZJ;
    }

    public boolean rf() {
        return this.ZK;
    }

    public void bP(int i) {
        this.ZL = i;
    }

    public int rg() {
        return this.ZL;
    }

    public PollInfo rh() {
        return this.ZI;
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

    public long ri() {
        return this.Zt;
    }

    public String rj() {
        return this.Zk;
    }

    public PraiseData rk() {
        return this.Zi;
    }

    public void a(PraiseData praiseData) {
        this.Zi = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rl() {
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

    public String rm() {
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

    public int rn() {
        return this.reply_num;
    }

    public int ro() {
        return this.view_num;
    }

    public void bR(int i) {
        this.view_num = i;
    }

    public long rp() {
        return this.YR;
    }

    public void m(long j) {
        this.YR = j;
    }

    public int rq() {
        return this.YS;
    }

    public void bS(int i) {
        this.YS = i;
    }

    public int rr() {
        return this.YT;
    }

    public void bT(int i) {
        this.YT = i;
    }

    public int rs() {
        return this.YU;
    }

    public List<PbContent> rt() {
        return this.ZY;
    }

    public bh ru() {
        return this.YV;
    }

    public MetaData rv() {
        return this.YW;
    }

    public UserTbVipInfoData rw() {
        if (this.YW == null) {
            return null;
        }
        return this.YW.getUserTbVipInfoData();
    }

    public boolean rx() {
        return this.is_god != 0;
    }

    public boolean ry() {
        return this.is_god == 1;
    }

    public boolean rz() {
        return (this.YW == null || this.YW.getGodUserData() == null || this.YW.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rA() {
        return (this.YW == null || this.YW.getGodUserData() == null || this.YW.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.YW = metaData;
    }

    public String rB() {
        return this.forum_name;
    }

    public void cH(String str) {
        this.forum_name = str;
    }

    public int rC() {
        return this.YY;
    }

    public String rD() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.Za;
    }

    public void cI(String str) {
        this.Za = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.ZZ == null || this.ZZ.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.ZZ.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.ZZ.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.ZY == null || (size = this.ZY.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.ZY.get(i2);
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
        if (this.ZZ != null && (size = this.ZZ.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ZZ.get(i2);
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

    public int rE() {
        return this.Zf;
    }

    public void bU(int i) {
        this.Zf = i;
    }

    public String rF() {
        return this.Zg;
    }

    public void cK(String str) {
        this.Zg = str;
    }

    public ArrayList<MediaData> rG() {
        return this.Zb;
    }

    public ArrayList<a> rH() {
        return this.Zx;
    }

    public void h(ArrayList<a> arrayList) {
        this.Zx = arrayList;
    }

    public bn rI() {
        return this.Zy;
    }

    public d rJ() {
        return this.Zz;
    }

    public ArrayList<VoiceData.VoiceModel> rK() {
        return this.Zc;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rL() {
        return this.Zl;
    }

    public void bV(int i) {
        this.Zl = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rM() {
        return this.Zv;
    }

    public VideoInfo rN() {
        return this.Zq;
    }

    public void a(AlaInfoData alaInfoData) {
        this.Zs = alaInfoData;
    }

    public AlaInfoData rO() {
        return this.Zs;
    }

    public String getPhotoLiveCover() {
        return this.ZD;
    }

    public void setPhotoLiveCover(String str) {
        this.ZD = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rP() {
        return this.Zp;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.Zp.clear();
        this.Zp.addAll(arrayList);
    }

    public String getNotice() {
        return this.ZF;
    }

    public PushStatusData rQ() {
        return this.ZR;
    }

    public SkinInfo rR() {
        return this.ZS;
    }

    public long rS() {
        return this.aag;
    }

    public boolean rT() {
        return this.aah;
    }

    public String rU() {
        return this.aai;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.Zm = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.Ze = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.Zt = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.YQ = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.YR = threadInfo.last_time_int.intValue();
                this.YS = threadInfo.is_top.intValue();
                this.YT = threadInfo.is_good.intValue();
                this.YU = threadInfo.is_livepost.intValue();
                this.YV.a(threadInfo.topic);
                this.YW.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.YX = threadInfo.has_commented.intValue();
                this.YY = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Zq = threadInfo.video_info;
                this.Zs = new AlaInfoData();
                this.Zs.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.Zf = threadInfo.collect_status.intValue();
                this.Zg = threadInfo.collect_mark_pid;
                this.Zh = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.Zk = threadInfo.first_post_id + "";
                this.Zv = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.Zl = threadInfo.is_ntitle.intValue();
                this.Zn = threadInfo.is_activity.intValue();
                this.aas = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aat = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aav = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.Zo = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aaa = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ZY = threadInfo.rich_title;
                this.ZZ = threadInfo.rich_abstract;
                this.Zd = threadInfo.is_godthread_recommend.intValue();
                if ((this.YW == null || this.YW.getUserId() == null || this.YW.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.YW = metaData;
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
                this.Za = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Zb.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Zq = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.Zr = new bj();
                    this.Zr.a(threadInfo.video_channel_info);
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
                        this.Zc.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Zx.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Zy = new bn();
                    this.Zy.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Zz = new d();
                    this.Zz.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ZA = new m();
                    this.ZA.a(threadInfo.cartoon_info);
                }
                this.Zi.setUserMap(this.userMap);
                this.Zi.parserProtobuf(threadInfo.zan);
                this.Zj.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.Zi.setTitle(this.title);
                } else {
                    this.Zi.setTitle(this.Za);
                }
                this.ZD = threadInfo.livecover_src;
                this.ZE = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Zw = threadInfo.post_num.intValue();
                this.ZH = threadInfo.freq_num.longValue();
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
                                this.Zp.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.ZF = noticeInfo.notice;
                    }
                    this.ZL = zhiBoInfoTW.copythread_remind.intValue();
                    this.ZJ = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.ZK = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.ZD)) {
                        this.ZD = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.Xf = zhiBoInfoTW.user.tw_anchor_info;
                        this.Xg = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.ZG = threadInfo.twzhibo_info.livecover_status;
                    this.ZH = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.ZI = threadInfo.poll_info;
                this.ZM = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.ZP.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.ZQ.add(aVar2);
                    }
                }
                this.ZR.parserProtobuf(threadInfo.push_status);
                this.ZV = threadInfo.lego_card;
                this.ZS = threadInfo.skin_info;
                this.ZW = threadInfo.is_book_chapter.intValue();
                this.ZX.a(threadInfo.book_chapter);
                this.aad = threadInfo.recom_source;
                this.aai = threadInfo.recom_reason;
                this.aae = threadInfo.recom_weight;
                this.aaf = threadInfo.ab_tag;
                this.aag = threadInfo.last_read_pid.longValue();
                this.aah = threadInfo.cheak_repeat.intValue() == 1;
                this.aal = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aau.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.v(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.Xy = sparseArray;
                }
                this.aar = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aaw = new ad();
                    this.aaw.a(threadInfo.link_info);
                }
                this.aax = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aay = new c();
                    this.aay.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aaz = new MediaData();
                    this.aaz.parserProtobuf(threadInfo.pic_info);
                }
                this.aac = threadInfo.is_called.intValue();
                this.aaA = threadInfo.middle_page_num.intValue();
                this.aaB = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.origin_thread_info != null) {
                    this.aaC = new OriginalThreadInfo();
                    this.aaC.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.aaC = new OriginalThreadInfo();
                    this.aaC.parser(threadInfo.origin_thread_info);
                } else {
                    this.aaC = null;
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
                this.Zt = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.YQ = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.YR = jSONObject.optLong("last_time_int", 0L);
                this.YS = jSONObject.optInt("is_top", 0);
                this.YT = jSONObject.optInt("is_good", 0);
                this.YU = jSONObject.optInt("is_livepost", 0);
                this.YV.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.YW.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.YX = jSONObject.optInt("has_commented", 0);
                this.YY = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.Zf = jSONObject.optInt("collect_status");
                this.Zg = jSONObject.optString("collect_mark_pid");
                this.Zh = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aas = jSONObject.optInt("agree_num");
                this.aav = jSONObject.optLong("share_num");
                this.Zk = jSONObject.optString("first_post_id", "0");
                this.Zv = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Zl = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.ZP.parserJson(optJSONObject2);
                }
                if ((this.YW == null || this.YW.getUserId() == null) && this.userMap != null) {
                    this.YW = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.Zs = new AlaInfoData();
                this.Zs.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.Za = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Zb.add(mediaData);
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
                        this.Zc.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Zx.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.Zy = new bn();
                    this.Zy.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.Zz = new d();
                    this.Zz.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.ZA = new m();
                    this.ZA.parserJson(optJSONObject6);
                }
                this.Zi.setUserMap(this.userMap);
                this.Zi.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.Zj.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.Zi.setTitle(this.title);
                } else {
                    this.Zi.setTitle(this.Za);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.ZP.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ZQ.add(aVar2);
                    }
                }
                this.ZW = jSONObject.optInt("is_book_chapter", 0);
                this.ZX.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.aad = jSONObject.optString("recom_source");
                this.aai = jSONObject.optString("recom_reason");
                this.aae = jSONObject.optString("recom_weight");
                this.aag = jSONObject.optLong("last_read_pid");
                this.aah = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.Zr = new bj();
                    this.Zr.e(optJSONObject8);
                }
                this.aar = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aaw = new ad();
                    this.aaw.parserJson(optJSONObject9);
                }
                this.aax = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aay = new c();
                    this.aay.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aaz = new MediaData();
                    this.aaz.parserJson(optJSONObject11);
                }
                this.aac = jSONObject.optInt("is_called", 0);
                this.aaA = jSONObject.optInt("middle_page_num", 0);
                this.aaB = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.Zq = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.aaC = new OriginalThreadInfo();
                        this.aaC.parserJson(optJSONObject13);
                        return;
                    }
                    this.aaC = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rV() {
        return this.YZ;
    }

    public boolean rW() {
        return rq() != 0;
    }

    public int rX() {
        if (this.ZP != null) {
            long qV = this.ZP.qV();
            long qW = this.ZP.qW();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qV) {
                return 1;
            }
            if (currentTimeMillis > qW) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rY() {
        if (sa() && this.Zx.size() >= 1) {
            a aVar = this.Zx.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pp = aVar.pp();
            int pq = aVar.pq();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pp) {
                return 4;
            }
            return currentTimeMillis > pq ? 2 : 1;
        }
        return -1;
    }

    public int rZ() {
        if (!sa() || this.Zx.size() < 1 || this.Zx.get(0) == null) {
            return -1;
        }
        return this.Zx.get(0).po();
    }

    public boolean sa() {
        return this.Zn == 1;
    }

    public String sb() {
        return (!sa() || this.Zx.size() < 1 || this.Zx.get(0) == null) ? "" : this.Zx.get(0).getUrl();
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0096d.cp_cont_f_1));
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
            if (getThreadType() == 42 && sc()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (rq() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (rq() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (rs() == 1 || this.YV.sV() != 0) {
                if (rb() != null && getThreadType() == 41) {
                    if (rX() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && so()) {
                Integer num = ZC.get(Integer.valueOf(rX()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rr() == 1 && !rW() && YD != getType() && YI != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (getType() == YM || getType() == YN) {
                arrayList.add(Integer.valueOf(d.f.icon_vote_blue));
            }
            if (this.Zj != null && this.Zj.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (rC() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            if (!z && rZ() == 2) {
                arrayList.add(Integer.valueOf(d.f.label_frs_activity_shai));
            } else {
                Integer num2 = ZB.get(new Point(rZ(), rY()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rI() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (rJ() != null) {
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
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.YP));
                spannableString.setSpan(jVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder c = !z && rq() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.YZ = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<k.a> arrayList) {
        if (si() || !rx() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new k.a(d.j.god_title));
        }
        return com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean sc() {
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
        this.YZ = spannableStringBuilder;
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
            if (this.Zl == 1) {
                this.YZ = a2;
                return a2;
            }
        } else if (this.Zl == 1) {
            this.YZ = new SpannableStringBuilder();
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
        if (this.ZY != null && this.ZY.size() > 0) {
            int size = this.ZY.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ZY.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (si()) {
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

    public void sd() {
        d(false, false);
    }

    public void se() {
        d(true, false);
    }

    public void sf() {
        d(false, true);
    }

    public AnchorInfoData sg() {
        return this.Zj;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sh() {
        return this.threadType == 36;
    }

    public boolean si() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sj() {
        return this.Zw;
    }

    public void bW(int i) {
        this.Zw = i;
    }

    public long sk() {
        return this.ZH;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rG = rG();
        if (rG == null || rW()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rG.size() || i2 >= 3) {
                break;
            }
            if (rG.get(i2) != null && rG.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rG.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rG.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rG.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.Zq != null && !StringUtils.isNull(this.Zq.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.Zq.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.YW != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.YW.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean sl() {
        String userId;
        return this.YW == null || (userId = this.YW.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        int rq = rq();
        if (this.Zs != null && this.threadType == 60) {
            return YG;
        }
        if (this.Zs != null && this.threadType == 49) {
            return YE;
        }
        if (this.threadType == 51) {
            return YF;
        }
        if (rq == 2 || rq == 1) {
            return Yz;
        }
        if (this.Zq != null && sw()) {
            return YO;
        }
        if (this.Zq != null) {
            if (rz()) {
                return YI;
            }
            return YD;
        } else if (this.isShareThread) {
            return YH;
        } else {
            if (rh() != null && getThreadType() == 36 && rh().type.intValue() == 2) {
                return YM;
            }
            if (rh() != null && getThreadType() == 36 && rh().type.intValue() == 1) {
                return YN;
            }
            if (sm()) {
                return YJ.get() ? ZO : YA;
            } else if (sa() && rZ() == 1) {
                return YJ.get() ? ZT : YA;
            } else if (sa() && rZ() == 2) {
                return YJ.get() ? ZN : YA;
            } else if (isLinkThread()) {
                return YB;
            } else {
                if (rz()) {
                    return YC;
                }
                return YA;
            }
        }
    }

    public boolean sm() {
        return rb() != null && getThreadType() == 41 && rs() == 1 && rX() == 2;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sn() {
        return this.ZG;
    }

    public List<TwAnchorProfitItem> pY() {
        return this.Xg;
    }

    public void i(ArrayList<n> arrayList) {
        if (this.Zl == 1) {
            this.VW = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.VW = 0;
        } else {
            this.VW = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.pH() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pH().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.VW = next.pI();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean so() {
        return this.threadType == 41;
    }

    public boolean sp() {
        return this.threadType == 48;
    }

    public boolean sq() {
        return this.ZU;
    }

    public void al(boolean z) {
        this.ZU = z;
    }

    public String sr() {
        return this.ZV;
    }

    public m ss() {
        return this.ZA;
    }

    public boolean st() {
        return rs() == 1 || rr() == 1 || rq() == 1 || sa() || this.ZW == 1 || rz() || rJ() != null || rI() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || sp() || ry();
    }

    public void su() {
        if (this.Zu == 0) {
            this.Zu = 1;
        }
    }

    public boolean sv() {
        return this.aaa;
    }

    public void am(boolean z) {
        this.aaj = z;
    }

    public boolean sw() {
        return this.aaj;
    }

    public void bX(int i) {
        this.aak = i + 1;
    }

    public int sx() {
        return this.aak;
    }

    public List<ReportInfo> sy() {
        return this.aal;
    }

    public boolean sz() {
        return this.aab;
    }

    public void an(boolean z) {
        this.aab = z;
    }

    public bj sA() {
        return this.Zr;
    }

    public void a(bj bjVar) {
        this.Zr = bjVar;
    }

    public void bY(int i) {
        if (this.Zr != null) {
            this.Zr.mCurrentPage = i;
        }
    }

    public boolean sB() {
        return getThreadType() == 49;
    }

    public boolean sC() {
        return getThreadType() == 40;
    }

    public boolean sD() {
        return getThreadType() == 50;
    }

    public boolean sE() {
        return getThreadType() == 60;
    }

    public boolean sF() {
        return getThreadType() == 40 && sA() != null && sA().channelId > 0;
    }

    public int sG() {
        return this.aaq;
    }

    public void setSmartFrsPosition(int i) {
        this.aaq = i;
    }

    public SparseArray<String> ql() {
        return this.Xy;
    }

    public void a(SparseArray<String> sparseArray) {
        this.Xy = sparseArray;
    }

    public String sH() {
        return this.aad;
    }

    public boolean sI() {
        return this.aar;
    }

    public int sJ() {
        return this.aas;
    }

    public int sK() {
        return this.aat;
    }

    public void bZ(int i) {
        this.aat = i;
    }

    public void ca(int i) {
        this.aas = i;
    }

    public long sL() {
        return this.aav;
    }

    public void n(long j) {
        this.aav = j;
    }

    public PostData sM() {
        return this.aau;
    }

    public ad sN() {
        return this.aaw;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.Zl == 1) {
            g = g(this.Za, false);
            a = cJ(this.Za);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.YZ = spannableStringBuilder;
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
            g(this.Za, false);
            cJ = cJ(this.Za);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cJ);
        this.YZ = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<k.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<k.a> arrayList = new ArrayList<>();
        boolean rx = rx();
        if (z2) {
            if (z) {
                if (rx && !si()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if (rs() == 1 || getThreadType() == 33 || (ru() != null && ru().sV() != 0)) {
                    if (rb() != null && so()) {
                        if (rX() == 2) {
                            arrayList.add(new k.a(d.j.interview_live));
                        }
                    } else if (!rx) {
                        arrayList.add(new k.a(d.j.photo_live_tips));
                    }
                }
                if (rq() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (rr() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (so()) {
                    arrayList.add(aan.get(rX()));
                }
                if (sa()) {
                    Integer num = aam.get(new Point(rZ(), rY()));
                    if (num != null) {
                        arrayList.add(new k.a(num.intValue(), d.C0096d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (sp()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (rI() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0096d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
            } else {
                if (rx && rq() != 1 && !si()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if ((rs() == 1 || getThreadType() == 33) && !so() && !rx) {
                    arrayList.add(new k.a(d.j.photo_live_tips));
                }
                if (rr() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (rq() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (so() && rb() != null && rX() == 2) {
                    arrayList.add(new k.a(d.j.interview_live));
                }
                if (sa()) {
                    Integer num2 = aam.get(new Point(rZ(), rY()));
                    if (num2 != null) {
                        arrayList.add(new k.a(num2.intValue(), d.C0096d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (this.ZW == 1) {
                    arrayList.add(new k.a(d.j.card_tbread_text));
                }
                if (rJ() != null) {
                    arrayList.add(new k.a(d.j.send_app_code_gift, d.C0096d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (rI() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0096d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (sp()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
                if (z3 && sB()) {
                    arrayList.add(new k.a(d.j.ala_live));
                }
                if (sF()) {
                    arrayList.add(new k.a(d.j.frs_channel_tip));
                } else if (z3 && sD()) {
                    arrayList.add(new k.a(d.j.live_record));
                } else if (sC()) {
                    arrayList.add(new k.a(d.j.video_title_str));
                }
                if (z4) {
                    arrayList.add(new k.a(d.j.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public MediaData sO() {
        return this.aaz;
    }

    public void j(ArrayList<MediaData> arrayList) {
        this.Zb = arrayList;
    }
}
