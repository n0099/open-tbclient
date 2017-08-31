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
import com.baidu.tbadk.core.atomData.SelectCoverActivityConfig;
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
public class bj extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.f, com.baidu.tbadk.core.util.ae {
    public TwZhiBoUser WL;
    public List<TwAnchorProfitItem> WM;
    private SpannableStringBuilder YE;
    public int YI;
    private int YJ;
    private int YL;
    private String YO;
    private int YP;
    private String YQ;
    private int YS;
    private VideoInfo YU;
    private bo YV;
    private c YW;
    private boolean ZE;
    private boolean ZF;
    public String ZH;
    public String ZI;
    public String ZJ;
    public long ZK;
    public String ZM;
    private List<ReportInfo> ZP;
    private p ZV;
    private boolean ZW;
    private int ZY;
    private n Ze;
    private LiveCoverStatus Zk;
    private long Zl;
    private SkinInfo Zw;
    private boolean Zy;
    private String Zz;
    private long aaa;
    private aj aab;
    public d aad;
    private MediaData aae;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    private String latitude;
    private long mCreateTime;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Yg = BdUniqueId.gen();
    public static final BdUniqueId Yh = BdUniqueId.gen();
    public static final BdUniqueId Yi = BdUniqueId.gen();
    public static final BdUniqueId Yj = BdUniqueId.gen();
    public static final BdUniqueId Yk = BdUniqueId.gen();
    public static final BdUniqueId Yl = BdUniqueId.gen();
    public static final BdUniqueId Ym = BdUniqueId.gen();
    public static final BdUniqueId Yn = BdUniqueId.gen();
    public static final BdUniqueId Yo = BdUniqueId.gen();
    public static AtomicBoolean Yp = new AtomicBoolean(false);
    public static AtomicBoolean Yq = new AtomicBoolean(false);
    public static AtomicBoolean Yr = new AtomicBoolean(false);
    public static final BdUniqueId Ys = BdUniqueId.gen();
    public static final BdUniqueId Yt = BdUniqueId.gen();
    public static final BdUniqueId Yu = BdUniqueId.gen();
    private static HashMap<Point, Integer> Zf = new HashMap<>();
    private static HashMap<Integer, Integer> Zg = new HashMap<>();
    public static final BdUniqueId Zr = BdUniqueId.gen();
    public static final BdUniqueId Zs = BdUniqueId.gen();
    public static final BdUniqueId Zx = BdUniqueId.gen();
    private static HashMap<Point, Integer> ZQ = new HashMap<>();
    private static SparseArray<m.a> ZR = new SparseArray<>(3);
    public int Yv = 1;
    private String YK = null;
    private int Vb = 0;
    public int YY = 0;
    private String YZ = "";
    private String Zh = "";
    public boolean ZL = true;
    public boolean ZS = false;
    public boolean ZT = false;
    private int ZU = -1;
    private SparseArray<String> Xf = null;
    public boolean aac = false;
    private String id = null;
    private String Xe = null;
    private long fid = 0;
    private String title = null;
    private int YX = 0;
    private int reply_num = 0;
    private int Yw = 0;
    private int view_num = 0;
    private String last_time = null;
    private long Yx = 0;
    private int Yy = 0;
    private int Yz = 0;
    private int YA = 0;
    private bm YB = new bm();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> YG = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> YH = new ArrayList<>();
    private int YC = 0;
    private int YD = 0;
    private String ad_url = null;
    private String YF = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData YM = new PraiseData();
    private AnchorInfoData YN = new AnchorInfoData();
    private long time = 0;
    private int YR = 0;
    private ArrayList<a> Zb = new ArrayList<>();
    private bs Zc = null;
    private e Zd = null;
    private int Zi = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> YT = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Zj = null;
    private int Za = 0;
    private PollInfo Zm = null;
    private boolean Zn = false;
    private boolean Zo = false;
    private int Zp = 0;
    private boolean Zq = false;
    private int anchorLevel = 0;
    public int ZA = 0;
    public k ZB = new k();
    private List<PbContent> ZC = new ArrayList();
    private List<PbContent> ZD = new ArrayList();
    private String category_name = null;
    private bh Zt = new bh();
    private ArrayList<com.baidu.tbadk.data.a> Zu = new ArrayList<>();
    private PushStatusData Zv = new PushStatusData();
    public boolean ZN = false;
    public int ZO = -1;
    private int ZX = 0;
    private PostData ZZ = new PostData();
    private int ZG = 0;

    static {
        Zf.put(new Point(1, 1), Integer.valueOf(d.g.label_frs_lottery_ing));
        Zf.put(new Point(1, 2), Integer.valueOf(d.g.label_frs_lottery_over));
        Zf.put(new Point(1, 3), Integer.valueOf(d.g.label_frs_lottery_off));
        Zf.put(new Point(1, 4), Integer.valueOf(d.g.label_frs_lottery_d));
        Zf.put(new Point(2, 1), Integer.valueOf(d.g.label_frs_activity_shaiing));
        Zf.put(new Point(2, 2), Integer.valueOf(d.g.label_frs_activity_shai_over));
        Zf.put(new Point(2, 3), Integer.valueOf(d.g.label_frs_activity_shai_off));
        Zf.put(new Point(2, 4), Integer.valueOf(d.g.label_frs_activity_shai_d));
        ZQ.put(new Point(1, 1), Integer.valueOf(d.l.lottery_status_ing));
        ZQ.put(new Point(1, 2), Integer.valueOf(d.l.lottery_status_over));
        ZQ.put(new Point(1, 3), Integer.valueOf(d.l.lottery_status_off));
        ZQ.put(new Point(1, 4), Integer.valueOf(d.l.lottery_status_not_start));
        ZQ.put(new Point(2, 1), Integer.valueOf(d.l.share_picture_status_ing));
        ZQ.put(new Point(2, 2), Integer.valueOf(d.l.share_picture_status_over));
        ZQ.put(new Point(2, 3), Integer.valueOf(d.l.share_picture_status_off));
        ZQ.put(new Point(2, 4), Integer.valueOf(d.l.share_picture_status_not_start));
        Zg.put(1, Integer.valueOf(d.g.label_interview_no));
        Zg.put(2, Integer.valueOf(d.g.label_interview_live));
        Zg.put(3, Integer.valueOf(d.g.label_interview_off));
        ZR.put(1, new m.a(d.l.interview_live_status_not_start, d.e.cp_other_b, d.g.pic_dot_title_red));
        ZR.put(2, new m.a(d.l.interview_live_status_ing, d.e.cp_other_c, d.g.pic_dot_title_green));
        ZR.put(3, new m.a(d.l.interview_live_status_over, d.e.cp_other_d, d.g.pic_dot_title_blue));
    }

    public bj() {
        this.YJ = 0;
        this.YS = 0;
        this.Zl = 0L;
        this.post_num = 0;
        this.post_num = 0;
        this.Zl = 0L;
        this.YS = 0;
        this.YJ = 0;
    }

    public boolean rh() {
        return this.YJ == 1;
    }

    public bh ri() {
        return this.Zt;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bO(int i) {
        this.anchorLevel = i;
    }

    public int rj() {
        return this.YS;
    }

    public boolean rk() {
        return this.Zq;
    }

    public int rl() {
        return this.ZG;
    }

    public void bP(int i) {
        this.ZG = i;
    }

    public boolean rm() {
        return this.Zn;
    }

    public boolean rn() {
        return this.Zo;
    }

    public void bQ(int i) {
        this.Zp = i;
    }

    public int ro() {
        return this.Zp;
    }

    public PollInfo rp() {
        return this.Zm;
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

    public String rq() {
        return this.YO;
    }

    public PraiseData rr() {
        return this.YM;
    }

    public void a(PraiseData praiseData) {
        this.YM = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rs() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cy(String str) {
        this.Xe = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.Xe) || "0".equals(this.Xe)) ? this.id : this.Xe;
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

    public int rt() {
        return this.reply_num;
    }

    public int ru() {
        return this.view_num;
    }

    public void bS(int i) {
        this.view_num = i;
    }

    public long rv() {
        return this.Yx;
    }

    public void m(long j) {
        this.Yx = j;
    }

    public int rw() {
        return this.Yy;
    }

    public void bT(int i) {
        this.Yy = i;
    }

    public int rx() {
        return this.Yz;
    }

    public void bU(int i) {
        this.Yz = i;
    }

    public int ry() {
        return this.YA;
    }

    public List<PbContent> rz() {
        return this.ZC;
    }

    public bm rA() {
        return this.YB;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rB() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rC() {
        return this.YX != 0;
    }

    public boolean rD() {
        return this.YX == 1;
    }

    public boolean rE() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rF() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rG() {
        return this.forum_name;
    }

    public void cC(String str) {
        this.forum_name = str;
    }

    public int rH() {
        return this.YD;
    }

    public String rI() {
        return this.ad_url;
    }

    public String rJ() {
        return this.YF;
    }

    public void cD(String str) {
        this.YF = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.ZD == null || this.ZD.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.ZD.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.ZD.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.ZC == null || (size = this.ZC.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.ZC.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cE(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.ZD != null && (size = this.ZD.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ZD.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bj.1
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bj.this.cH(pbContent.link);
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

    public String rK() {
        return this.YK;
    }

    public void cF(String str) {
        this.YK = str;
    }

    public ArrayList<MediaData> rL() {
        return this.YG;
    }

    public ArrayList<a> rM() {
        return this.Zb;
    }

    public void h(ArrayList<a> arrayList) {
        this.Zb = arrayList;
    }

    public bs rN() {
        return this.Zc;
    }

    public e rO() {
        return this.Zd;
    }

    public ArrayList<VoiceData.VoiceModel> rP() {
        return this.YH;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rQ() {
        return this.YP;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rR() {
        return this.YZ;
    }

    public VideoInfo rS() {
        return this.YU;
    }

    public void a(c cVar) {
        this.YW = cVar;
    }

    public c rT() {
        return this.YW;
    }

    public String getPhotoLiveCover() {
        return this.Zh;
    }

    public void setPhotoLiveCover(String str) {
        this.Zh = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rU() {
        return this.YT;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.YT.clear();
        this.YT.addAll(arrayList);
    }

    public String getNotice() {
        return this.Zj;
    }

    public PushStatusData rV() {
        return this.Zv;
    }

    public SkinInfo rW() {
        return this.Zw;
    }

    public long rX() {
        return this.ZK;
    }

    public boolean rY() {
        return this.ZL;
    }

    public String rZ() {
        return this.ZM;
    }

    public p sa() {
        return this.ZV;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.YQ = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.YJ = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.Xe = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.YX = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Yw = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.Yx = threadInfo.last_time_int.intValue();
                this.Yy = threadInfo.is_top.intValue();
                this.Yz = threadInfo.is_good.intValue();
                this.YA = threadInfo.is_livepost.intValue();
                this.YB.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.YC = threadInfo.has_commented.intValue();
                this.YD = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.YU = threadInfo.video_info;
                this.YW = new c();
                this.YW.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.YK = threadInfo.collect_mark_pid;
                this.YL = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.YO = threadInfo.first_post_id + "";
                this.YZ = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.YP = threadInfo.is_ntitle.intValue();
                this.YR = threadInfo.is_activity.intValue();
                this.ZX = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.ZY = threadInfo.agree.has_agree.intValue();
                }
                this.aaa = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.YS = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ZE = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ZC = threadInfo.rich_title;
                this.ZD = threadInfo.rich_abstract;
                this.YI = threadInfo.is_godthread_recommend.intValue();
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
                this.YF = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.YG.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.YU = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.YV = new bo();
                    this.YV.a(threadInfo.video_channel_info);
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
                        this.YH.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Zb.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Zc = new bs();
                    this.Zc.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Zd = new e();
                    this.Zd.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Ze = new n();
                    this.Ze.a(threadInfo.cartoon_info);
                }
                this.YM.setUserMap(this.userMap);
                this.YM.parserProtobuf(threadInfo.zan);
                this.YN.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.YM.setTitle(this.title);
                } else {
                    this.YM.setTitle(this.YF);
                }
                this.Zh = threadInfo.livecover_src;
                this.Zi = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Za = threadInfo.post_num.intValue();
                this.Zl = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.el(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.YT.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Zj = noticeInfo.notice;
                    }
                    this.Zp = zhiBoInfoTW.copythread_remind.intValue();
                    this.Zn = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Zo = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Zh)) {
                        this.Zh = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.WL = zhiBoInfoTW.user.tw_anchor_info;
                        this.WM = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Zk = threadInfo.twzhibo_info.livecover_status;
                    this.Zl = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Zm = threadInfo.poll_info;
                this.Zq = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Zt.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.Zu.add(aVar2);
                    }
                }
                this.Zv.parserProtobuf(threadInfo.push_status);
                this.Zz = threadInfo.lego_card;
                this.Zw = threadInfo.skin_info;
                this.ZA = threadInfo.is_book_chapter.intValue();
                this.ZB.a(threadInfo.book_chapter);
                this.ZH = threadInfo.recom_source;
                this.ZM = threadInfo.recom_reason;
                this.ZI = threadInfo.recom_weight;
                this.ZJ = threadInfo.ab_tag;
                this.ZK = threadInfo.last_read_pid.longValue();
                this.ZL = threadInfo.cheak_repeat.intValue() == 1;
                this.ZP = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.ZZ.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.u(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.Xf = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.v.v(threadInfo.declare_list)) {
                    this.ZV = new p();
                    this.ZV.a(threadInfo);
                }
                this.ZW = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aab = new aj();
                    this.aab.a(threadInfo.link_info);
                }
                this.aac = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aad = new d();
                    this.aad.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aae = new MediaData();
                    this.aae.parserProtobuf(threadInfo.pic_info);
                }
                this.ZG = threadInfo.is_called.intValue();
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
                this.Xe = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.YX = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Yw = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.Yx = jSONObject.optLong("last_time_int", 0L);
                this.Yy = jSONObject.optInt("is_top", 0);
                this.Yz = jSONObject.optInt("is_good", 0);
                this.YA = jSONObject.optInt("is_livepost", 0);
                this.YB.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.YC = jSONObject.optInt("has_commented", 0);
                this.YD = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.YK = jSONObject.optString("collect_mark_pid");
                this.YL = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.YO = jSONObject.optString("first_post_id", "0");
                this.YZ = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.YP = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.Zt.parserJson(optJSONObject2);
                }
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.YW = new c();
                this.YW.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.YF = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.YG.add(mediaData);
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
                        this.YH.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Zb.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.Zc = new bs();
                    this.Zc.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.Zd = new e();
                    this.Zd.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.Ze = new n();
                    this.Ze.parserJson(optJSONObject6);
                }
                this.YM.setUserMap(this.userMap);
                this.YM.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.YN.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.YM.setTitle(this.title);
                } else {
                    this.YM.setTitle(this.YF);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.Zt.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.Zu.add(aVar2);
                    }
                }
                this.ZA = jSONObject.optInt("is_book_chapter", 0);
                this.ZB.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.ZH = jSONObject.optString("recom_source");
                this.ZM = jSONObject.optString("recom_reason");
                this.ZI = jSONObject.optString("recom_weight");
                this.ZK = jSONObject.optLong("last_read_pid");
                this.ZL = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.YV = new bo();
                    this.YV.d(optJSONObject8);
                }
                this.ZW = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aab = new aj();
                    this.aab.parserJson(optJSONObject9);
                }
                this.aac = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aad = new d();
                    this.aad.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aae = new MediaData();
                    this.aae.parserJson(optJSONObject11);
                }
                this.ZG = jSONObject.optInt("is_called", 0);
                JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject12 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject12.optString("video_md5");
                    builder.video_url = optJSONObject12.optString("video_url");
                    builder.video_duration = new Integer(optJSONObject12.optInt("video_duration", 0));
                    builder.video_width = new Integer(optJSONObject12.optInt(SelectCoverActivityConfig.VIDEO_WIDTH, 0));
                    builder.video_height = new Integer(optJSONObject12.optInt(SelectCoverActivityConfig.VIDEO_HEIGHT, 0));
                    builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    this.YU = builder.build(true);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sb() {
        return this.YE;
    }

    public boolean sc() {
        return rw() != 0;
    }

    public int sd() {
        if (this.Zt != null) {
            long rb = this.Zt.rb();
            long rc = this.Zt.rc();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rb) {
                return 1;
            }
            if (currentTimeMillis > rc) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int se() {
        if (sg() && this.Zb.size() >= 1) {
            a aVar = this.Zb.get(0);
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

    public int sf() {
        if (!sg() || this.Zb.size() < 1 || this.Zb.get(0) == null) {
            return -1;
        }
        return this.Zb.get(0).pj();
    }

    public boolean sg() {
        return this.YR == 1;
    }

    public String sh() {
        return (!sg() || this.Zb.size() < 1 || this.Zb.get(0) == null) ? "" : this.Zb.get(0).getUrl();
    }

    private com.baidu.adp.widget.b cG(String str) {
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
            if (getThreadType() == 42 && si()) {
                arrayList.add(Integer.valueOf(d.g.icon_convene));
            }
            if (rw() == 1) {
                arrayList.add(Integer.valueOf(d.g.icon_top));
            } else if (rw() == 2) {
                arrayList.add(Integer.valueOf(d.g.icon_notice));
            }
            if (ry() == 1 || this.YB.tb() != 0) {
                if (ri() != null && getThreadType() == 41) {
                    if (sd() == 2) {
                        arrayList.add(Integer.valueOf(d.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.g.icon_zhibo));
                }
            }
            if (z && st()) {
                Integer num = Zg.get(Integer.valueOf(sd()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rx() == 1 && !sc() && Yk != getType() && Yo != getType()) {
                arrayList.add(Integer.valueOf(d.g.icon_elite));
            }
            if (getType() == Ys || getType() == Yt) {
                arrayList.add(Integer.valueOf(d.g.icon_vote_blue));
            }
            if (this.YN != null && this.YN.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.g.icon_live_on));
            }
            if (rH() == 1) {
                arrayList.add(Integer.valueOf(d.g.frs_post_ding));
            }
            if (!z && sf() == 2) {
                arrayList.add(Integer.valueOf(d.g.label_frs_activity_shai));
            } else {
                Integer num2 = Zf.get(new Point(sf(), se()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rN() != null) {
                arrayList.add(Integer.valueOf(d.g.tag_act));
            }
            if (rO() != null) {
                arrayList.add(Integer.valueOf(d.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                bVar = cG(this.category_name);
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
                Bitmap cT = com.baidu.tbadk.core.util.aj.cT(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
                if (cT != null) {
                    bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.Yv));
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
            SpannableStringBuilder c = !z && rw() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.YE = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<m.a> arrayList) {
        if (so() || !rC() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new m.a(d.l.god_title));
        }
        return com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean si() {
        return com.baidu.adp.lib.b.d.eW().af("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        if (com.baidu.tbadk.core.util.v.u(a(z, z2, z3, false)) > 0) {
            f(z, z3);
            return;
        }
        String g = g(this.title, false);
        this.YE = a(g, a(new SpannableString(g + " ")), z, z2, z3, false);
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
            if (this.YP == 1) {
                this.YE = a2;
                return a2;
            }
        } else if (this.YP == 1) {
            this.YE = new SpannableStringBuilder();
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

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3) {
        ArrayList<m.a> a = a(z, z2, z3, false);
        if (a == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, a, false);
        if (a.size() > 0 && a2 == null) {
            a2 = new SpannableStringBuilder();
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
        if (this.ZC != null && this.ZC.size() > 0) {
            int size = this.ZC.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ZC.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bj.2
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bj.this.cH(pbContent.link);
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
    public void cH(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, str));
        }
    }

    public void sj() {
        d(false, false);
    }

    public void sk() {
        d(true, false);
    }

    public void sl() {
        d(false, true);
    }

    public AnchorInfoData sm() {
        return this.YN;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sn() {
        return this.threadType == 36;
    }

    public boolean so() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sp() {
        return this.Za;
    }

    public void bV(int i) {
        this.Za = i;
    }

    public long sq() {
        return this.Zl;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rL = rL();
        if (rL == null || sc()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rL.size() || i2 >= 3) {
                break;
            }
            if (rL.get(i2) != null && rL.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rL.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rL.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rL.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.YU != null && !StringUtils.isNull(this.YU.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.YU.thumbnail_url;
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

    public boolean sr() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        int rw = rw();
        if (this.YW != null && this.threadType == 60) {
            return Yn;
        }
        if (this.YW != null && this.threadType == 49) {
            return Yl;
        }
        if (this.threadType == 51) {
            return Ym;
        }
        if (rw == 2 || rw == 1) {
            return Yg;
        }
        if (this.YU != null && sB()) {
            return Yu;
        }
        if (this.YU != null) {
            if (rE()) {
                return Yo;
            }
            return Yk;
        } else if (rp() != null && getThreadType() == 36 && rp().type.intValue() == 2) {
            return Ys;
        } else {
            if (rp() != null && getThreadType() == 36 && rp().type.intValue() == 1) {
                return Yt;
            }
            if (ri() != null && getThreadType() == 41 && ry() == 1 && sd() == 2) {
                return Yp.get() ? Zs : Yh;
            } else if (sg() && sf() == 1) {
                return Yp.get() ? Zx : Yh;
            } else if (sg() && sf() == 2) {
                return Yp.get() ? Zr : Yh;
            } else if (isLinkThread()) {
                return Yi;
            } else {
                if (rE()) {
                    return Yj;
                }
                return Yh;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus ss() {
        return this.Zk;
    }

    public List<TwAnchorProfitItem> qf() {
        return this.WM;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.YP == 1) {
            this.Vb = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Vb = 0;
        } else {
            this.Vb = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.pD() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pD().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Vb = next.pE();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean st() {
        return this.threadType == 41;
    }

    public boolean su() {
        return this.threadType == 48;
    }

    public boolean sv() {
        return this.Zy;
    }

    public void ao(boolean z) {
        this.Zy = z;
    }

    public String sw() {
        return this.Zz;
    }

    public n sx() {
        return this.Ze;
    }

    public boolean sy() {
        return ry() == 1 || rx() == 1 || rw() == 1 || sg() || this.ZA == 1 || rE() || rO() != null || rN() != null || !com.baidu.adp.lib.util.j.isEmpty(getCategory()) || su() || rD();
    }

    public void sz() {
        if (this.YY == 0) {
            this.YY = 1;
        }
    }

    public boolean sA() {
        return this.ZE;
    }

    public void ap(boolean z) {
        this.ZN = z;
    }

    public boolean sB() {
        return this.ZN;
    }

    public void bW(int i) {
        this.ZO = i + 1;
    }

    public int sC() {
        return this.ZO;
    }

    public List<ReportInfo> sD() {
        return this.ZP;
    }

    public boolean sE() {
        return this.ZF;
    }

    public void aq(boolean z) {
        this.ZF = z;
    }

    public bo sF() {
        return this.YV;
    }

    public void a(bo boVar) {
        this.YV = boVar;
    }

    public void bX(int i) {
        if (this.YV != null) {
            this.YV.mCurrentPage = i;
        }
    }

    public boolean sG() {
        return getThreadType() == 49;
    }

    public boolean sH() {
        return getThreadType() == 40;
    }

    public boolean sI() {
        return getThreadType() == 50;
    }

    public boolean sJ() {
        return getThreadType() == 60;
    }

    public boolean sK() {
        return getThreadType() == 40 && sF() != null && sF().channelId > 0;
    }

    public int sL() {
        return this.ZU;
    }

    public void setSmartFrsPosition(int i) {
        this.ZU = i;
    }

    public SparseArray<String> qs() {
        return this.Xf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.Xf = sparseArray;
    }

    public String sM() {
        return this.ZH;
    }

    public boolean sN() {
        return this.ZW;
    }

    public int sO() {
        return this.ZX;
    }

    public int sP() {
        return this.ZY;
    }

    public void bY(int i) {
        this.ZY = i;
    }

    public void bZ(int i) {
        this.ZX = i;
    }

    public long sQ() {
        return this.aaa;
    }

    public PostData sR() {
        return this.ZZ;
    }

    public aj sS() {
        return this.aab;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        if (this.YP == 1) {
            g = g(this.YF, false);
            a = cE(this.YF);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        SpannableStringBuilder a2 = a(g, a, z, true, z2, z3);
        this.YE = a2;
        return a2;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        String g;
        SpannableString cE;
        if (!StringUtils.isNull(this.title)) {
            g = g(this.title, false);
            cE = a(new SpannableString(g + " "));
        } else {
            g = g(this.YF, false);
            cE = cE(this.YF);
        }
        SpannableStringBuilder a = a(g, cE, z, true, z2);
        this.YE = a;
        return a;
    }

    private ArrayList<m.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean rC = rC();
        if (z2) {
            if (z) {
                if (rC && !so()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if (ry() == 1 || getThreadType() == 33 || (rA() != null && rA().tb() != 0)) {
                    if (ri() != null && st()) {
                        if (sd() == 2) {
                            arrayList.add(new m.a(d.l.interview_live));
                        }
                    } else if (!rC) {
                        arrayList.add(new m.a(d.l.photo_live_tips));
                    }
                }
                if (rw() == 1) {
                    arrayList.add(new m.a(d.l.top));
                }
                if (rx() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (st()) {
                    arrayList.add(ZR.get(sd()));
                }
                if (sg()) {
                    Integer num = ZQ.get(new Point(sf(), se()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (su()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (rN() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (rC && rw() != 1 && !so()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if ((ry() == 1 || getThreadType() == 33) && !st() && !rC) {
                    arrayList.add(new m.a(d.l.photo_live_tips));
                }
                if (rx() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (rw() == 1) {
                    arrayList.add(new m.a(d.l.top));
                }
                if (st() && ri() != null && sd() == 2) {
                    arrayList.add(new m.a(d.l.interview_live));
                }
                if (sg()) {
                    Integer num2 = ZQ.get(new Point(sf(), se()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (this.ZA == 1) {
                    arrayList.add(new m.a(d.l.card_tbread_text));
                }
                if (rO() != null) {
                    arrayList.add(new m.a(d.l.send_app_code_gift, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (rN() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (su()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && sG()) {
                    arrayList.add(new m.a(d.l.ala_live));
                }
                if (sK()) {
                    arrayList.add(new m.a(d.l.frs_channel_tip));
                } else if (z3 && sI()) {
                    arrayList.add(new m.a(d.l.live_record));
                } else if (sH()) {
                    arrayList.add(new m.a(d.l.frs_video_title_prefix));
                }
                if (z4) {
                    arrayList.add(new m.a(d.l.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public MediaData sT() {
        return this.aae;
    }
}
