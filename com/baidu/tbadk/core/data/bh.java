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
    public TwZhiBoUser WM;
    public List<TwAnchorProfitItem> WN;
    private SpannableStringBuilder YF;
    public int YJ;
    private int YK;
    private int YM;
    private String YP;
    private int YQ;
    private String YR;
    private int YT;
    private VideoInfo YV;
    private bm YW;
    private c YX;
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
    private ah aab;
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
    public static final BdUniqueId Yh = BdUniqueId.gen();
    public static final BdUniqueId Yi = BdUniqueId.gen();
    public static final BdUniqueId Yj = BdUniqueId.gen();
    public static final BdUniqueId Yk = BdUniqueId.gen();
    public static final BdUniqueId Yl = BdUniqueId.gen();
    public static final BdUniqueId Ym = BdUniqueId.gen();
    public static final BdUniqueId Yn = BdUniqueId.gen();
    public static final BdUniqueId Yo = BdUniqueId.gen();
    public static final BdUniqueId Yp = BdUniqueId.gen();
    public static AtomicBoolean Yq = new AtomicBoolean(false);
    public static AtomicBoolean Yr = new AtomicBoolean(false);
    public static AtomicBoolean Ys = new AtomicBoolean(false);
    public static final BdUniqueId Yt = BdUniqueId.gen();
    public static final BdUniqueId Yu = BdUniqueId.gen();
    public static final BdUniqueId Yv = BdUniqueId.gen();
    private static HashMap<Point, Integer> Zf = new HashMap<>();
    private static HashMap<Integer, Integer> Zg = new HashMap<>();
    public static final BdUniqueId Zr = BdUniqueId.gen();
    public static final BdUniqueId Zs = BdUniqueId.gen();
    public static final BdUniqueId Zx = BdUniqueId.gen();
    private static HashMap<Point, Integer> ZQ = new HashMap<>();
    private static SparseArray<m.a> ZR = new SparseArray<>(3);
    public int Yw = 1;
    private String YL = null;
    private int Vp = 0;
    public int YY = 0;
    private String YZ = "";
    private String Zh = "";
    public boolean ZL = true;
    public boolean ZS = false;
    public boolean ZT = false;
    private int ZU = -1;
    private SparseArray<String> Xg = null;
    public boolean aac = false;
    private String id = null;
    private String Xf = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int Yx = 0;
    private int view_num = 0;
    private String last_time = null;
    private long Yy = 0;
    private int Yz = 0;
    private int YA = 0;
    private int YB = 0;
    private bk YC = new bk();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> YH = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> YI = new ArrayList<>();
    private int YD = 0;
    private int YE = 0;
    private String ad_url = null;
    private String YG = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData YN = new PraiseData();
    private AnchorInfoData YO = new AnchorInfoData();
    private long time = 0;
    private int YS = 0;
    private ArrayList<a> Zb = new ArrayList<>();
    private bq Zc = null;
    private e Zd = null;
    private int Zi = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> YU = new ArrayList<>();
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
    private bf Zt = new bf();
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

    public bh() {
        this.YK = 0;
        this.YT = 0;
        this.Zl = 0L;
        this.post_num = 0;
        this.post_num = 0;
        this.Zl = 0L;
        this.YT = 0;
        this.YK = 0;
    }

    public boolean rb() {
        return this.YK == 1;
    }

    public bf rc() {
        return this.Zt;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bP(int i) {
        this.anchorLevel = i;
    }

    public int rd() {
        return this.YT;
    }

    public boolean re() {
        return this.Zq;
    }

    public int rf() {
        return this.ZG;
    }

    public void bQ(int i) {
        this.ZG = i;
    }

    public boolean rg() {
        return this.Zn;
    }

    public boolean rh() {
        return this.Zo;
    }

    public void bR(int i) {
        this.Zp = i;
    }

    public int ri() {
        return this.Zp;
    }

    public PollInfo rj() {
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

    public String rk() {
        return this.YP;
    }

    public PraiseData rl() {
        return this.YN;
    }

    public void a(PraiseData praiseData) {
        this.YN = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rm() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cy(String str) {
        this.Xf = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.Xf) || "0".equals(this.Xf)) ? this.id : this.Xf;
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

    public void bS(int i) {
        this.reply_num = i;
    }

    public int rn() {
        return this.reply_num;
    }

    public int ro() {
        return this.view_num;
    }

    public void bT(int i) {
        this.view_num = i;
    }

    public long rp() {
        return this.Yy;
    }

    public void l(long j) {
        this.Yy = j;
    }

    public int rq() {
        return this.Yz;
    }

    public void bU(int i) {
        this.Yz = i;
    }

    public int rr() {
        return this.YA;
    }

    public void bV(int i) {
        this.YA = i;
    }

    public int rs() {
        return this.YB;
    }

    public List<PbContent> rt() {
        return this.ZC;
    }

    public bk ru() {
        return this.YC;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rv() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rw() {
        return this.is_god != 0;
    }

    public boolean rx() {
        return this.is_god == 1;
    }

    public boolean ry() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rz() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rA() {
        return this.forum_name;
    }

    public void cC(String str) {
        this.forum_name = str;
    }

    public int rB() {
        return this.YE;
    }

    public String rC() {
        return this.ad_url;
    }

    public String rD() {
        return this.YG;
    }

    public void cD(String str) {
        this.YG = str;
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
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bh.1
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bh.this.cH(pbContent.link);
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

    public String rE() {
        return this.YL;
    }

    public void cF(String str) {
        this.YL = str;
    }

    public ArrayList<MediaData> rF() {
        return this.YH;
    }

    public ArrayList<a> rG() {
        return this.Zb;
    }

    public void h(ArrayList<a> arrayList) {
        this.Zb = arrayList;
    }

    public bq rH() {
        return this.Zc;
    }

    public e rI() {
        return this.Zd;
    }

    public ArrayList<VoiceData.VoiceModel> rJ() {
        return this.YI;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rK() {
        return this.YQ;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rL() {
        return this.YZ;
    }

    public VideoInfo rM() {
        return this.YV;
    }

    public void a(c cVar) {
        this.YX = cVar;
    }

    public c rN() {
        return this.YX;
    }

    public String getPhotoLiveCover() {
        return this.Zh;
    }

    public void setPhotoLiveCover(String str) {
        this.Zh = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rO() {
        return this.YU;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.YU.clear();
        this.YU.addAll(arrayList);
    }

    public String getNotice() {
        return this.Zj;
    }

    public PushStatusData rP() {
        return this.Zv;
    }

    public SkinInfo rQ() {
        return this.Zw;
    }

    public long rR() {
        return this.ZK;
    }

    public boolean rS() {
        return this.ZL;
    }

    public String rT() {
        return this.ZM;
    }

    public p rU() {
        return this.ZV;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.YR = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.YK = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.Xf = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Yx = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.Yy = threadInfo.last_time_int.intValue();
                this.Yz = threadInfo.is_top.intValue();
                this.YA = threadInfo.is_good.intValue();
                this.YB = threadInfo.is_livepost.intValue();
                this.YC.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.YD = threadInfo.has_commented.intValue();
                this.YE = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.YV = threadInfo.video_info;
                this.YX = new c();
                this.YX.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.YL = threadInfo.collect_mark_pid;
                this.YM = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.YP = threadInfo.first_post_id + "";
                this.YZ = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.YQ = threadInfo.is_ntitle.intValue();
                this.YS = threadInfo.is_activity.intValue();
                this.ZX = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.ZY = threadInfo.agree.has_agree.intValue();
                }
                this.aaa = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.YT = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ZE = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ZC = threadInfo.rich_title;
                this.ZD = threadInfo.rich_abstract;
                this.YJ = threadInfo.is_godthread_recommend.intValue();
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
                this.YG = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.YH.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.YV = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.YW = new bm();
                    this.YW.a(threadInfo.video_channel_info);
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
                        this.YI.add(voiceModel);
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
                    this.Zc = new bq();
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
                this.YN.setUserMap(this.userMap);
                this.YN.parserProtobuf(threadInfo.zan);
                this.YO.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.YN.setTitle(this.title);
                } else {
                    this.YN.setTitle(this.YG);
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
                                eVar.ev(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.YU.add(eVar);
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
                        this.WM = zhiBoInfoTW.user.tw_anchor_info;
                        this.WN = zhiBoInfoTW.user.profit_list;
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
                if (com.baidu.tbadk.core.util.v.t(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.Xg = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.v.u(threadInfo.declare_list)) {
                    this.ZV = new p();
                    this.ZV.a(threadInfo);
                }
                this.ZW = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aab = new ah();
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
                this.Xf = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.is_god = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Yx = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.Yy = jSONObject.optLong("last_time_int", 0L);
                this.Yz = jSONObject.optInt("is_top", 0);
                this.YA = jSONObject.optInt("is_good", 0);
                this.YB = jSONObject.optInt("is_livepost", 0);
                this.YC.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.YD = jSONObject.optInt("has_commented", 0);
                this.YE = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.YL = jSONObject.optString("collect_mark_pid");
                this.YM = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.YP = jSONObject.optString("first_post_id", "0");
                this.YZ = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.YQ = jSONObject.optInt("is_ntitle");
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
                this.YX = new c();
                this.YX.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.YG = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.YH.add(mediaData);
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
                        this.YI.add(voiceModel);
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
                    this.Zc = new bq();
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
                this.YN.setUserMap(this.userMap);
                this.YN.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.YO.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.YN.setTitle(this.title);
                } else {
                    this.YN.setTitle(this.YG);
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
                    this.YW = new bm();
                    this.YW.d(optJSONObject8);
                }
                this.ZW = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aab = new ah();
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
                    builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    this.YV = builder.build(true);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rV() {
        return this.YF;
    }

    public boolean rW() {
        return rq() != 0;
    }

    public int rX() {
        if (this.Zt != null) {
            long qV = this.Zt.qV();
            long qW = this.Zt.qW();
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
        if (sa() && this.Zb.size() >= 1) {
            a aVar = this.Zb.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pl = aVar.pl();
            int pm = aVar.pm();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pl) {
                return 4;
            }
            return currentTimeMillis > pm ? 2 : 1;
        }
        return -1;
    }

    public int rZ() {
        if (!sa() || this.Zb.size() < 1 || this.Zb.get(0) == null) {
            return -1;
        }
        return this.Zb.get(0).pk();
    }

    public boolean sa() {
        return this.YS == 1;
    }

    public String sb() {
        return (!sa() || this.Zb.size() < 1 || this.Zb.get(0) == null) ? "" : this.Zb.get(0).getUrl();
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
            if (getThreadType() == 42 && sc()) {
                arrayList.add(Integer.valueOf(d.g.icon_convene));
            }
            if (rq() == 1) {
                arrayList.add(Integer.valueOf(d.g.icon_top));
            } else if (rq() == 2) {
                arrayList.add(Integer.valueOf(d.g.icon_notice));
            }
            if (rs() == 1 || this.YC.sV() != 0) {
                if (rc() != null && getThreadType() == 41) {
                    if (rX() == 2) {
                        arrayList.add(Integer.valueOf(d.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.g.icon_zhibo));
                }
            }
            if (z && sn()) {
                Integer num = Zg.get(Integer.valueOf(rX()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rr() == 1 && !rW() && Yl != getType() && Yp != getType()) {
                arrayList.add(Integer.valueOf(d.g.icon_elite));
            }
            if (getType() == Yt || getType() == Yu) {
                arrayList.add(Integer.valueOf(d.g.icon_vote_blue));
            }
            if (this.YO != null && this.YO.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.g.icon_live_on));
            }
            if (rB() == 1) {
                arrayList.add(Integer.valueOf(d.g.frs_post_ding));
            }
            if (!z && rZ() == 2) {
                arrayList.add(Integer.valueOf(d.g.label_frs_activity_shai));
            } else {
                Integer num2 = Zf.get(new Point(rZ(), rY()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rH() != null) {
                arrayList.add(Integer.valueOf(d.g.tag_act));
            }
            if (rI() != null) {
                arrayList.add(Integer.valueOf(d.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
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
                Bitmap cR = com.baidu.tbadk.core.util.aj.cR(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.Yw));
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
            SpannableStringBuilder c = !z && rq() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.YF = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<m.a> arrayList) {
        if (si() || !rw() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new m.a(d.l.god_title));
        }
        return com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean sc() {
        return com.baidu.adp.lib.b.d.eV().af("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.t(a(z, z2, z3, false)) > 0) {
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
        this.YF = spannableStringBuilder;
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
            if (this.YQ == 1) {
                this.YF = a2;
                return a2;
            }
        } else if (this.YQ == 1) {
            this.YF = new SpannableStringBuilder();
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
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bh.2
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bh.this.cH(pbContent.link);
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
        return this.YO;
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
        return this.Za;
    }

    public void bW(int i) {
        this.Za = i;
    }

    public long sk() {
        return this.Zl;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rF = rF();
        if (rF == null || rW()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rF.size() || i2 >= 3) {
                break;
            }
            if (rF.get(i2) != null && rF.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rF.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rF.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rF.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.YV != null && !StringUtils.isNull(this.YV.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.YV.thumbnail_url;
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

    public boolean sl() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        int rq = rq();
        if (this.YX != null && this.threadType == 60) {
            return Yo;
        }
        if (this.YX != null && this.threadType == 49) {
            return Ym;
        }
        if (this.threadType == 51) {
            return Yn;
        }
        if (rq == 2 || rq == 1) {
            return Yh;
        }
        if (this.YV != null && sv()) {
            return Yv;
        }
        if (this.YV != null) {
            if (ry()) {
                return Yp;
            }
            return Yl;
        } else if (rj() != null && getThreadType() == 36 && rj().type.intValue() == 2) {
            return Yt;
        } else {
            if (rj() != null && getThreadType() == 36 && rj().type.intValue() == 1) {
                return Yu;
            }
            if (rc() != null && getThreadType() == 41 && rs() == 1 && rX() == 2) {
                return Yq.get() ? Zs : Yi;
            } else if (sa() && rZ() == 1) {
                return Yq.get() ? Zx : Yi;
            } else if (sa() && rZ() == 2) {
                return Yq.get() ? Zr : Yi;
            } else if (isLinkThread()) {
                return Yj;
            } else {
                if (ry()) {
                    return Yk;
                }
                return Yi;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sm() {
        return this.Zk;
    }

    public List<TwAnchorProfitItem> pZ() {
        return this.WN;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.YQ == 1) {
            this.Vp = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Vp = 0;
        } else {
            this.Vp = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.pE() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pE().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Vp = next.pF();
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
        return this.Zy;
    }

    public void ao(boolean z) {
        this.Zy = z;
    }

    public String sq() {
        return this.Zz;
    }

    public n sr() {
        return this.Ze;
    }

    public boolean ss() {
        return rs() == 1 || rr() == 1 || rq() == 1 || sa() || this.ZA == 1 || ry() || rI() != null || rH() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || so() || rx();
    }

    public void st() {
        if (this.YY == 0) {
            this.YY = 1;
        }
    }

    public boolean su() {
        return this.ZE;
    }

    public void ap(boolean z) {
        this.ZN = z;
    }

    public boolean sv() {
        return this.ZN;
    }

    public void bX(int i) {
        this.ZO = i + 1;
    }

    public int sw() {
        return this.ZO;
    }

    public List<ReportInfo> sx() {
        return this.ZP;
    }

    public boolean sy() {
        return this.ZF;
    }

    public void aq(boolean z) {
        this.ZF = z;
    }

    public bm sz() {
        return this.YW;
    }

    public void a(bm bmVar) {
        this.YW = bmVar;
    }

    public void bY(int i) {
        if (this.YW != null) {
            this.YW.mCurrentPage = i;
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
        return this.ZU;
    }

    public void setSmartFrsPosition(int i) {
        this.ZU = i;
    }

    public SparseArray<String> qm() {
        return this.Xg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.Xg = sparseArray;
    }

    public String sG() {
        return this.ZH;
    }

    public boolean sH() {
        return this.ZW;
    }

    public int sI() {
        return this.ZX;
    }

    public int sJ() {
        return this.ZY;
    }

    public void bZ(int i) {
        this.ZY = i;
    }

    public void ca(int i) {
        this.ZX = i;
    }

    public long sK() {
        return this.aaa;
    }

    public void m(long j) {
        this.aaa = j;
    }

    public PostData sL() {
        return this.ZZ;
    }

    public ah sM() {
        return this.aab;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.YQ == 1) {
            g = g(this.YG, false);
            a = cE(this.YG);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.YF = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        SpannableString cE;
        if (!StringUtils.isNull(this.title)) {
            cE = a(new SpannableString(g(this.title, false) + " "));
        } else {
            g(this.YG, false);
            cE = cE(this.YG);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cE);
        this.YF = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<m.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean rw = rw();
        if (z2) {
            if (z) {
                if (rw && !si()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if (rs() == 1 || getThreadType() == 33 || (ru() != null && ru().sV() != 0)) {
                    if (rc() != null && sn()) {
                        if (rX() == 2) {
                            arrayList.add(new m.a(d.l.interview_live));
                        }
                    } else if (!rw) {
                        arrayList.add(new m.a(d.l.photo_live_tips));
                    }
                }
                if (rq() == 1) {
                    arrayList.add(new m.a(d.l.top));
                }
                if (rr() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (sn()) {
                    arrayList.add(ZR.get(rX()));
                }
                if (sa()) {
                    Integer num = ZQ.get(new Point(rZ(), rY()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (so()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (rH() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (rw && rq() != 1 && !si()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if ((rs() == 1 || getThreadType() == 33) && !sn() && !rw) {
                    arrayList.add(new m.a(d.l.photo_live_tips));
                }
                if (rr() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (rq() == 1) {
                    arrayList.add(new m.a(d.l.top));
                }
                if (sn() && rc() != null && rX() == 2) {
                    arrayList.add(new m.a(d.l.interview_live));
                }
                if (sa()) {
                    Integer num2 = ZQ.get(new Point(rZ(), rY()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (this.ZA == 1) {
                    arrayList.add(new m.a(d.l.card_tbread_text));
                }
                if (rI() != null) {
                    arrayList.add(new m.a(d.l.send_app_code_gift, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (rH() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (so()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && sA()) {
                    arrayList.add(new m.a(d.l.ala_live));
                }
                if (sE()) {
                    arrayList.add(new m.a(d.l.frs_channel_tip));
                } else if (z3 && sC()) {
                    arrayList.add(new m.a(d.l.live_record));
                } else if (sB()) {
                    arrayList.add(new m.a(d.l.frs_video_title_prefix));
                }
                if (z4) {
                    arrayList.add(new m.a(d.l.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public MediaData sN() {
        return this.aae;
    }
}
