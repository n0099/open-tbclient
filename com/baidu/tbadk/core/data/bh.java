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
    public TwZhiBoUser WA;
    public List<TwAnchorProfitItem> WB;
    private int YA;
    private String YD;
    private int YE;
    private String YF;
    private int YH;
    private VideoInfo YJ;
    private bm YK;
    private c YL;
    private n YS;
    private LiveCoverStatus YY;
    private long YZ;
    private SpannableStringBuilder Yt;
    public int Yx;
    private int Yy;
    public String ZA;
    private List<ReportInfo> ZD;
    private p ZJ;
    private boolean ZK;
    private int ZM;
    private long ZO;
    private ah ZP;
    public d ZR;
    private MediaData ZS;
    private SkinInfo Zk;
    private boolean Zm;
    private String Zn;
    private boolean Zs;
    private boolean Zt;
    public String Zv;
    public String Zw;
    public String Zx;
    public long Zy;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    private String latitude;
    private long mCreateTime;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId XV = BdUniqueId.gen();
    public static final BdUniqueId XW = BdUniqueId.gen();
    public static final BdUniqueId XX = BdUniqueId.gen();
    public static final BdUniqueId XY = BdUniqueId.gen();
    public static final BdUniqueId XZ = BdUniqueId.gen();
    public static final BdUniqueId Ya = BdUniqueId.gen();
    public static final BdUniqueId Yb = BdUniqueId.gen();
    public static final BdUniqueId Yc = BdUniqueId.gen();
    public static final BdUniqueId Yd = BdUniqueId.gen();
    public static AtomicBoolean Ye = new AtomicBoolean(false);
    public static AtomicBoolean Yf = new AtomicBoolean(false);
    public static AtomicBoolean Yg = new AtomicBoolean(false);
    public static final BdUniqueId Yh = BdUniqueId.gen();
    public static final BdUniqueId Yi = BdUniqueId.gen();
    public static final BdUniqueId Yj = BdUniqueId.gen();
    private static HashMap<Point, Integer> YT = new HashMap<>();
    private static HashMap<Integer, Integer> YU = new HashMap<>();
    public static final BdUniqueId Zf = BdUniqueId.gen();
    public static final BdUniqueId Zg = BdUniqueId.gen();
    public static final BdUniqueId Zl = BdUniqueId.gen();
    private static HashMap<Point, Integer> ZE = new HashMap<>();
    private static SparseArray<m.a> ZF = new SparseArray<>(3);
    public int Yk = 1;
    private String Yz = null;
    private int Vd = 0;
    public int YM = 0;
    private String YN = "";
    private String YV = "";
    public boolean Zz = true;
    public boolean ZG = false;
    public boolean ZH = false;
    private int ZI = -1;
    private SparseArray<String> WU = null;
    public boolean ZQ = false;
    private String id = null;
    private String WT = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int Yl = 0;
    private int view_num = 0;
    private String last_time = null;
    private long Ym = 0;
    private int Yn = 0;
    private int Yo = 0;
    private int Yp = 0;
    private bk Yq = new bk();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Yv = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Yw = new ArrayList<>();
    private int Yr = 0;
    private int Ys = 0;
    private String ad_url = null;
    private String Yu = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData YB = new PraiseData();
    private AnchorInfoData YC = new AnchorInfoData();
    private long time = 0;
    private int YG = 0;
    private ArrayList<a> YP = new ArrayList<>();
    private bq YQ = null;
    private e YR = null;
    private int YW = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> YI = new ArrayList<>();
    private boolean isHeadLive = false;
    private String YX = null;
    private int YO = 0;
    private PollInfo Za = null;
    private boolean Zb = false;
    private boolean Zc = false;
    private int Zd = 0;
    private boolean Ze = false;
    private int anchorLevel = 0;
    public int Zo = 0;
    public k Zp = new k();
    private List<PbContent> Zq = new ArrayList();
    private List<PbContent> Zr = new ArrayList();
    private String category_name = null;
    private bf Zh = new bf();
    private ArrayList<com.baidu.tbadk.data.a> Zi = new ArrayList<>();
    private PushStatusData Zj = new PushStatusData();
    public boolean ZB = false;
    public int ZC = -1;
    private int ZL = 0;
    private PostData ZN = new PostData();
    private int Zu = 0;

    static {
        YT.put(new Point(1, 1), Integer.valueOf(d.g.label_frs_lottery_ing));
        YT.put(new Point(1, 2), Integer.valueOf(d.g.label_frs_lottery_over));
        YT.put(new Point(1, 3), Integer.valueOf(d.g.label_frs_lottery_off));
        YT.put(new Point(1, 4), Integer.valueOf(d.g.label_frs_lottery_d));
        YT.put(new Point(2, 1), Integer.valueOf(d.g.label_frs_activity_shaiing));
        YT.put(new Point(2, 2), Integer.valueOf(d.g.label_frs_activity_shai_over));
        YT.put(new Point(2, 3), Integer.valueOf(d.g.label_frs_activity_shai_off));
        YT.put(new Point(2, 4), Integer.valueOf(d.g.label_frs_activity_shai_d));
        ZE.put(new Point(1, 1), Integer.valueOf(d.l.lottery_status_ing));
        ZE.put(new Point(1, 2), Integer.valueOf(d.l.lottery_status_over));
        ZE.put(new Point(1, 3), Integer.valueOf(d.l.lottery_status_off));
        ZE.put(new Point(1, 4), Integer.valueOf(d.l.lottery_status_not_start));
        ZE.put(new Point(2, 1), Integer.valueOf(d.l.share_picture_status_ing));
        ZE.put(new Point(2, 2), Integer.valueOf(d.l.share_picture_status_over));
        ZE.put(new Point(2, 3), Integer.valueOf(d.l.share_picture_status_off));
        ZE.put(new Point(2, 4), Integer.valueOf(d.l.share_picture_status_not_start));
        YU.put(1, Integer.valueOf(d.g.label_interview_no));
        YU.put(2, Integer.valueOf(d.g.label_interview_live));
        YU.put(3, Integer.valueOf(d.g.label_interview_off));
        ZF.put(1, new m.a(d.l.interview_live_status_not_start, d.e.cp_other_b, d.g.pic_dot_title_red));
        ZF.put(2, new m.a(d.l.interview_live_status_ing, d.e.cp_other_c, d.g.pic_dot_title_green));
        ZF.put(3, new m.a(d.l.interview_live_status_over, d.e.cp_other_d, d.g.pic_dot_title_blue));
    }

    public bh() {
        this.Yy = 0;
        this.YH = 0;
        this.YZ = 0L;
        this.post_num = 0;
        this.post_num = 0;
        this.YZ = 0L;
        this.YH = 0;
        this.Yy = 0;
    }

    public boolean qU() {
        return this.Yy == 1;
    }

    public bf qV() {
        return this.Zh;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bO(int i) {
        this.anchorLevel = i;
    }

    public int qW() {
        return this.YH;
    }

    public boolean qX() {
        return this.Ze;
    }

    public int qY() {
        return this.Zu;
    }

    public void bP(int i) {
        this.Zu = i;
    }

    public boolean qZ() {
        return this.Zb;
    }

    public boolean ra() {
        return this.Zc;
    }

    public void bQ(int i) {
        this.Zd = i;
    }

    public int rb() {
        return this.Zd;
    }

    public PollInfo rc() {
        return this.Za;
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

    public String rd() {
        return this.YD;
    }

    public PraiseData re() {
        return this.YB;
    }

    public void a(PraiseData praiseData) {
        this.YB = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rf() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cx(String str) {
        this.WT = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.WT) || "0".equals(this.WT)) ? this.id : this.WT;
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

    public int rg() {
        return this.reply_num;
    }

    public int rh() {
        return this.view_num;
    }

    public void bS(int i) {
        this.view_num = i;
    }

    public long ri() {
        return this.Ym;
    }

    public void m(long j) {
        this.Ym = j;
    }

    public int rj() {
        return this.Yn;
    }

    public void bT(int i) {
        this.Yn = i;
    }

    public int rk() {
        return this.Yo;
    }

    public void bU(int i) {
        this.Yo = i;
    }

    public int rl() {
        return this.Yp;
    }

    public List<PbContent> rm() {
        return this.Zq;
    }

    public bk rn() {
        return this.Yq;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData ro() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rp() {
        return this.is_god != 0;
    }

    public boolean rq() {
        return this.is_god == 1;
    }

    public boolean rr() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rs() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rt() {
        return this.forum_name;
    }

    public void cB(String str) {
        this.forum_name = str;
    }

    public int ru() {
        return this.Ys;
    }

    public String rv() {
        return this.ad_url;
    }

    public String rw() {
        return this.Yu;
    }

    public void cC(String str) {
        this.Yu = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.Zr == null || this.Zr.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.Zr.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.Zr.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.Zq == null || (size = this.Zq.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.Zq.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cD(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.Zr != null && (size = this.Zr.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.Zr.get(i2);
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
                                bh.this.cG(pbContent.link);
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

    public String rx() {
        return this.Yz;
    }

    public void cE(String str) {
        this.Yz = str;
    }

    public ArrayList<MediaData> ry() {
        return this.Yv;
    }

    public ArrayList<a> rz() {
        return this.YP;
    }

    public void h(ArrayList<a> arrayList) {
        this.YP = arrayList;
    }

    public bq rA() {
        return this.YQ;
    }

    public e rB() {
        return this.YR;
    }

    public ArrayList<VoiceData.VoiceModel> rC() {
        return this.Yw;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rD() {
        return this.YE;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rE() {
        return this.YN;
    }

    public VideoInfo rF() {
        return this.YJ;
    }

    public void a(c cVar) {
        this.YL = cVar;
    }

    public c rG() {
        return this.YL;
    }

    public String getPhotoLiveCover() {
        return this.YV;
    }

    public void setPhotoLiveCover(String str) {
        this.YV = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rH() {
        return this.YI;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.YI.clear();
        this.YI.addAll(arrayList);
    }

    public String getNotice() {
        return this.YX;
    }

    public PushStatusData rI() {
        return this.Zj;
    }

    public SkinInfo rJ() {
        return this.Zk;
    }

    public long rK() {
        return this.Zy;
    }

    public boolean rL() {
        return this.Zz;
    }

    public String rM() {
        return this.ZA;
    }

    public p rN() {
        return this.ZJ;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.YF = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.Yy = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.WT = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Yl = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.Ym = threadInfo.last_time_int.intValue();
                this.Yn = threadInfo.is_top.intValue();
                this.Yo = threadInfo.is_good.intValue();
                this.Yp = threadInfo.is_livepost.intValue();
                this.Yq.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Yr = threadInfo.has_commented.intValue();
                this.Ys = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.YJ = threadInfo.video_info;
                this.YL = new c();
                this.YL.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.Yz = threadInfo.collect_mark_pid;
                this.YA = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.YD = threadInfo.first_post_id + "";
                this.YN = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.YE = threadInfo.is_ntitle.intValue();
                this.YG = threadInfo.is_activity.intValue();
                this.ZL = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.ZM = threadInfo.agree.has_agree.intValue();
                }
                this.ZO = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.YH = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.Zs = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.Zq = threadInfo.rich_title;
                this.Zr = threadInfo.rich_abstract;
                this.Yx = threadInfo.is_godthread_recommend.intValue();
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
                this.Yu = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Yv.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.YJ = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.YK = new bm();
                    this.YK.a(threadInfo.video_channel_info);
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
                        this.Yw.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.YP.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.YQ = new bq();
                    this.YQ.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.YR = new e();
                    this.YR.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.YS = new n();
                    this.YS.a(threadInfo.cartoon_info);
                }
                this.YB.setUserMap(this.userMap);
                this.YB.parserProtobuf(threadInfo.zan);
                this.YC.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.YB.setTitle(this.title);
                } else {
                    this.YB.setTitle(this.Yu);
                }
                this.YV = threadInfo.livecover_src;
                this.YW = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.YO = threadInfo.post_num.intValue();
                this.YZ = threadInfo.freq_num.longValue();
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
                                this.YI.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.YX = noticeInfo.notice;
                    }
                    this.Zd = zhiBoInfoTW.copythread_remind.intValue();
                    this.Zb = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Zc = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.YV)) {
                        this.YV = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.WA = zhiBoInfoTW.user.tw_anchor_info;
                        this.WB = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.YY = threadInfo.twzhibo_info.livecover_status;
                    this.YZ = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Za = threadInfo.poll_info;
                this.Ze = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Zh.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.Zi.add(aVar2);
                    }
                }
                this.Zj.parserProtobuf(threadInfo.push_status);
                this.Zn = threadInfo.lego_card;
                this.Zk = threadInfo.skin_info;
                this.Zo = threadInfo.is_book_chapter.intValue();
                this.Zp.a(threadInfo.book_chapter);
                this.Zv = threadInfo.recom_source;
                this.ZA = threadInfo.recom_reason;
                this.Zw = threadInfo.recom_weight;
                this.Zx = threadInfo.ab_tag;
                this.Zy = threadInfo.last_read_pid.longValue();
                this.Zz = threadInfo.cheak_repeat.intValue() == 1;
                this.ZD = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.ZN.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.t(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.WU = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.v.u(threadInfo.declare_list)) {
                    this.ZJ = new p();
                    this.ZJ.a(threadInfo);
                }
                this.ZK = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.ZP = new ah();
                    this.ZP.a(threadInfo.link_info);
                }
                this.ZQ = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.ZR = new d();
                    this.ZR.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.ZS = new MediaData();
                    this.ZS.parserProtobuf(threadInfo.pic_info);
                }
                this.Zu = threadInfo.is_called.intValue();
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
                this.WT = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.is_god = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Yl = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.Ym = jSONObject.optLong("last_time_int", 0L);
                this.Yn = jSONObject.optInt("is_top", 0);
                this.Yo = jSONObject.optInt("is_good", 0);
                this.Yp = jSONObject.optInt("is_livepost", 0);
                this.Yq.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Yr = jSONObject.optInt("has_commented", 0);
                this.Ys = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.Yz = jSONObject.optString("collect_mark_pid");
                this.YA = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.YD = jSONObject.optString("first_post_id", "0");
                this.YN = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.YE = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.Zh.parserJson(optJSONObject2);
                }
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.YL = new c();
                this.YL.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.Yu = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Yv.add(mediaData);
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
                        this.Yw.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.YP.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.YQ = new bq();
                    this.YQ.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.YR = new e();
                    this.YR.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.YS = new n();
                    this.YS.parserJson(optJSONObject6);
                }
                this.YB.setUserMap(this.userMap);
                this.YB.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.YC.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.YB.setTitle(this.title);
                } else {
                    this.YB.setTitle(this.Yu);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.Zh.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.Zi.add(aVar2);
                    }
                }
                this.Zo = jSONObject.optInt("is_book_chapter", 0);
                this.Zp.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.Zv = jSONObject.optString("recom_source");
                this.ZA = jSONObject.optString("recom_reason");
                this.Zw = jSONObject.optString("recom_weight");
                this.Zy = jSONObject.optLong("last_read_pid");
                this.Zz = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.YK = new bm();
                    this.YK.f(optJSONObject8);
                }
                this.ZK = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.ZP = new ah();
                    this.ZP.parserJson(optJSONObject9);
                }
                this.ZQ = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.ZR = new d();
                    this.ZR.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.ZS = new MediaData();
                    this.ZS.parserJson(optJSONObject11);
                }
                this.Zu = jSONObject.optInt("is_called", 0);
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
                    this.YJ = builder.build(true);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rO() {
        return this.Yt;
    }

    public boolean rP() {
        return rj() != 0;
    }

    public int rQ() {
        if (this.Zh != null) {
            long qO = this.Zh.qO();
            long qP = this.Zh.qP();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qO) {
                return 1;
            }
            if (currentTimeMillis > qP) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rR() {
        if (rT() && this.YP.size() >= 1) {
            a aVar = this.YP.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pe = aVar.pe();
            int pf = aVar.pf();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pe) {
                return 4;
            }
            return currentTimeMillis > pf ? 2 : 1;
        }
        return -1;
    }

    public int rS() {
        if (!rT() || this.YP.size() < 1 || this.YP.get(0) == null) {
            return -1;
        }
        return this.YP.get(0).pd();
    }

    public boolean rT() {
        return this.YG == 1;
    }

    public String rU() {
        return (!rT() || this.YP.size() < 1 || this.YP.get(0) == null) ? "" : this.YP.get(0).getUrl();
    }

    private com.baidu.adp.widget.b cF(String str) {
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
            if (getThreadType() == 42 && rV()) {
                arrayList.add(Integer.valueOf(d.g.icon_convene));
            }
            if (rj() == 1) {
                arrayList.add(Integer.valueOf(d.g.icon_top));
            } else if (rj() == 2) {
                arrayList.add(Integer.valueOf(d.g.icon_notice));
            }
            if (rl() == 1 || this.Yq.sO() != 0) {
                if (qV() != null && getThreadType() == 41) {
                    if (rQ() == 2) {
                        arrayList.add(Integer.valueOf(d.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.g.icon_zhibo));
                }
            }
            if (z && sg()) {
                Integer num = YU.get(Integer.valueOf(rQ()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rk() == 1 && !rP() && XZ != getType() && Yd != getType()) {
                arrayList.add(Integer.valueOf(d.g.icon_elite));
            }
            if (getType() == Yh || getType() == Yi) {
                arrayList.add(Integer.valueOf(d.g.icon_vote_blue));
            }
            if (this.YC != null && this.YC.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.g.icon_live_on));
            }
            if (ru() == 1) {
                arrayList.add(Integer.valueOf(d.g.frs_post_ding));
            }
            if (!z && rS() == 2) {
                arrayList.add(Integer.valueOf(d.g.label_frs_activity_shai));
            } else {
                Integer num2 = YT.get(new Point(rS(), rR()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rA() != null) {
                arrayList.add(Integer.valueOf(d.g.tag_act));
            }
            if (rB() != null) {
                arrayList.add(Integer.valueOf(d.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = cF(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.Yk));
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
            SpannableStringBuilder c = !z && rj() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.Yt = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<m.a> arrayList) {
        if (sb() || !rp() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new m.a(d.l.god_title));
        }
        return com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean rV() {
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
        this.Yt = spannableStringBuilder;
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
            if (this.YE == 1) {
                this.Yt = a2;
                return a2;
            }
        } else if (this.YE == 1) {
            this.Yt = new SpannableStringBuilder();
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
        if (this.Zq != null && this.Zq.size() > 0) {
            int size = this.Zq.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.Zq.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bh.2
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bh.this.cG(pbContent.link);
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
    public void cG(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, str));
        }
    }

    public void rW() {
        d(false, false);
    }

    public void rX() {
        d(true, false);
    }

    public void rY() {
        d(false, true);
    }

    public AnchorInfoData rZ() {
        return this.YC;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sa() {
        return this.threadType == 36;
    }

    public boolean sb() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sc() {
        return this.YO;
    }

    public void bV(int i) {
        this.YO = i;
    }

    public long sd() {
        return this.YZ;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> ry = ry();
        if (ry == null || rP()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ry.size() || i2 >= 3) {
                break;
            }
            if (ry.get(i2) != null && ry.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(ry.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = ry.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = ry.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.YJ != null && !StringUtils.isNull(this.YJ.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.YJ.thumbnail_url;
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

    public boolean se() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        int rj = rj();
        if (this.YL != null && this.threadType == 60) {
            return Yc;
        }
        if (this.YL != null && this.threadType == 49) {
            return Ya;
        }
        if (this.threadType == 51) {
            return Yb;
        }
        if (rj == 2 || rj == 1) {
            return XV;
        }
        if (this.YJ != null && so()) {
            return Yj;
        }
        if (this.YJ != null) {
            if (rr()) {
                return Yd;
            }
            return XZ;
        } else if (rc() != null && getThreadType() == 36 && rc().type.intValue() == 2) {
            return Yh;
        } else {
            if (rc() != null && getThreadType() == 36 && rc().type.intValue() == 1) {
                return Yi;
            }
            if (qV() != null && getThreadType() == 41 && rl() == 1 && rQ() == 2) {
                return Ye.get() ? Zg : XW;
            } else if (rT() && rS() == 1) {
                return Ye.get() ? Zl : XW;
            } else if (rT() && rS() == 2) {
                return Ye.get() ? Zf : XW;
            } else if (isLinkThread()) {
                return XX;
            } else {
                if (rr()) {
                    return XY;
                }
                return XW;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sf() {
        return this.YY;
    }

    public List<TwAnchorProfitItem> pS() {
        return this.WB;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.YE == 1) {
            this.Vd = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Vd = 0;
        } else {
            this.Vd = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.px() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.px().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Vd = next.py();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sg() {
        return this.threadType == 41;
    }

    public boolean sh() {
        return this.threadType == 48;
    }

    public boolean si() {
        return this.Zm;
    }

    public void an(boolean z) {
        this.Zm = z;
    }

    public String sj() {
        return this.Zn;
    }

    public n sk() {
        return this.YS;
    }

    public boolean sl() {
        return rl() == 1 || rk() == 1 || rj() == 1 || rT() || this.Zo == 1 || rr() || rB() != null || rA() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || sh() || rq();
    }

    public void sm() {
        if (this.YM == 0) {
            this.YM = 1;
        }
    }

    public boolean sn() {
        return this.Zs;
    }

    public void ao(boolean z) {
        this.ZB = z;
    }

    public boolean so() {
        return this.ZB;
    }

    public void bW(int i) {
        this.ZC = i + 1;
    }

    public int sp() {
        return this.ZC;
    }

    public List<ReportInfo> sq() {
        return this.ZD;
    }

    public boolean sr() {
        return this.Zt;
    }

    public void ap(boolean z) {
        this.Zt = z;
    }

    public bm ss() {
        return this.YK;
    }

    public void a(bm bmVar) {
        this.YK = bmVar;
    }

    public void bX(int i) {
        if (this.YK != null) {
            this.YK.mCurrentPage = i;
        }
    }

    public boolean st() {
        return getThreadType() == 49;
    }

    public boolean su() {
        return getThreadType() == 40;
    }

    public boolean sv() {
        return getThreadType() == 50;
    }

    public boolean sw() {
        return getThreadType() == 60;
    }

    public boolean sx() {
        return getThreadType() == 40 && ss() != null && ss().channelId > 0;
    }

    public int sy() {
        return this.ZI;
    }

    public void setSmartFrsPosition(int i) {
        this.ZI = i;
    }

    public SparseArray<String> qf() {
        return this.WU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.WU = sparseArray;
    }

    public String sz() {
        return this.Zv;
    }

    public boolean sA() {
        return this.ZK;
    }

    public int sB() {
        return this.ZL;
    }

    public int sC() {
        return this.ZM;
    }

    public void bY(int i) {
        this.ZM = i;
    }

    public void bZ(int i) {
        this.ZL = i;
    }

    public long sD() {
        return this.ZO;
    }

    public void n(long j) {
        this.ZO = j;
    }

    public PostData sE() {
        return this.ZN;
    }

    public ah sF() {
        return this.ZP;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.YE == 1) {
            g = g(this.Yu, false);
            a = cD(this.Yu);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.Yt = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        SpannableString cD;
        if (!StringUtils.isNull(this.title)) {
            cD = a(new SpannableString(g(this.title, false) + " "));
        } else {
            g(this.Yu, false);
            cD = cD(this.Yu);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cD);
        this.Yt = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<m.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean rp = rp();
        if (z2) {
            if (z) {
                if (rp && !sb()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if (rl() == 1 || getThreadType() == 33 || (rn() != null && rn().sO() != 0)) {
                    if (qV() != null && sg()) {
                        if (rQ() == 2) {
                            arrayList.add(new m.a(d.l.interview_live));
                        }
                    } else if (!rp) {
                        arrayList.add(new m.a(d.l.photo_live_tips));
                    }
                }
                if (rj() == 1) {
                    arrayList.add(new m.a(d.l.top));
                }
                if (rk() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (sg()) {
                    arrayList.add(ZF.get(rQ()));
                }
                if (rT()) {
                    Integer num = ZE.get(new Point(rS(), rR()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (sh()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (rA() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (rp && rj() != 1 && !sb()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if ((rl() == 1 || getThreadType() == 33) && !sg() && !rp) {
                    arrayList.add(new m.a(d.l.photo_live_tips));
                }
                if (rk() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (rj() == 1) {
                    arrayList.add(new m.a(d.l.top));
                }
                if (sg() && qV() != null && rQ() == 2) {
                    arrayList.add(new m.a(d.l.interview_live));
                }
                if (rT()) {
                    Integer num2 = ZE.get(new Point(rS(), rR()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (this.Zo == 1) {
                    arrayList.add(new m.a(d.l.card_tbread_text));
                }
                if (rB() != null) {
                    arrayList.add(new m.a(d.l.send_app_code_gift, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (rA() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (sh()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && st()) {
                    arrayList.add(new m.a(d.l.ala_live));
                }
                if (sx()) {
                    arrayList.add(new m.a(d.l.frs_channel_tip));
                } else if (z3 && sv()) {
                    arrayList.add(new m.a(d.l.live_record));
                } else if (su()) {
                    arrayList.add(new m.a(d.l.frs_video_title_prefix));
                }
                if (z4) {
                    arrayList.add(new m.a(d.l.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public MediaData sG() {
        return this.ZS;
    }
}
