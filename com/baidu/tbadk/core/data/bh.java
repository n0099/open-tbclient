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
public class bh extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.f, com.baidu.tbadk.core.util.ae {
    public TwZhiBoUser WS;
    public List<TwAnchorProfitItem> WT;
    private SpannableStringBuilder YM;
    public int YQ;
    private int YR;
    private int YU;
    private String YX;
    private int YY;
    private String YZ;
    private SkinInfo ZF;
    private boolean ZH;
    private String ZI;
    private boolean ZN;
    private boolean ZO;
    public String ZQ;
    public String ZR;
    public String ZS;
    public long ZT;
    public String ZV;
    private List<ReportInfo> ZY;
    private int Zb;
    private VideoInfo Zd;
    private bm Ze;
    private c Zf;
    private long Zg;
    private n Zn;
    private LiveCoverStatus Zt;
    private long Zu;
    private p aae;
    private boolean aaf;
    private int aah;
    private long aaj;
    private ah aak;
    public d aam;
    private MediaData aan;
    public int aao;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    private String latitude;
    private long mCreateTime;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Yn = BdUniqueId.gen();
    public static final BdUniqueId Yo = BdUniqueId.gen();
    public static final BdUniqueId Yp = BdUniqueId.gen();
    public static final BdUniqueId Yq = BdUniqueId.gen();
    public static final BdUniqueId Yr = BdUniqueId.gen();
    public static final BdUniqueId Ys = BdUniqueId.gen();
    public static final BdUniqueId Yt = BdUniqueId.gen();
    public static final BdUniqueId Yu = BdUniqueId.gen();
    public static final BdUniqueId Yv = BdUniqueId.gen();
    public static AtomicBoolean Yw = new AtomicBoolean(false);
    public static AtomicBoolean Yx = new AtomicBoolean(false);
    public static AtomicBoolean Yy = new AtomicBoolean(false);
    public static final BdUniqueId Yz = BdUniqueId.gen();
    public static final BdUniqueId YA = BdUniqueId.gen();
    public static final BdUniqueId YB = BdUniqueId.gen();
    private static HashMap<Point, Integer> Zo = new HashMap<>();
    private static HashMap<Integer, Integer> Zp = new HashMap<>();
    public static final BdUniqueId ZA = BdUniqueId.gen();
    public static final BdUniqueId ZB = BdUniqueId.gen();
    public static final BdUniqueId ZG = BdUniqueId.gen();
    private static HashMap<Point, Integer> ZZ = new HashMap<>();
    private static SparseArray<m.a> aaa = new SparseArray<>(3);
    public int YC = 1;
    private String YT = null;
    private int Vv = 0;
    public int Zh = 0;
    private String Zi = "";
    private String Zq = "";
    public boolean ZU = true;
    public boolean aab = false;
    public boolean aac = false;
    private int aad = -1;
    private SparseArray<String> Xm = null;
    public boolean aal = false;
    private String id = null;
    private String Xl = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int YD = 0;
    private int view_num = 0;
    private String last_time = null;
    private long YE = 0;
    private int YF = 0;
    private int YG = 0;
    private int YH = 0;
    private bk YI = new bk();
    private MetaData YJ = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> YO = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> YP = new ArrayList<>();
    private int YK = 0;
    private int YL = 0;
    private String ad_url = null;
    private String YN = null;
    private String from = null;
    private int YS = 0;
    private PraiseData YV = new PraiseData();
    private AnchorInfoData YW = new AnchorInfoData();
    private long time = 0;
    private int Za = 0;
    private ArrayList<a> Zk = new ArrayList<>();
    private bq Zl = null;
    private e Zm = null;
    private int Zr = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> Zc = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Zs = null;
    private int Zj = 0;
    private PollInfo Zv = null;
    private boolean Zw = false;
    private boolean Zx = false;
    private int Zy = 0;
    private boolean Zz = false;
    private int anchorLevel = 0;
    public int ZJ = 0;
    public k ZK = new k();
    private List<PbContent> ZL = new ArrayList();
    private List<PbContent> ZM = new ArrayList();
    private String category_name = null;
    private bf ZC = new bf();
    private ArrayList<com.baidu.tbadk.data.a> ZD = new ArrayList<>();
    private PushStatusData ZE = new PushStatusData();
    public boolean ZW = false;
    public int ZX = -1;
    private int aag = 0;
    private PostData aai = new PostData();
    private int ZP = 0;
    public int aap = 0;
    private String tieba_game_information_source = "";

    static {
        Zo.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        Zo.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        Zo.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        Zo.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        Zo.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        Zo.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        Zo.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        Zo.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        ZZ.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        ZZ.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        ZZ.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        ZZ.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        ZZ.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        ZZ.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        ZZ.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        ZZ.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        Zp.put(1, Integer.valueOf(d.f.label_interview_no));
        Zp.put(2, Integer.valueOf(d.f.label_interview_live));
        Zp.put(3, Integer.valueOf(d.f.label_interview_off));
        aaa.put(1, new m.a(d.j.interview_live_status_not_start, d.C0080d.cp_other_b, d.f.pic_dot_title_red));
        aaa.put(2, new m.a(d.j.interview_live_status_ing, d.C0080d.cp_other_c, d.f.pic_dot_title_green));
        aaa.put(3, new m.a(d.j.interview_live_status_over, d.C0080d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bh() {
        this.YR = 0;
        this.Zb = 0;
        this.Zu = 0L;
        this.aao = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Zu = 0L;
        this.Zb = 0;
        this.YR = 0;
        this.aao = 0;
    }

    public boolean qY() {
        return this.YR == 1;
    }

    public bf qZ() {
        return this.ZC;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bN(int i) {
        this.anchorLevel = i;
    }

    public int ra() {
        return this.Zb;
    }

    public int rb() {
        return this.ZP;
    }

    public void bO(int i) {
        this.ZP = i;
    }

    public boolean rc() {
        return this.Zw;
    }

    public boolean rd() {
        return this.Zx;
    }

    public void bP(int i) {
        this.Zy = i;
    }

    public int re() {
        return this.Zy;
    }

    public PollInfo rf() {
        return this.Zv;
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

    public long rg() {
        return this.Zg;
    }

    public String rh() {
        return this.YX;
    }

    public PraiseData ri() {
        return this.YV;
    }

    public void a(PraiseData praiseData) {
        this.YV = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rj() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cD(String str) {
        this.Xl = str;
    }

    public String rk() {
        return this.tieba_game_information_source;
    }

    public String getTid() {
        return (StringUtils.isNull(this.Xl) || "0".equals(this.Xl)) ? this.id : this.Xl;
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

    public int rl() {
        return this.reply_num;
    }

    public int rm() {
        return this.view_num;
    }

    public void bR(int i) {
        this.view_num = i;
    }

    public long rn() {
        return this.YE;
    }

    public void m(long j) {
        this.YE = j;
    }

    public int ro() {
        return this.YF;
    }

    public void bS(int i) {
        this.YF = i;
    }

    public int rp() {
        return this.YG;
    }

    public void bT(int i) {
        this.YG = i;
    }

    public int rq() {
        return this.YH;
    }

    public List<PbContent> rr() {
        return this.ZL;
    }

    public bk rs() {
        return this.YI;
    }

    public MetaData rt() {
        return this.YJ;
    }

    public UserTbVipInfoData ru() {
        if (this.YJ == null) {
            return null;
        }
        return this.YJ.getUserTbVipInfoData();
    }

    public boolean rv() {
        return this.is_god != 0;
    }

    public boolean rw() {
        return this.is_god == 1;
    }

    public boolean rx() {
        return (this.YJ == null || this.YJ.getGodUserData() == null || this.YJ.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean ry() {
        return (this.YJ == null || this.YJ.getGodUserData() == null || this.YJ.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.YJ = metaData;
    }

    public String rz() {
        return this.forum_name;
    }

    public void cH(String str) {
        this.forum_name = str;
    }

    public int rA() {
        return this.YL;
    }

    public String rB() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.YN;
    }

    public void cI(String str) {
        this.YN = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.ZM == null || this.ZM.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.ZM.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.ZM.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.ZL == null || (size = this.ZL.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.ZL.get(i2);
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
        if (this.ZM != null && (size = this.ZM.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ZM.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bh.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bh.this.cN(pbContent.link);
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

    public int rC() {
        return this.YS;
    }

    public void bU(int i) {
        this.YS = i;
    }

    public String rD() {
        return this.YT;
    }

    public void cK(String str) {
        this.YT = str;
    }

    public ArrayList<MediaData> rE() {
        return this.YO;
    }

    public ArrayList<a> rF() {
        return this.Zk;
    }

    public void h(ArrayList<a> arrayList) {
        this.Zk = arrayList;
    }

    public bq rG() {
        return this.Zl;
    }

    public e rH() {
        return this.Zm;
    }

    public ArrayList<VoiceData.VoiceModel> rI() {
        return this.YP;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rJ() {
        return this.YY;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rK() {
        return this.Zi;
    }

    public VideoInfo rL() {
        return this.Zd;
    }

    public void a(c cVar) {
        this.Zf = cVar;
    }

    public c rM() {
        return this.Zf;
    }

    public String getPhotoLiveCover() {
        return this.Zq;
    }

    public void setPhotoLiveCover(String str) {
        this.Zq = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rN() {
        return this.Zc;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.Zc.clear();
        this.Zc.addAll(arrayList);
    }

    public String getNotice() {
        return this.Zs;
    }

    public PushStatusData rO() {
        return this.ZE;
    }

    public SkinInfo rP() {
        return this.ZF;
    }

    public long rQ() {
        return this.ZT;
    }

    public boolean rR() {
        return this.ZU;
    }

    public String rS() {
        return this.ZV;
    }

    public p rT() {
        return this.aae;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.YZ = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.YR = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.Xl = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.Zg = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.YD = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.YE = threadInfo.last_time_int.intValue();
                this.YF = threadInfo.is_top.intValue();
                this.YG = threadInfo.is_good.intValue();
                this.YH = threadInfo.is_livepost.intValue();
                this.YI.a(threadInfo.topic);
                this.YJ.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.YK = threadInfo.has_commented.intValue();
                this.YL = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Zd = threadInfo.video_info;
                this.Zf = new c();
                this.Zf.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.YS = threadInfo.collect_status.intValue();
                this.YT = threadInfo.collect_mark_pid;
                this.YU = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.YX = threadInfo.first_post_id + "";
                this.Zi = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.YY = threadInfo.is_ntitle.intValue();
                this.Za = threadInfo.is_activity.intValue();
                this.aag = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aah = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aaj = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.Zb = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ZN = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ZL = threadInfo.rich_title;
                this.ZM = threadInfo.rich_abstract;
                this.YQ = threadInfo.is_godthread_recommend.intValue();
                if ((this.YJ == null || this.YJ.getUserId() == null || this.YJ.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.YJ = metaData;
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
                this.YN = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.YO.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Zd = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.Ze = new bm();
                    this.Ze.a(threadInfo.video_channel_info);
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
                        this.YP.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Zk.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Zl = new bq();
                    this.Zl.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Zm = new e();
                    this.Zm.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Zn = new n();
                    this.Zn.a(threadInfo.cartoon_info);
                }
                this.YV.setUserMap(this.userMap);
                this.YV.parserProtobuf(threadInfo.zan);
                this.YW.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.YV.setTitle(this.title);
                } else {
                    this.YV.setTitle(this.YN);
                }
                this.Zq = threadInfo.livecover_src;
                this.Zr = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Zj = threadInfo.post_num.intValue();
                this.Zu = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.eu(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Zc.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Zs = noticeInfo.notice;
                    }
                    this.Zy = zhiBoInfoTW.copythread_remind.intValue();
                    this.Zw = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Zx = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Zq)) {
                        this.Zq = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.WS = zhiBoInfoTW.user.tw_anchor_info;
                        this.WT = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Zt = threadInfo.twzhibo_info.livecover_status;
                    this.Zu = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Zv = threadInfo.poll_info;
                this.Zz = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.ZC.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.ZD.add(aVar2);
                    }
                }
                this.ZE.parserProtobuf(threadInfo.push_status);
                this.ZI = threadInfo.lego_card;
                this.ZF = threadInfo.skin_info;
                this.ZJ = threadInfo.is_book_chapter.intValue();
                this.ZK.a(threadInfo.book_chapter);
                this.ZQ = threadInfo.recom_source;
                this.ZV = threadInfo.recom_reason;
                this.ZR = threadInfo.recom_weight;
                this.ZS = threadInfo.ab_tag;
                this.ZT = threadInfo.last_read_pid.longValue();
                this.ZU = threadInfo.cheak_repeat.intValue() == 1;
                this.ZY = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aai.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.u(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.Xm = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.v.v(threadInfo.declare_list)) {
                    this.aae = new p();
                    this.aae.a(threadInfo);
                }
                this.aaf = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aak = new ah();
                    this.aak.a(threadInfo.link_info);
                }
                this.aal = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aam = new d();
                    this.aam.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aan = new MediaData();
                    this.aan.parserProtobuf(threadInfo.pic_info);
                }
                this.ZP = threadInfo.is_called.intValue();
                this.aao = threadInfo.middle_page_num.intValue();
                this.aap = threadInfo.middle_page_pass_flag.intValue();
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
                this.Xl = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.is_god = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.Zg = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.YD = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.YE = jSONObject.optLong("last_time_int", 0L);
                this.YF = jSONObject.optInt("is_top", 0);
                this.YG = jSONObject.optInt("is_good", 0);
                this.YH = jSONObject.optInt("is_livepost", 0);
                this.YI.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.YJ.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.YK = jSONObject.optInt("has_commented", 0);
                this.YL = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.YS = jSONObject.optInt("collect_status");
                this.YT = jSONObject.optString("collect_mark_pid");
                this.YU = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aag = jSONObject.optInt("agree_num");
                this.aaj = jSONObject.optLong("share_num");
                this.YX = jSONObject.optString("first_post_id", "0");
                this.Zi = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.YY = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.ZC.parserJson(optJSONObject2);
                }
                if (this.YJ == null || this.YJ.getUserId() == null) {
                    this.YJ = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.Zf = new c();
                this.Zf.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.YN = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.YO.add(mediaData);
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
                        this.YP.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Zk.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.Zl = new bq();
                    this.Zl.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.Zm = new e();
                    this.Zm.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.Zn = new n();
                    this.Zn.parserJson(optJSONObject6);
                }
                this.YV.setUserMap(this.userMap);
                this.YV.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.YW.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.YV.setTitle(this.title);
                } else {
                    this.YV.setTitle(this.YN);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.ZC.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ZD.add(aVar2);
                    }
                }
                this.ZJ = jSONObject.optInt("is_book_chapter", 0);
                this.ZK.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.ZQ = jSONObject.optString("recom_source");
                this.ZV = jSONObject.optString("recom_reason");
                this.ZR = jSONObject.optString("recom_weight");
                this.ZT = jSONObject.optLong("last_read_pid");
                this.ZU = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.Ze = new bm();
                    this.Ze.f(optJSONObject8);
                }
                this.aaf = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aak = new ah();
                    this.aak.parserJson(optJSONObject9);
                }
                this.aal = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aam = new d();
                    this.aam.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aan = new MediaData();
                    this.aan.parserJson(optJSONObject11);
                }
                this.ZP = jSONObject.optInt("is_called", 0);
                this.aao = jSONObject.optInt("middle_page_num", 0);
                this.aap = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.Zd = builder.build(true);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rU() {
        return this.YM;
    }

    public boolean rV() {
        return ro() != 0;
    }

    public int rW() {
        if (this.ZC != null) {
            long qT = this.ZC.qT();
            long qU = this.ZC.qU();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qT) {
                return 1;
            }
            if (currentTimeMillis > qU) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rX() {
        if (rZ() && this.Zk.size() >= 1) {
            a aVar = this.Zk.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pk = aVar.pk();
            int pl = aVar.pl();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pk) {
                return 4;
            }
            return currentTimeMillis > pl ? 2 : 1;
        }
        return -1;
    }

    public int rY() {
        if (!rZ() || this.Zk.size() < 1 || this.Zk.get(0) == null) {
            return -1;
        }
        return this.Zk.get(0).pj();
    }

    public boolean rZ() {
        return this.Za == 1;
    }

    public String sa() {
        return (!rZ() || this.Zk.size() < 1 || this.Zk.get(0) == null) ? "" : this.Zk.get(0).getUrl();
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0080d.cp_cont_f_1));
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
            if (getThreadType() == 42 && sb()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (ro() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (ro() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (rq() == 1 || this.YI.sV() != 0) {
                if (qZ() != null && getThreadType() == 41) {
                    if (rW() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && sn()) {
                Integer num = Zp.get(Integer.valueOf(rW()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rp() == 1 && !rV() && Yr != getType() && Yv != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (getType() == Yz || getType() == YA) {
                arrayList.add(Integer.valueOf(d.f.icon_vote_blue));
            }
            if (this.YW != null && this.YW.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (rA() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            if (!z && rY() == 2) {
                arrayList.add(Integer.valueOf(d.f.label_frs_activity_shai));
            } else {
                Integer num2 = Zo.get(new Point(rY(), rX()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rG() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (rH() != null) {
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
                Bitmap cQ = com.baidu.tbadk.core.util.aj.cQ(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.YC));
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
            SpannableStringBuilder c = !z && ro() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.YM = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<m.a> arrayList) {
        if (sh() || !rv() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new m.a(d.j.god_title));
        }
        return com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean sb() {
        return com.baidu.adp.lib.b.d.eV().af("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.u(a(z, z2, z3, false)) > 0) {
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
        this.YM = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> a = a(z, z2, z3, z4);
        if (a == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, a, false);
        if (a.size() > 0) {
            if (a2 == null) {
                a2 = new SpannableStringBuilder();
            }
            if (this.YY == 1) {
                this.YM = a2;
                return a2;
            }
        } else if (this.YY == 1) {
            this.YM = new SpannableStringBuilder();
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
        if (this.ZL != null && this.ZL.size() > 0) {
            int size = this.ZL.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ZL.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (sh()) {
                            if (pbContent.text != null) {
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, cM(pbContent.text)) { // from class: com.baidu.tbadk.core.data.bh.2
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view) {
                                        bh.this.cN(getLink());
                                    }
                                }, i3, pbContent.text.length() + i3, 33);
                            }
                        } else {
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bh.3
                                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    bh.this.cN(pbContent.link);
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

    public void sc() {
        d(false, false);
    }

    public void sd() {
        d(true, false);
    }

    public void se() {
        d(false, true);
    }

    public AnchorInfoData sf() {
        return this.YW;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sg() {
        return this.threadType == 36;
    }

    public boolean sh() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int si() {
        return this.Zj;
    }

    public void bV(int i) {
        this.Zj = i;
    }

    public long sj() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rE = rE();
        if (rE == null || rV()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rE.size() || i2 >= 3) {
                break;
            }
            if (rE.get(i2) != null && rE.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rE.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rE.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rE.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.Zd != null && !StringUtils.isNull(this.Zd.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.Zd.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.YJ != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.YJ.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean sk() {
        String userId;
        return this.YJ == null || (userId = this.YJ.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        int ro = ro();
        if (this.Zf != null && this.threadType == 60) {
            return Yu;
        }
        if (this.Zf != null && this.threadType == 49) {
            return Ys;
        }
        if (this.threadType == 51) {
            return Yt;
        }
        if (ro == 2 || ro == 1) {
            return Yn;
        }
        if (this.Zd != null && sv()) {
            return YB;
        }
        if (this.Zd != null) {
            if (rx()) {
                return Yv;
            }
            return Yr;
        } else if (rf() != null && getThreadType() == 36 && rf().type.intValue() == 2) {
            return Yz;
        } else {
            if (rf() != null && getThreadType() == 36 && rf().type.intValue() == 1) {
                return YA;
            }
            if (sl()) {
                return Yw.get() ? ZB : Yo;
            } else if (rZ() && rY() == 1) {
                return Yw.get() ? ZG : Yo;
            } else if (rZ() && rY() == 2) {
                return Yw.get() ? ZA : Yo;
            } else if (isLinkThread()) {
                return Yp;
            } else {
                if (rx()) {
                    return Yq;
                }
                return Yo;
            }
        }
    }

    public boolean sl() {
        return qZ() != null && getThreadType() == 41 && rq() == 1 && rW() == 2;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sm() {
        return this.Zt;
    }

    public List<TwAnchorProfitItem> pX() {
        return this.WT;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.YY == 1) {
            this.Vv = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Vv = 0;
        } else {
            this.Vv = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.pC() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pC().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Vv = next.pD();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sn() {
        return this.threadType == 41;
    }

    public boolean so() {
        return this.threadType == 48;
    }

    public boolean sp() {
        return this.ZH;
    }

    public void al(boolean z) {
        this.ZH = z;
    }

    public String sq() {
        return this.ZI;
    }

    public n sr() {
        return this.Zn;
    }

    public boolean ss() {
        return rq() == 1 || rp() == 1 || ro() == 1 || rZ() || this.ZJ == 1 || rx() || rH() != null || rG() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || so() || rw();
    }

    public void st() {
        if (this.Zh == 0) {
            this.Zh = 1;
        }
    }

    public boolean su() {
        return this.ZN;
    }

    public void am(boolean z) {
        this.ZW = z;
    }

    public boolean sv() {
        return this.ZW;
    }

    public void bW(int i) {
        this.ZX = i + 1;
    }

    public int sw() {
        return this.ZX;
    }

    public List<ReportInfo> sx() {
        return this.ZY;
    }

    public boolean sy() {
        return this.ZO;
    }

    public void an(boolean z) {
        this.ZO = z;
    }

    public bm sz() {
        return this.Ze;
    }

    public void a(bm bmVar) {
        this.Ze = bmVar;
    }

    public void bX(int i) {
        if (this.Ze != null) {
            this.Ze.mCurrentPage = i;
        }
    }

    public boolean sA() {
        return getThreadType() == 49;
    }

    public boolean sB() {
        return getThreadType() == 40;
    }

    public boolean sC() {
        return getThreadType() == 50;
    }

    public boolean sD() {
        return getThreadType() == 60;
    }

    public boolean sE() {
        return getThreadType() == 40 && sz() != null && sz().channelId > 0;
    }

    public int sF() {
        return this.aad;
    }

    public void setSmartFrsPosition(int i) {
        this.aad = i;
    }

    public SparseArray<String> qk() {
        return this.Xm;
    }

    public void a(SparseArray<String> sparseArray) {
        this.Xm = sparseArray;
    }

    public String sG() {
        return this.ZQ;
    }

    public boolean sH() {
        return this.aaf;
    }

    public int sI() {
        return this.aag;
    }

    public int sJ() {
        return this.aah;
    }

    public void bY(int i) {
        this.aah = i;
    }

    public void bZ(int i) {
        this.aag = i;
    }

    public long sK() {
        return this.aaj;
    }

    public void n(long j) {
        this.aaj = j;
    }

    public PostData sL() {
        return this.aai;
    }

    public ah sM() {
        return this.aak;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.YY == 1) {
            g = g(this.YN, false);
            a = cJ(this.YN);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.YM = spannableStringBuilder;
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
            g(this.YN, false);
            cJ = cJ(this.YN);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cJ);
        this.YM = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<m.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean rv = rv();
        if (z2) {
            if (z) {
                if (rv && !sh()) {
                    arrayList.add(new m.a(d.j.god_title));
                }
                if (rq() == 1 || getThreadType() == 33 || (rs() != null && rs().sV() != 0)) {
                    if (qZ() != null && sn()) {
                        if (rW() == 2) {
                            arrayList.add(new m.a(d.j.interview_live));
                        }
                    } else if (!rv) {
                        arrayList.add(new m.a(d.j.photo_live_tips));
                    }
                }
                if (ro() == 1) {
                    arrayList.add(new m.a(d.j.top));
                }
                if (rp() == 1) {
                    arrayList.add(new m.a(d.j.good));
                }
                if (sn()) {
                    arrayList.add(aaa.get(rW()));
                }
                if (rZ()) {
                    Integer num = ZZ.get(new Point(rY(), rX()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), d.C0080d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.j.card_promotion_text));
                    }
                }
                if (so()) {
                    arrayList.add(new m.a(d.j.evaluation));
                }
                if (rG() != null) {
                    arrayList.add(new m.a(d.j.card_promotion_text, d.C0080d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (rv && ro() != 1 && !sh()) {
                    arrayList.add(new m.a(d.j.god_title));
                }
                if ((rq() == 1 || getThreadType() == 33) && !sn() && !rv) {
                    arrayList.add(new m.a(d.j.photo_live_tips));
                }
                if (rp() == 1) {
                    arrayList.add(new m.a(d.j.good));
                }
                if (ro() == 1) {
                    arrayList.add(new m.a(d.j.top));
                }
                if (sn() && qZ() != null && rW() == 2) {
                    arrayList.add(new m.a(d.j.interview_live));
                }
                if (rZ()) {
                    Integer num2 = ZZ.get(new Point(rY(), rX()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), d.C0080d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.j.card_promotion_text));
                    }
                }
                if (this.ZJ == 1) {
                    arrayList.add(new m.a(d.j.card_tbread_text));
                }
                if (rH() != null) {
                    arrayList.add(new m.a(d.j.send_app_code_gift, d.C0080d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (rG() != null) {
                    arrayList.add(new m.a(d.j.card_promotion_text, d.C0080d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (so()) {
                    arrayList.add(new m.a(d.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && sA()) {
                    arrayList.add(new m.a(d.j.ala_live));
                }
                if (sE()) {
                    arrayList.add(new m.a(d.j.frs_channel_tip));
                } else if (z3 && sC()) {
                    arrayList.add(new m.a(d.j.live_record));
                } else if (sB()) {
                    arrayList.add(new m.a(d.j.video_title_str));
                }
                if (z4) {
                    arrayList.add(new m.a(d.j.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public MediaData sN() {
        return this.aan;
    }

    public void j(ArrayList<MediaData> arrayList) {
        this.YO = arrayList;
    }
}
