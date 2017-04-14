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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tieba.card.at;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.w;
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
public class bi extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.ah {
    public TwZhiBoUser WH;
    public List<TwAnchorProfitItem> WI;
    private int YA;
    private int YC;
    private String YF;
    private int YG;
    private String YH;
    private int YJ;
    private VideoInfo YL;
    private bp YM;
    private c YN;
    private long YO;
    private n YV;
    private SpannableStringBuilder Yv;
    public int Yz;
    public long ZA;
    public String ZC;
    private List<ReportInfo> ZF;
    private p ZL;
    private LiveCoverStatus Zb;
    private int Zc;
    private SkinInfo Zn;
    private boolean Zp;
    private String Zq;
    private boolean Zv;
    private boolean Zw;
    public String Zx;
    public String Zy;
    public String Zz;
    private String address;
    private String authorId;
    private String latitude;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId XZ = BdUniqueId.gen();
    public static final BdUniqueId Ya = BdUniqueId.gen();
    public static final BdUniqueId Yb = BdUniqueId.gen();
    public static final BdUniqueId Yc = BdUniqueId.gen();
    public static final BdUniqueId Yd = BdUniqueId.gen();
    public static final BdUniqueId Ye = BdUniqueId.gen();
    public static final BdUniqueId Yf = BdUniqueId.gen();
    public static AtomicBoolean Yg = new AtomicBoolean(false);
    public static AtomicBoolean Yh = new AtomicBoolean(false);
    public static AtomicBoolean Yi = new AtomicBoolean(false);
    public static final BdUniqueId Yj = BdUniqueId.gen();
    public static final BdUniqueId Yk = BdUniqueId.gen();
    public static final BdUniqueId Yl = BdUniqueId.gen();
    private static HashMap<Point, Integer> YW = new HashMap<>();
    private static HashMap<Integer, Integer> YX = new HashMap<>();
    public static final BdUniqueId Zi = BdUniqueId.gen();
    public static final BdUniqueId Zj = BdUniqueId.gen();
    public static final BdUniqueId Zo = BdUniqueId.gen();
    private static HashMap<Point, Integer> ZG = new HashMap<>();
    private static SparseArray<at.a> ZH = new SparseArray<>(3);
    public int Ym = 1;
    private String YB = null;
    private int Vb = 0;
    public int YP = 0;
    private String YQ = "";
    private String YY = "";
    public boolean ZB = true;
    public boolean ZI = false;
    public boolean ZJ = false;
    private int ZK = -1;
    private SparseArray<String> WT = null;
    private String id = null;
    private String WS = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int Yn = 0;
    private int view_num = 0;
    private String last_time = null;
    private long Yo = 0;
    private int Yp = 0;
    private int Yq = 0;
    private int Yr = 0;
    private bn Ys = new bn();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Yx = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Yy = new ArrayList<>();
    private int Yt = 0;
    private int Yu = 0;
    private String ad_url = null;
    private String Yw = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData YD = new PraiseData();
    private AnchorInfoData YE = new AnchorInfoData();
    private long time = 0;
    private int YI = 0;
    private ArrayList<a> YS = new ArrayList<>();
    private bs YT = null;
    private d YU = null;
    private int YZ = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> YK = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Za = null;
    private int YR = 0;
    private PollInfo Zd = null;
    private boolean Ze = false;
    private boolean Zf = false;
    private int Zg = 0;
    private boolean Zh = false;
    private int anchorLevel = 0;
    public int Zr = 0;
    public k Zs = new k();
    private List<PbContent> Zt = new ArrayList();
    private List<PbContent> Zu = new ArrayList();
    private String category_name = null;
    private bg Zk = new bg();
    private ArrayList<com.baidu.tbadk.data.b> Zl = new ArrayList<>();
    private PushStatusData Zm = new PushStatusData();
    public boolean ZD = false;
    public int ZE = -1;

    static {
        YW.put(new Point(1, 1), Integer.valueOf(w.g.label_frs_lottery_ing));
        YW.put(new Point(1, 2), Integer.valueOf(w.g.label_frs_lottery_over));
        YW.put(new Point(1, 3), Integer.valueOf(w.g.label_frs_lottery_off));
        YW.put(new Point(1, 4), Integer.valueOf(w.g.label_frs_lottery_d));
        YW.put(new Point(2, 1), Integer.valueOf(w.g.label_frs_activity_shaiing));
        YW.put(new Point(2, 2), Integer.valueOf(w.g.label_frs_activity_shai_over));
        YW.put(new Point(2, 3), Integer.valueOf(w.g.label_frs_activity_shai_off));
        YW.put(new Point(2, 4), Integer.valueOf(w.g.label_frs_activity_shai_d));
        ZG.put(new Point(1, 1), Integer.valueOf(w.l.lottery_status_ing));
        ZG.put(new Point(1, 2), Integer.valueOf(w.l.lottery_status_over));
        ZG.put(new Point(1, 3), Integer.valueOf(w.l.lottery_status_off));
        ZG.put(new Point(1, 4), Integer.valueOf(w.l.lottery_status_not_start));
        ZG.put(new Point(2, 1), Integer.valueOf(w.l.share_picture_status_ing));
        ZG.put(new Point(2, 2), Integer.valueOf(w.l.share_picture_status_over));
        ZG.put(new Point(2, 3), Integer.valueOf(w.l.share_picture_status_off));
        ZG.put(new Point(2, 4), Integer.valueOf(w.l.share_picture_status_not_start));
        YX.put(1, Integer.valueOf(w.g.label_interview_no));
        YX.put(2, Integer.valueOf(w.g.label_interview_live));
        YX.put(3, Integer.valueOf(w.g.label_interview_off));
        ZH.put(1, new at.a(w.l.interview_live_status_not_start, w.e.cp_other_b, w.g.pic_dot_title_red));
        ZH.put(2, new at.a(w.l.interview_live_status_ing, w.e.cp_other_c, w.g.pic_dot_title_green));
        ZH.put(3, new at.a(w.l.interview_live_status_over, w.e.cp_other_d, w.g.pic_dot_title_blue));
    }

    public bi() {
        this.YA = 0;
        this.YJ = 0;
        this.Zc = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Zc = 0;
        this.YJ = 0;
        this.YA = 0;
    }

    public boolean rW() {
        return this.YA == 1;
    }

    public bg rX() {
        return this.Zk;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bQ(int i) {
        this.anchorLevel = i;
    }

    public int rY() {
        return this.YJ;
    }

    public boolean rZ() {
        return this.Zh;
    }

    public boolean sa() {
        return this.Ze;
    }

    public boolean sb() {
        return this.Zf;
    }

    public void bR(int i) {
        this.Zg = i;
    }

    public int sc() {
        return this.Zg;
    }

    public PollInfo sd() {
        return this.Zd;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.YO;
    }

    public PraiseData se() {
        return this.YD;
    }

    public void a(PraiseData praiseData) {
        this.YD = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String sf() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cp(String str) {
        this.WS = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.WS) || "0".equals(this.WS)) ? this.id : this.WS;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String sg() {
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

    public int sh() {
        return this.reply_num;
    }

    public int si() {
        return this.view_num;
    }

    public long sj() {
        return this.Yo;
    }

    public void m(long j) {
        this.Yo = j;
    }

    public int sk() {
        return this.Yp;
    }

    public void bT(int i) {
        this.Yp = i;
    }

    public int sl() {
        return this.Yq;
    }

    public void bU(int i) {
        this.Yq = i;
    }

    public int sm() {
        return this.Yr;
    }

    public List<PbContent> sn() {
        return this.Zt;
    }

    public bn so() {
        return this.Ys;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData sp() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean sq() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return false;
        }
        return this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3 || this.author.getGodUserData().getType() == 1;
    }

    public boolean sr() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean ss() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String st() {
        return this.forum_name;
    }

    public void cv(String str) {
        this.forum_name = str;
    }

    public int su() {
        return this.Yu;
    }

    public String sv() {
        return this.ad_url;
    }

    public String sw() {
        return this.Yw;
    }

    public void cw(String str) {
        this.Yw = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.Zu == null || this.Zu.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.Zu.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.Zu.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.Zt == null || (size = this.Zt.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.Zt.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cx(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.Zu != null && (size = this.Zu.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.Zu.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (!TextUtils.isEmpty(pbContent.text)) {
                    if (pbContent.text.length() + i3 > spannableString.length()) {
                        break;
                    }
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bj(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
                    }
                    i = pbContent.text.length() + i3;
                } else {
                    i = i3;
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

    public String sx() {
        return this.YB;
    }

    public void cy(String str) {
        this.YB = str;
    }

    public ArrayList<MediaData> sy() {
        return this.Yx;
    }

    public ArrayList<a> sz() {
        return this.YS;
    }

    public void h(ArrayList<a> arrayList) {
        this.YS = arrayList;
    }

    public bs sA() {
        return this.YT;
    }

    public d sB() {
        return this.YU;
    }

    public ArrayList<VoiceData.VoiceModel> sC() {
        return this.Yy;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int sD() {
        return this.YG;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String sE() {
        return this.YQ;
    }

    public VideoInfo sF() {
        return this.YL;
    }

    public c sG() {
        return this.YN;
    }

    public String getPhotoLiveCover() {
        return this.YY;
    }

    public void setPhotoLiveCover(String str) {
        this.YY = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> sH() {
        return this.YK;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.YK.clear();
        this.YK.addAll(arrayList);
    }

    public String getNotice() {
        return this.Za;
    }

    public PushStatusData sI() {
        return this.Zm;
    }

    public SkinInfo sJ() {
        return this.Zn;
    }

    public long sK() {
        return this.ZA;
    }

    public boolean sL() {
        return this.ZB;
    }

    public String sM() {
        return this.ZC;
    }

    public p sN() {
        return this.ZL;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x002a: IGET  (r3v0 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x003b: IGET  (r3v1 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00ff: IGET  (r3v9 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0110: IGET  (r3v10 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.YH = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.YA = threadInfo.is_tbread_dispatch.intValue();
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.WS = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.YO = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Yn = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.Yo = threadInfo.last_time_int.intValue();
                this.Yp = threadInfo.is_top.intValue();
                this.Yq = threadInfo.is_good.intValue();
                this.Yr = threadInfo.is_livepost.intValue();
                this.Ys.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Yt = threadInfo.has_commented.intValue();
                this.Yu = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.YL = threadInfo.video_info;
                this.YN = new c();
                this.YN.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.YB = threadInfo.collect_mark_pid;
                this.YC = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.YF = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.YQ = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.YG = threadInfo.is_ntitle.intValue();
                this.YI = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.YJ = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.Zv = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.Zt = threadInfo.rich_title;
                this.Zu = threadInfo.rich_abstract;
                this.Yz = threadInfo.is_godthread_recommend.intValue();
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
                this.Yw = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Yx.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.YL = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.YM = new bp();
                    this.YM.a(threadInfo.video_channel_info);
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
                        this.Yy.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.YS.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.YT = new bs();
                    this.YT.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.YU = new d();
                    this.YU.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.YV = new n();
                    this.YV.a(threadInfo.cartoon_info);
                }
                this.YD.setUserMap(this.userMap);
                this.YD.parserProtobuf(threadInfo.zan);
                this.YE.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.YD.setTitle(this.title);
                } else {
                    this.YD.setTitle(this.Yw);
                }
                this.YY = threadInfo.livecover_src;
                this.YZ = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.YR = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.eh(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.YK.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Za = noticeInfo.notice;
                    }
                    this.Zg = zhiBoInfoTW.copythread_remind.intValue();
                    this.Ze = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Zf = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.YY)) {
                        this.YY = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.WH = zhiBoInfoTW.user.tw_anchor_info;
                        this.WI = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Zb = threadInfo.twzhibo_info.livecover_status;
                    this.Zc = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Zd = threadInfo.poll_info;
                this.Zh = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Zk.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.Zl.add(bVar);
                    }
                }
                this.Zm.parserProtobuf(threadInfo.push_status);
                this.Zq = threadInfo.lego_card;
                this.Zn = threadInfo.skin_info;
                this.Zr = threadInfo.is_book_chapter.intValue();
                this.Zs.a(threadInfo.book_chapter);
                this.Zx = threadInfo.recom_source;
                this.ZC = threadInfo.recom_reason;
                this.Zy = threadInfo.recom_weight;
                this.Zz = threadInfo.ab_tag;
                this.ZA = threadInfo.last_read_pid.longValue();
                this.ZB = threadInfo.cheak_repeat.intValue() == 1;
                this.ZF = threadInfo.report_info;
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.x.p(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.WT = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.x.q(threadInfo.declare_list)) {
                    this.ZL = new p();
                    this.ZL.a(threadInfo);
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
                this.WS = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.YO = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Yn = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.Yo = jSONObject.optLong("last_time_int", 0L);
                this.Yp = jSONObject.optInt("is_top", 0);
                this.Yq = jSONObject.optInt("is_good", 0);
                this.Yr = jSONObject.optInt("is_livepost", 0);
                this.Ys.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Yt = jSONObject.optInt("has_commented", 0);
                this.Yu = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.YB = jSONObject.optString("collect_mark_pid");
                this.YC = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.YF = jSONObject.optString("first_post_id", "0");
                this.YQ = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.YG = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("author");
                if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.YN = new c();
                this.YN.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.Yw = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Yx.add(mediaData);
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
                        this.Yy.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.YS.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.YT = new bs();
                    this.YT.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.YU = new d();
                    this.YU.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.YV = new n();
                    this.YV.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.YD.setUserMap(this.userMap);
                this.YD.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.YE.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.YD.setTitle(this.title);
                } else {
                    this.YD.setTitle(this.Yw);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("task_info");
                if (optJSONObject3 != null) {
                    this.Zk.parserJson(optJSONObject3);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.Zl.add(bVar);
                    }
                }
                this.Zr = jSONObject.optInt("is_book_chapter", 0);
                this.Zs.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.Zx = jSONObject.optString("recom_source");
                this.ZC = jSONObject.optString("recom_reason");
                this.Zy = jSONObject.optString("recom_weight");
                this.ZA = jSONObject.optLong("last_read_pid");
                this.ZB = jSONObject.optInt("cheak_repeat") == 1;
                if (jSONObject.optJSONObject("video_channel_info") != null) {
                    this.YM = new bp();
                    this.YM.i(jSONObject.optJSONObject("video_channel_info"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sO() {
        return this.Yv;
    }

    public boolean sP() {
        return sk() != 0;
    }

    public int sQ() {
        if (this.Zk != null) {
            long rQ = this.Zk.rQ();
            long rR = this.Zk.rR();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rQ) {
                return 1;
            }
            if (currentTimeMillis > rR) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sR() {
        if (sT() && this.YS.size() >= 1) {
            a aVar = this.YS.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pG = aVar.pG();
            int pH = aVar.pH();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pG) {
                return 4;
            }
            return currentTimeMillis > pH ? 2 : 1;
        }
        return -1;
    }

    public int sS() {
        if (!sT() || this.YS.size() < 1 || this.YS.get(0) == null) {
            return -1;
        }
        return this.YS.get(0).pF();
    }

    public boolean sT() {
        return this.YI == 1;
    }

    public String sU() {
        return (!sT() || this.YS.size() < 1 || this.YS.get(0) == null) ? "" : this.YS.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cz(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m9getInst().getApplicationContext()).inflate(w.j.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(w.h.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m9getInst().getApplicationContext().getResources().getColor(w.e.cp_cont_f_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                dVar = new com.baidu.adp.widget.d(bitmapDrawable, 1);
            } else {
                dVar = null;
            }
            return dVar;
        }
        return null;
    }

    private void d(boolean z, boolean z2) {
        SpannableString spannableString;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.d dVar = null;
        if (!z2) {
            if (getThreadType() == 42 && sV()) {
                arrayList.add(Integer.valueOf(w.g.icon_convene));
            }
            if (sk() == 1) {
                arrayList.add(Integer.valueOf(w.g.icon_top));
            } else if (sk() == 2) {
                arrayList.add(Integer.valueOf(w.g.icon_notice));
            }
            if (sm() == 1 || this.Ys.tD() != 0) {
                if (rX() != null && getThreadType() == 41) {
                    if (sQ() == 2) {
                        arrayList.add(Integer.valueOf(w.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(w.g.icon_zhibo));
                }
            }
            if (z && tg()) {
                Integer num = YX.get(Integer.valueOf(sQ()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (sl() == 1 && !sP() && Yc != getType() && Yf != getType()) {
                arrayList.add(Integer.valueOf(w.g.icon_elite));
            }
            if (getType() == Yj || getType() == Yk) {
                arrayList.add(Integer.valueOf(w.g.icon_vote_blue));
            }
            if (this.YE != null && this.YE.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(w.g.icon_live_on));
            }
            if (su() == 1) {
                arrayList.add(Integer.valueOf(w.g.frs_post_ding));
            }
            if (!z && sS() == 2) {
                arrayList.add(Integer.valueOf(w.g.label_frs_activity_shai));
            } else {
                Integer num2 = YW.get(new Point(sS(), sR()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (sA() != null) {
                arrayList.add(Integer.valueOf(w.g.tag_act));
            }
            if (sB() != null) {
                arrayList.add(Integer.valueOf(w.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cz(this.category_name);
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append("1 ");
            }
            String sb2 = sb.toString();
            if (dVar != null) {
                spannableString = new SpannableString(String.valueOf(sb2) + this.category_name + " ");
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
                Bitmap cO = com.baidu.tbadk.core.util.aq.cO(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                }
                com.baidu.tbadk.core.view.al alVar = new com.baidu.tbadk.core.view.al(bitmapDrawable);
                alVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.Ym));
                spannableString.setSpan(alVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (dVar != null) {
                spannableString.setSpan(dVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(String.valueOf(g) + " "), z);
        if (a != null) {
            SpannableStringBuilder c = !z && sk() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.Yv = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<at.a> arrayList) {
        if (tb() || !sq() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new at.a(w.l.god_title));
        }
        return com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), str, arrayList, true);
    }

    private boolean sV() {
        return com.baidu.adp.lib.b.e.eY().Y("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        boolean sq = sq();
        if (z2) {
            if (z) {
                if (sq && !tb()) {
                    arrayList.add(new at.a(w.l.god_title));
                }
                if (sm() == 1 || getThreadType() == 33 || (so() != null && so().tD() != 0)) {
                    if (rX() != null && tg()) {
                        if (sQ() == 2) {
                            arrayList.add(new at.a(w.l.interview_live));
                        }
                    } else if (!sq) {
                        arrayList.add(new at.a(w.l.photo_live_tips));
                    }
                }
                if (sk() == 1) {
                    arrayList.add(new at.a(w.l.commit_top));
                }
                if (sl() == 1) {
                    arrayList.add(new at.a(w.l.good));
                }
                if (tg()) {
                    arrayList.add(ZH.get(sQ()));
                }
                if (sT()) {
                    Integer num = ZG.get(new Point(sS(), sR()));
                    if (num != null) {
                        arrayList.add(new at.a(num.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(w.l.card_promotion_text));
                    }
                }
                if (th()) {
                    arrayList.add(new at.a(w.l.evaluation));
                }
                if (sA() != null) {
                    arrayList.add(new at.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(sg())) {
                    arrayList.add(new at.a(sg()));
                }
            } else {
                if (sq && sk() != 1 && !tb()) {
                    arrayList.add(new at.a(w.l.god_title));
                }
                if ((sm() == 1 || getThreadType() == 33) && !tg() && !sq) {
                    arrayList.add(new at.a(w.l.photo_live_tips));
                }
                if (sl() == 1) {
                    arrayList.add(new at.a(w.l.good));
                }
                if (sk() == 1) {
                    arrayList.add(new at.a(w.l.commit_top));
                }
                if (tg() && rX() != null && sQ() == 2) {
                    arrayList.add(new at.a(w.l.interview_live));
                }
                if (sT()) {
                    Integer num2 = ZG.get(new Point(sS(), sR()));
                    if (num2 != null) {
                        arrayList.add(new at.a(num2.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(w.l.card_promotion_text));
                    }
                }
                if (this.Zr == 1) {
                    arrayList.add(new at.a(w.l.card_tbread_text));
                }
                if (sB() != null) {
                    arrayList.add(new at.a(w.l.send_app_code_gift, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (sA() != null) {
                    arrayList.add(new at.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (th()) {
                    arrayList.add(new at.a(w.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(sg())) {
                    arrayList.add(new at.a(sg()));
                }
            }
        }
        if (arrayList.size() > 0) {
            spannableStringBuilder = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), g, (ArrayList<at.a>) arrayList, false);
            if (spannableStringBuilder == null) {
                spannableStringBuilder = new SpannableStringBuilder();
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
        }
        SpannableString a = a(new SpannableString(String.valueOf(g) + " "), z);
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        } else if (arrayList.size() > 0 || spannableStringBuilder.length() == 0) {
            spannableStringBuilder.append((CharSequence) g);
        }
        this.Yv = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.Zt != null && this.Zt.size() > 0) {
            int size = this.Zt.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.Zt.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bk(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public void sW() {
        d(false, false);
    }

    public void sX() {
        d(true, false);
    }

    public void sY() {
        d(false, true);
    }

    public AnchorInfoData sZ() {
        return this.YE;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean ta() {
        return this.threadType == 36;
    }

    public boolean tb() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int tc() {
        return this.YR;
    }

    public void bV(int i) {
        this.YR = i;
    }

    public int td() {
        return this.Zc;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> sy = sy();
        if (sy == null || sP()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sy.size() || i2 >= 3) {
                break;
            }
            if (sy.get(i2) != null && sy.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(sy.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = sy.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = sy.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.YL != null && !StringUtils.isNull(this.YL.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.YL.thumbnail_url;
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

    public boolean te() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int sk = sk();
        if (this.YN != null && this.threadType == 49) {
            return Yd;
        }
        if (this.threadType == 51) {
            return Ye;
        }
        if (sk == 2 || sk == 1) {
            return XZ;
        }
        if (this.YL != null && to()) {
            return Yl;
        }
        if (this.YL != null) {
            if (sr()) {
                return Yf;
            }
            return Yc;
        } else if (sd() != null && getThreadType() == 36 && sd().type.intValue() == 2) {
            return Yj;
        } else {
            if (sd() != null && getThreadType() == 36 && sd().type.intValue() == 1) {
                return Yk;
            }
            if (rX() != null && getThreadType() == 41 && sm() == 1 && sQ() == 2) {
                return Yg.get() ? Zj : Ya;
            } else if (sT() && sS() == 1) {
                return Yg.get() ? Zo : Ya;
            } else if (sT() && sS() == 2) {
                return Yg.get() ? Zi : Ya;
            } else if (sr()) {
                return Yb;
            } else {
                return Ya;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus tf() {
        return this.Zb;
    }

    public List<TwAnchorProfitItem> qY() {
        return this.WI;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.YG == 1) {
            this.Vb = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Vb = 0;
        } else {
            this.Vb = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.qc() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.qc().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Vb = next.qd();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean tg() {
        return this.threadType == 41;
    }

    public boolean th() {
        return this.threadType == 48;
    }

    public boolean ti() {
        return this.Zp;
    }

    public void as(boolean z) {
        this.Zp = z;
    }

    public String tj() {
        return this.Zq;
    }

    public n tk() {
        return this.YV;
    }

    public boolean tl() {
        return sm() == 1 || sl() == 1 || sk() == 1 || sT() || this.Zr == 1 || sr() || sB() != null || sA() != null || !com.baidu.adp.lib.util.j.isEmpty(sg()) || th();
    }

    public void tm() {
        if (this.YP == 0) {
            this.YP = 1;
        }
    }

    public boolean tn() {
        return this.Zv;
    }

    public void at(boolean z) {
        this.ZD = z;
    }

    public boolean to() {
        return this.ZD;
    }

    public void bW(int i) {
        this.ZE = i + 1;
    }

    public int tp() {
        return this.ZE;
    }

    public List<ReportInfo> tq() {
        return this.ZF;
    }

    public boolean tr() {
        return this.Zw;
    }

    public void au(boolean z) {
        this.Zw = z;
    }

    public bp ts() {
        return this.YM;
    }

    public void a(bp bpVar) {
        this.YM = bpVar;
    }

    public void bX(int i) {
        if (this.YM != null) {
            this.YM.mCurrentPage = i;
        }
    }

    public boolean tt() {
        return getThreadType() == 49;
    }

    public int tu() {
        return this.ZK;
    }

    public void setSmartFrsPosition(int i) {
        this.ZK = i;
    }

    public SparseArray<String> rg() {
        return this.WT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.WT = sparseArray;
    }

    public String tv() {
        return this.Zx;
    }
}
