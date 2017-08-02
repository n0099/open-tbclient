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
    public static final BdUniqueId XD = BdUniqueId.gen();
    public static final BdUniqueId XE = BdUniqueId.gen();
    public static final BdUniqueId XF = BdUniqueId.gen();
    public static final BdUniqueId XG = BdUniqueId.gen();
    public static final BdUniqueId XH = BdUniqueId.gen();
    public static final BdUniqueId XI = BdUniqueId.gen();
    public static final BdUniqueId XJ = BdUniqueId.gen();
    public static final BdUniqueId XK = BdUniqueId.gen();
    public static final BdUniqueId XL = BdUniqueId.gen();
    public static AtomicBoolean XM = new AtomicBoolean(false);
    public static AtomicBoolean XN = new AtomicBoolean(false);
    public static AtomicBoolean XO = new AtomicBoolean(false);
    public static final BdUniqueId XP = BdUniqueId.gen();
    public static final BdUniqueId XQ = BdUniqueId.gen();
    public static final BdUniqueId XR = BdUniqueId.gen();
    private static HashMap<Point, Integer> YD = new HashMap<>();
    private static HashMap<Integer, Integer> YE = new HashMap<>();
    public static final BdUniqueId YP = BdUniqueId.gen();
    public static final BdUniqueId YQ = BdUniqueId.gen();
    public static final BdUniqueId YV = BdUniqueId.gen();
    private static HashMap<Point, Integer> Zn = new HashMap<>();
    private static SparseArray<m.a> Zo = new SparseArray<>(3);
    public TwZhiBoUser Wd;
    public List<TwAnchorProfitItem> We;
    private n YC;
    private LiveCoverStatus YI;
    private long YJ;
    private SkinInfo YU;
    private boolean YW;
    private String YX;
    private SpannableStringBuilder Yb;
    public int Yf;
    private int Yg;
    private int Yi;
    private String Yl;
    private int Ym;
    private String Yn;
    private int Yp;
    private VideoInfo Yr;
    private bq Ys;
    private c Yt;
    private long Yv;
    private MediaData ZA;
    private boolean Zc;
    private boolean Zd;
    public String Ze;
    public String Zf;
    public String Zg;
    public long Zh;
    public String Zj;
    private List<ReportInfo> Zm;
    private p Zs;
    private boolean Zt;
    private int Zv;
    private aj Zx;
    public d Zz;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    private String latitude;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public int XS = 1;
    private String Yh = null;
    private int Uw = 0;
    public int Yw = 0;
    private String Yx = "";
    private String YF = "";
    public boolean Zi = true;
    public boolean Zp = false;
    public boolean Zq = false;
    private int Zr = -1;
    private SparseArray<String> Wx = null;
    public boolean Zy = false;
    private String id = null;
    private String Ww = null;
    private long fid = 0;
    private String title = null;
    private int Yu = 0;
    private int reply_num = 0;
    private int XT = 0;
    private int view_num = 0;
    private String last_time = null;
    private long XU = 0;
    private int XV = 0;
    private int XW = 0;
    private int XX = 0;
    private bo XY = new bo();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Yd = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Ye = new ArrayList<>();
    private int XZ = 0;
    private int Ya = 0;
    private String ad_url = null;
    private String Yc = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData Yj = new PraiseData();
    private AnchorInfoData Yk = new AnchorInfoData();
    private long time = 0;
    private int Yo = 0;
    private ArrayList<a> Yz = new ArrayList<>();
    private bu YA = null;
    private e YB = null;
    private int YG = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> Yq = new ArrayList<>();
    private boolean isHeadLive = false;
    private String YH = null;
    private int Yy = 0;
    private PollInfo YK = null;
    private boolean YL = false;
    private boolean YM = false;
    private int YN = 0;
    private boolean YO = false;
    private int anchorLevel = 0;
    public int YY = 0;
    public k YZ = new k();
    private List<PbContent> Za = new ArrayList();
    private List<PbContent> Zb = new ArrayList();
    private String category_name = null;
    private bj YR = new bj();
    private ArrayList<com.baidu.tbadk.data.a> YS = new ArrayList<>();
    private PushStatusData YT = new PushStatusData();
    public boolean Zk = false;
    public int Zl = -1;
    private int Zu = 0;
    private PostData Zw = new PostData();

    static {
        YD.put(new Point(1, 1), Integer.valueOf(d.g.label_frs_lottery_ing));
        YD.put(new Point(1, 2), Integer.valueOf(d.g.label_frs_lottery_over));
        YD.put(new Point(1, 3), Integer.valueOf(d.g.label_frs_lottery_off));
        YD.put(new Point(1, 4), Integer.valueOf(d.g.label_frs_lottery_d));
        YD.put(new Point(2, 1), Integer.valueOf(d.g.label_frs_activity_shaiing));
        YD.put(new Point(2, 2), Integer.valueOf(d.g.label_frs_activity_shai_over));
        YD.put(new Point(2, 3), Integer.valueOf(d.g.label_frs_activity_shai_off));
        YD.put(new Point(2, 4), Integer.valueOf(d.g.label_frs_activity_shai_d));
        Zn.put(new Point(1, 1), Integer.valueOf(d.l.lottery_status_ing));
        Zn.put(new Point(1, 2), Integer.valueOf(d.l.lottery_status_over));
        Zn.put(new Point(1, 3), Integer.valueOf(d.l.lottery_status_off));
        Zn.put(new Point(1, 4), Integer.valueOf(d.l.lottery_status_not_start));
        Zn.put(new Point(2, 1), Integer.valueOf(d.l.share_picture_status_ing));
        Zn.put(new Point(2, 2), Integer.valueOf(d.l.share_picture_status_over));
        Zn.put(new Point(2, 3), Integer.valueOf(d.l.share_picture_status_off));
        Zn.put(new Point(2, 4), Integer.valueOf(d.l.share_picture_status_not_start));
        YE.put(1, Integer.valueOf(d.g.label_interview_no));
        YE.put(2, Integer.valueOf(d.g.label_interview_live));
        YE.put(3, Integer.valueOf(d.g.label_interview_off));
        Zo.put(1, new m.a(d.l.interview_live_status_not_start, d.e.cp_other_b, d.g.pic_dot_title_red));
        Zo.put(2, new m.a(d.l.interview_live_status_ing, d.e.cp_other_c, d.g.pic_dot_title_green));
        Zo.put(3, new m.a(d.l.interview_live_status_over, d.e.cp_other_d, d.g.pic_dot_title_blue));
    }

    public bl() {
        this.Yg = 0;
        this.Yp = 0;
        this.YJ = 0L;
        this.post_num = 0;
        this.post_num = 0;
        this.YJ = 0L;
        this.Yp = 0;
        this.Yg = 0;
    }

    public boolean rc() {
        return this.Yg == 1;
    }

    public bj rd() {
        return this.YR;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bN(int i) {
        this.anchorLevel = i;
    }

    public int re() {
        return this.Yp;
    }

    public boolean rf() {
        return this.YO;
    }

    public boolean rg() {
        return this.YL;
    }

    public boolean rh() {
        return this.YM;
    }

    public void bO(int i) {
        this.YN = i;
    }

    public int ri() {
        return this.YN;
    }

    public PollInfo rj() {
        return this.YK;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Yv;
    }

    public String rk() {
        return this.Yl;
    }

    public PraiseData rl() {
        return this.Yj;
    }

    public void a(PraiseData praiseData) {
        this.Yj = praiseData;
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

    public void cz(String str) {
        this.Ww = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.Ww) || "0".equals(this.Ww)) ? this.id : this.Ww;
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

    public void bP(int i) {
        this.reply_num = i;
    }

    public int rn() {
        return this.reply_num;
    }

    public int ro() {
        return this.view_num;
    }

    public void bQ(int i) {
        this.view_num = i;
    }

    public long rp() {
        return this.XU;
    }

    public void m(long j) {
        this.XU = j;
    }

    public int rq() {
        return this.XV;
    }

    public void bR(int i) {
        this.XV = i;
    }

    public int rr() {
        return this.XW;
    }

    public void bS(int i) {
        this.XW = i;
    }

    public int rs() {
        return this.XX;
    }

    public List<PbContent> rt() {
        return this.Za;
    }

    public bo ru() {
        return this.XY;
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
        return this.Yu != 0;
    }

    public boolean rx() {
        return this.Yu == 1;
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

    public void cD(String str) {
        this.forum_name = str;
    }

    public int rB() {
        return this.Ya;
    }

    public String rC() {
        return this.ad_url;
    }

    public String rD() {
        return this.Yc;
    }

    public void cE(String str) {
        this.Yc = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.Zb == null || this.Zb.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.Zb.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.Zb.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.Za == null || (size = this.Za.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.Za.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cF(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.Zb != null && (size = this.Zb.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.Zb.get(i2);
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
                                bl.this.cI(pbContent.link);
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
        return this.Yh;
    }

    public void cG(String str) {
        this.Yh = str;
    }

    public ArrayList<MediaData> rF() {
        return this.Yd;
    }

    public ArrayList<a> rG() {
        return this.Yz;
    }

    public void h(ArrayList<a> arrayList) {
        this.Yz = arrayList;
    }

    public bu rH() {
        return this.YA;
    }

    public e rI() {
        return this.YB;
    }

    public ArrayList<VoiceData.VoiceModel> rJ() {
        return this.Ye;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rK() {
        return this.Ym;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rL() {
        return this.Yx;
    }

    public VideoInfo rM() {
        return this.Yr;
    }

    public void a(c cVar) {
        this.Yt = cVar;
    }

    public c rN() {
        return this.Yt;
    }

    public String getPhotoLiveCover() {
        return this.YF;
    }

    public void setPhotoLiveCover(String str) {
        this.YF = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rO() {
        return this.Yq;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.Yq.clear();
        this.Yq.addAll(arrayList);
    }

    public String getNotice() {
        return this.YH;
    }

    public PushStatusData rP() {
        return this.YT;
    }

    public SkinInfo rQ() {
        return this.YU;
    }

    public long rR() {
        return this.Zh;
    }

    public boolean rS() {
        return this.Zi;
    }

    public String rT() {
        return this.Zj;
    }

    public p rU() {
        return this.Zs;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.Yn = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.Yg = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.Ww = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Yu = threadInfo.is_god.intValue();
                this.Yv = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.XT = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.XU = threadInfo.last_time_int.intValue();
                this.XV = threadInfo.is_top.intValue();
                this.XW = threadInfo.is_good.intValue();
                this.XX = threadInfo.is_livepost.intValue();
                this.XY.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.XZ = threadInfo.has_commented.intValue();
                this.Ya = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Yr = threadInfo.video_info;
                this.Yt = new c();
                this.Yt.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.Yh = threadInfo.collect_mark_pid;
                this.Yi = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.Yl = threadInfo.first_post_id + "";
                this.Yx = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.Ym = threadInfo.is_ntitle.intValue();
                this.Yo = threadInfo.is_activity.intValue();
                this.Zu = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.Zv = threadInfo.agree.has_agree.intValue();
                }
                this.category_name = threadInfo.category_name;
                this.Yp = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.Zc = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.Za = threadInfo.rich_title;
                this.Zb = threadInfo.rich_abstract;
                this.Yf = threadInfo.is_godthread_recommend.intValue();
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
                this.Yc = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Yd.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Yr = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.Ys = new bq();
                    this.Ys.a(threadInfo.video_channel_info);
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
                        this.Ye.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Yz.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.YA = new bu();
                    this.YA.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.YB = new e();
                    this.YB.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.YC = new n();
                    this.YC.a(threadInfo.cartoon_info);
                }
                this.Yj.setUserMap(this.userMap);
                this.Yj.parserProtobuf(threadInfo.zan);
                this.Yk.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Yj.setTitle(this.title);
                } else {
                    this.Yj.setTitle(this.Yc);
                }
                this.YF = threadInfo.livecover_src;
                this.YG = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Yy = threadInfo.post_num.intValue();
                this.YJ = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.ek(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Yq.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.YH = noticeInfo.notice;
                    }
                    this.YN = zhiBoInfoTW.copythread_remind.intValue();
                    this.YL = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.YM = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.YF)) {
                        this.YF = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.Wd = zhiBoInfoTW.user.tw_anchor_info;
                        this.We = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.YI = threadInfo.twzhibo_info.livecover_status;
                    this.YJ = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.YK = threadInfo.poll_info;
                this.YO = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.YR.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.YS.add(aVar2);
                    }
                }
                this.YT.parserProtobuf(threadInfo.push_status);
                this.YX = threadInfo.lego_card;
                this.YU = threadInfo.skin_info;
                this.YY = threadInfo.is_book_chapter.intValue();
                this.YZ.a(threadInfo.book_chapter);
                this.Ze = threadInfo.recom_source;
                this.Zj = threadInfo.recom_reason;
                this.Zf = threadInfo.recom_weight;
                this.Zg = threadInfo.ab_tag;
                this.Zh = threadInfo.last_read_pid.longValue();
                this.Zi = threadInfo.cheak_repeat.intValue() == 1;
                this.Zm = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.Zw.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.u.u(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.Wx = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.u.v(threadInfo.declare_list)) {
                    this.Zs = new p();
                    this.Zs.a(threadInfo);
                }
                this.Zt = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.Zx = new aj();
                    this.Zx.a(threadInfo.link_info);
                }
                this.Zy = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.Zz = new d();
                    this.Zz.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.ZA = new MediaData();
                    this.ZA.parserProtobuf(threadInfo.pic_info);
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
                this.Ww = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.Yu = jSONObject.optInt("is_god");
                this.Yv = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.XT = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.XU = jSONObject.optLong("last_time_int", 0L);
                this.XV = jSONObject.optInt("is_top", 0);
                this.XW = jSONObject.optInt("is_good", 0);
                this.XX = jSONObject.optInt("is_livepost", 0);
                this.XY.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.XZ = jSONObject.optInt("has_commented", 0);
                this.Ya = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.Yh = jSONObject.optString("collect_mark_pid");
                this.Yi = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.Yl = jSONObject.optString("first_post_id", "0");
                this.Yx = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Ym = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.YR.parserJson(optJSONObject2);
                }
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.Yt = new c();
                this.Yt.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.Yc = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Yd.add(mediaData);
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
                        this.Ye.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Yz.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.YA = new bu();
                    this.YA.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.YB = new e();
                    this.YB.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.YC = new n();
                    this.YC.parserJson(optJSONObject6);
                }
                this.Yj.setUserMap(this.userMap);
                this.Yj.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.Yk.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Yj.setTitle(this.title);
                } else {
                    this.Yj.setTitle(this.Yc);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.YR.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.YS.add(aVar2);
                    }
                }
                this.YY = jSONObject.optInt("is_book_chapter", 0);
                this.YZ.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.Ze = jSONObject.optString("recom_source");
                this.Zj = jSONObject.optString("recom_reason");
                this.Zf = jSONObject.optString("recom_weight");
                this.Zh = jSONObject.optLong("last_read_pid");
                this.Zi = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.Ys = new bq();
                    this.Ys.i(optJSONObject8);
                }
                this.Zt = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.Zx = new aj();
                    this.Zx.parserJson(optJSONObject9);
                }
                this.Zy = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.Zz = new d();
                    this.Zz.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.ZA = new MediaData();
                    this.ZA.parserJson(optJSONObject11);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rV() {
        return this.Yb;
    }

    public boolean rW() {
        return rq() != 0;
    }

    public int rX() {
        if (this.YR != null) {
            long qW = this.YR.qW();
            long qX = this.YR.qX();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qW) {
                return 1;
            }
            if (currentTimeMillis > qX) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rY() {
        if (sa() && this.Yz.size() >= 1) {
            a aVar = this.Yz.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pf = aVar.pf();
            int pg = aVar.pg();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pf) {
                return 4;
            }
            return currentTimeMillis > pg ? 2 : 1;
        }
        return -1;
    }

    public int rZ() {
        if (!sa() || this.Yz.size() < 1 || this.Yz.get(0) == null) {
            return -1;
        }
        return this.Yz.get(0).pe();
    }

    public boolean sa() {
        return this.Yo == 1;
    }

    public String sb() {
        return (!sa() || this.Yz.size() < 1 || this.Yz.get(0) == null) ? "" : this.Yz.get(0).getUrl();
    }

    private com.baidu.adp.widget.b cH(String str) {
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
            if (rs() == 1 || this.XY.sU() != 0) {
                if (rd() != null && getThreadType() == 41) {
                    if (rX() == 2) {
                        arrayList.add(Integer.valueOf(d.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.g.icon_zhibo));
                }
            }
            if (z && sn()) {
                Integer num = YE.get(Integer.valueOf(rX()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rr() == 1 && !rW() && XH != getType() && XL != getType()) {
                arrayList.add(Integer.valueOf(d.g.icon_elite));
            }
            if (getType() == XP || getType() == XQ) {
                arrayList.add(Integer.valueOf(d.g.icon_vote_blue));
            }
            if (this.Yk != null && this.Yk.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.g.icon_live_on));
            }
            if (rB() == 1) {
                arrayList.add(Integer.valueOf(d.g.frs_post_ding));
            }
            if (!z && rZ() == 2) {
                arrayList.add(Integer.valueOf(d.g.label_frs_activity_shai));
            } else {
                Integer num2 = YD.get(new Point(rZ(), rY()));
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
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                bVar = cH(this.category_name);
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
                Bitmap cQ = com.baidu.tbadk.core.util.ai.cQ(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.XS));
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
            SpannableStringBuilder c = !z && rq() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.Yb = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<m.a> arrayList) {
        if (si() || !rw() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new m.a(d.l.god_title));
        }
        return com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean sc() {
        return com.baidu.adp.lib.b.d.eW().af("isConveneThreadOpen") == 1;
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
        this.Yb = a(g, a(new SpannableString(g + " ")), z, z2, z3);
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
            if (this.Ym == 1) {
                this.Yb = a;
                return a;
            }
        } else if (this.Ym == 1) {
            this.Yb = new SpannableStringBuilder();
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
        if (this.Za != null && this.Za.size() > 0) {
            int size = this.Za.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.Za.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bl.2
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bl.this.cI(pbContent.link);
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
    public void cI(String str) {
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
        return this.Yk;
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
        return this.Yy;
    }

    public void bT(int i) {
        this.Yy = i;
    }

    public long sk() {
        return this.YJ;
    }

    @Override // com.baidu.tbadk.core.util.ad
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
        if (this.Yr != null && !StringUtils.isNull(this.Yr.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.Yr.thumbnail_url;
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
        if (this.Yt != null && this.threadType == 60) {
            return XK;
        }
        if (this.Yt != null && this.threadType == 49) {
            return XI;
        }
        if (this.threadType == 51) {
            return XJ;
        }
        if (rq == 2 || rq == 1) {
            return XD;
        }
        if (this.Yr != null && sv()) {
            return XR;
        }
        if (this.Yr != null) {
            if (ry()) {
                return XL;
            }
            return XH;
        } else if (rj() != null && getThreadType() == 36 && rj().type.intValue() == 2) {
            return XP;
        } else {
            if (rj() != null && getThreadType() == 36 && rj().type.intValue() == 1) {
                return XQ;
            }
            if (rd() != null && getThreadType() == 41 && rs() == 1 && rX() == 2) {
                return XM.get() ? YQ : XE;
            } else if (sa() && rZ() == 1) {
                return XM.get() ? YV : XE;
            } else if (sa() && rZ() == 2) {
                return XM.get() ? YP : XE;
            } else if (isLinkThread()) {
                return XF;
            } else {
                if (ry()) {
                    return XG;
                }
                return XE;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sm() {
        return this.YI;
    }

    public List<TwAnchorProfitItem> pZ() {
        return this.We;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.Ym == 1) {
            this.Uw = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Uw = 0;
        } else {
            this.Uw = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.py() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.py().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Uw = next.pz();
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
        return this.YW;
    }

    public void ao(boolean z) {
        this.YW = z;
    }

    public String sq() {
        return this.YX;
    }

    public n sr() {
        return this.YC;
    }

    public boolean ss() {
        return rs() == 1 || rr() == 1 || rq() == 1 || sa() || this.YY == 1 || ry() || rI() != null || rH() != null || !com.baidu.adp.lib.util.j.isEmpty(getCategory()) || so() || rx();
    }

    public void st() {
        if (this.Yw == 0) {
            this.Yw = 1;
        }
    }

    public boolean su() {
        return this.Zc;
    }

    public void ap(boolean z) {
        this.Zk = z;
    }

    public boolean sv() {
        return this.Zk;
    }

    public void bU(int i) {
        this.Zl = i + 1;
    }

    public int sw() {
        return this.Zl;
    }

    public List<ReportInfo> sx() {
        return this.Zm;
    }

    public boolean sy() {
        return this.Zd;
    }

    public void aq(boolean z) {
        this.Zd = z;
    }

    public bq sz() {
        return this.Ys;
    }

    public void a(bq bqVar) {
        this.Ys = bqVar;
    }

    public void bV(int i) {
        if (this.Ys != null) {
            this.Ys.mCurrentPage = i;
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
        return this.Zr;
    }

    public void setSmartFrsPosition(int i) {
        this.Zr = i;
    }

    public SparseArray<String> qm() {
        return this.Wx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.Wx = sparseArray;
    }

    public String sG() {
        return this.Ze;
    }

    public boolean sH() {
        return this.Zt;
    }

    public int sI() {
        return this.Zu;
    }

    public int sJ() {
        return this.Zv;
    }

    public void bW(int i) {
        this.Zv = i;
    }

    public void bX(int i) {
        this.Zu = i;
    }

    public PostData sK() {
        return this.Zw;
    }

    public aj sL() {
        return this.Zx;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        String g;
        SpannableString a;
        if (this.Ym == 1) {
            g = g(this.Yc, false);
            a = cF(this.Yc);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        SpannableStringBuilder a2 = a(g, a, z, true, z2);
        this.Yb = a2;
        return a2;
    }

    private ArrayList<m.a> c(boolean z, boolean z2, boolean z3) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean rw = rw();
        if (z2) {
            if (z) {
                if (rw && !si()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if (rs() == 1 || getThreadType() == 33 || (ru() != null && ru().sU() != 0)) {
                    if (rd() != null && sn()) {
                        if (rX() == 2) {
                            arrayList.add(new m.a(d.l.interview_live));
                        }
                    } else if (!rw) {
                        arrayList.add(new m.a(d.l.photo_live_tips));
                    }
                }
                if (rq() == 1) {
                    arrayList.add(new m.a(d.l.commit_top));
                }
                if (rr() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (sn()) {
                    arrayList.add(Zo.get(rX()));
                }
                if (sa()) {
                    Integer num = Zn.get(new Point(rZ(), rY()));
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
                if (!com.baidu.tbadk.core.util.al.isEmpty(getCategory())) {
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
                    arrayList.add(new m.a(d.l.commit_top));
                }
                if (sn() && rd() != null && rX() == 2) {
                    arrayList.add(new m.a(d.l.interview_live));
                }
                if (sa()) {
                    Integer num2 = Zn.get(new Point(rZ(), rY()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (this.YY == 1) {
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
                if (!com.baidu.tbadk.core.util.al.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && sA()) {
                    arrayList.add(new m.a(d.l.frs_ala_live_title_prefix));
                }
                if (sE()) {
                    arrayList.add(new m.a(d.l.frs_channel_tip));
                } else if (z3 && sC()) {
                    arrayList.add(new m.a(d.l.frs_ala_record_title_prefix));
                } else if (sB()) {
                    arrayList.add(new m.a(d.l.frs_video_title_prefix));
                }
            }
        }
        return arrayList;
    }

    public MediaData sM() {
        return this.ZA;
    }
}
