package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.Headers;
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
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.video.ActivityItemData;
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
public class be extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.i, com.baidu.tbadk.core.util.ae {
    public TwZhiBoUser aLG;
    public List<TwAnchorProfitItem> aLH;
    private SpannableStringBuilder aNB;
    public int aNF;
    private int aNG;
    private int aNJ;
    private String aNM;
    private int aNN;
    private String aNO;
    private int aNQ;
    private VideoInfo aNS;
    private bk aNT;
    private AlaInfoData aNU;
    private long aNV;
    private boolean aOC;
    private boolean aOD;
    public long aOF;
    public String aOH;
    private List<ReportInfo> aOK;
    private boolean aOQ;
    private int aOS;
    private long aOU;
    private ae aOV;
    public c aOX;
    private MediaData aOY;
    public int aOZ;
    private m aOc;
    private LiveCoverStatus aOi;
    private long aOj;
    private SkinInfo aOu;
    private boolean aOw;
    private String aOx;
    public OriginalThreadInfo aPb;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    public boolean isShareThread;
    private String latitude;
    private long mCreateTime;
    private String mFromType;
    public String mRecomAbTag;
    public String mRecomSource;
    public String mRecomWeight;
    private int post_num;
    public int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId aNb = BdUniqueId.gen();
    public static final BdUniqueId aNc = BdUniqueId.gen();
    public static final BdUniqueId aNd = BdUniqueId.gen();
    public static final BdUniqueId aNe = BdUniqueId.gen();
    public static final BdUniqueId aNf = BdUniqueId.gen();
    public static final BdUniqueId aNg = BdUniqueId.gen();
    public static final BdUniqueId aNh = BdUniqueId.gen();
    public static final BdUniqueId aNi = BdUniqueId.gen();
    public static final BdUniqueId aNj = BdUniqueId.gen();
    public static final BdUniqueId aNk = BdUniqueId.gen();
    public static AtomicBoolean aNl = new AtomicBoolean(false);
    public static AtomicBoolean aNm = new AtomicBoolean(false);
    public static AtomicBoolean aNn = new AtomicBoolean(false);
    public static final BdUniqueId aNo = BdUniqueId.gen();
    public static final BdUniqueId aNp = BdUniqueId.gen();
    public static final BdUniqueId aNq = BdUniqueId.gen();
    private static HashMap<Point, Integer> aOd = new HashMap<>();
    private static HashMap<Integer, Integer> aOe = new HashMap<>();
    public static final BdUniqueId aOp = BdUniqueId.gen();
    public static final BdUniqueId aOq = BdUniqueId.gen();
    public static final BdUniqueId aOv = BdUniqueId.gen();
    private static HashMap<Point, Integer> aOL = new HashMap<>();
    private static SparseArray<k.a> aOM = new SparseArray<>(3);
    public int aNr = 1;
    private String aNI = null;
    private int aKw = 0;
    public int aNW = 0;
    private String aNX = "";
    private String aOf = "";
    public boolean aOG = true;
    public boolean aON = false;
    public boolean aOO = false;
    private int aOP = -1;
    private SparseArray<String> aLZ = null;
    public boolean aOW = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aNs = 0;
    private int view_num = 0;
    private String last_time = null;
    private long aNt = 0;
    private int aNu = 0;
    private int aNv = 0;
    private int aNw = 0;
    private bi aNx = new bi();
    private MetaData aNy = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aND = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aNE = new ArrayList<>();
    private int aNz = 0;
    private int aNA = 0;
    private String ad_url = null;
    private String aNC = null;
    private String from = null;
    private int aNH = 0;
    private PraiseData aNK = new PraiseData();
    private AnchorInfoData aNL = new AnchorInfoData();
    private long time = 0;
    private int aNP = 0;
    private ArrayList<a> aNZ = new ArrayList<>();
    private bo aOa = null;
    private d aOb = null;
    private int aOg = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> aNR = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aOh = null;
    private int aNY = 0;
    private PollInfo aOk = null;
    private boolean aOl = false;
    private boolean aOm = false;
    private int aOn = 0;
    private boolean aOo = false;
    private int anchorLevel = 0;
    public int aOy = 0;
    public j aOz = new j();
    private List<PbContent> aOA = new ArrayList();
    private List<PbContent> aOB = new ArrayList();
    private String category_name = null;
    private bc aOr = new bc();
    private ArrayList<com.baidu.tbadk.data.c> aOs = new ArrayList<>();
    private PushStatusData aOt = new PushStatusData();
    public boolean aOI = false;
    public int aOJ = -1;
    private int aOR = 0;
    private PostData aOT = new PostData();
    private int aOE = 0;
    public int aPa = 0;
    private String tieba_game_information_source = "";

    static {
        aOd.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        aOd.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        aOd.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        aOd.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        aOd.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        aOd.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        aOd.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        aOd.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        aOL.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        aOL.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        aOL.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        aOL.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        aOL.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        aOL.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        aOL.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        aOL.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        aOe.put(1, Integer.valueOf(d.f.label_interview_no));
        aOe.put(2, Integer.valueOf(d.f.label_interview_live));
        aOe.put(3, Integer.valueOf(d.f.label_interview_off));
        aOM.put(1, new k.a(d.j.interview_live_status_not_start, d.C0108d.cp_other_b, d.f.pic_dot_title_red));
        aOM.put(2, new k.a(d.j.interview_live_status_ing, d.C0108d.cp_other_c, d.f.pic_dot_title_green));
        aOM.put(3, new k.a(d.j.interview_live_status_over, d.C0108d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public be() {
        this.aNG = 0;
        this.aNQ = 0;
        this.aOj = 0L;
        this.aOZ = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.aOj = 0L;
        this.aNQ = 0;
        this.aNG = 0;
        this.aOZ = 0;
    }

    public boolean yC() {
        return this.aNG == 1;
    }

    public bc yD() {
        return this.aOr;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void eN(int i) {
        this.anchorLevel = i;
    }

    public int yE() {
        return this.aNQ;
    }

    public int yF() {
        return this.aOE;
    }

    public void eO(int i) {
        this.aOE = i;
    }

    public boolean yG() {
        return this.aOl;
    }

    public boolean yH() {
        return this.aOm;
    }

    public void eP(int i) {
        this.aOn = i;
    }

    public int yI() {
        return this.aOn;
    }

    public PollInfo yJ() {
        return this.aOk;
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

    public long yK() {
        return this.aNV;
    }

    public String yL() {
        return this.aNM;
    }

    public PraiseData yM() {
        return this.aNK;
    }

    public void a(PraiseData praiseData) {
        this.aNK = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String yN() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cK(String str) {
        this.tid = str;
    }

    public String yO() {
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

    public void eQ(int i) {
        this.reply_num = i;
    }

    public int yP() {
        return this.reply_num;
    }

    public int yQ() {
        return this.view_num;
    }

    public void eR(int i) {
        this.view_num = i;
    }

    public long yR() {
        return this.aNt;
    }

    public void v(long j) {
        this.aNt = j;
    }

    public int yS() {
        return this.aNu;
    }

    public void eS(int i) {
        this.aNu = i;
    }

    public int yT() {
        return this.aNv;
    }

    public void eT(int i) {
        this.aNv = i;
    }

    public int yU() {
        return this.aNw;
    }

    public List<PbContent> yV() {
        return this.aOA;
    }

    public bi yW() {
        return this.aNx;
    }

    public MetaData yX() {
        return this.aNy;
    }

    public UserTbVipInfoData yY() {
        if (this.aNy == null) {
            return null;
        }
        return this.aNy.getUserTbVipInfoData();
    }

    public boolean yZ() {
        return this.is_god != 0;
    }

    public boolean za() {
        return this.is_god == 1;
    }

    public boolean zb() {
        return (this.aNy == null || this.aNy.getGodUserData() == null || this.aNy.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean zc() {
        return (this.aNy == null || this.aNy.getGodUserData() == null || this.aNy.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aNy = metaData;
    }

    public String zd() {
        return this.forum_name;
    }

    public void cO(String str) {
        this.forum_name = str;
    }

    public int ze() {
        return this.aNA;
    }

    public String zf() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aNC;
    }

    public void cP(String str) {
        this.aNC = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aOB == null || this.aOB.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aOB.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aOB.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aOA == null || (size = this.aOA.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aOA.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cQ(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.aOB != null && (size = this.aOB.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aOB.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.be.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                be.this.cU(pbContent.link);
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

    public int zg() {
        return this.aNH;
    }

    public void eU(int i) {
        this.aNH = i;
    }

    public String zh() {
        return this.aNI;
    }

    public void cR(String str) {
        this.aNI = str;
    }

    public ArrayList<MediaData> zi() {
        return this.aND;
    }

    public ArrayList<a> zj() {
        return this.aNZ;
    }

    public void i(ArrayList<a> arrayList) {
        this.aNZ = arrayList;
    }

    public bo zk() {
        return this.aOa;
    }

    public d zl() {
        return this.aOb;
    }

    public ArrayList<VoiceData.VoiceModel> zm() {
        return this.aNE;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int zn() {
        return this.aNN;
    }

    public void eV(int i) {
        this.aNN = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String zo() {
        return this.aNX;
    }

    public VideoInfo zp() {
        return this.aNS;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aNU = alaInfoData;
    }

    public AlaInfoData zq() {
        return this.aNU;
    }

    public String getPhotoLiveCover() {
        return this.aOf;
    }

    public void setPhotoLiveCover(String str) {
        this.aOf = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> zr() {
        return this.aNR;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.aNR.clear();
        this.aNR.addAll(arrayList);
    }

    public String getNotice() {
        return this.aOh;
    }

    public PushStatusData zs() {
        return this.aOt;
    }

    public SkinInfo zt() {
        return this.aOu;
    }

    public long zu() {
        return this.aOF;
    }

    public boolean zv() {
        return this.aOG;
    }

    public String zw() {
        return this.aOH;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aNO = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aNG = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aNV = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aNs = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aNt = threadInfo.last_time_int.intValue();
                this.aNu = threadInfo.is_top.intValue();
                this.aNv = threadInfo.is_good.intValue();
                this.aNw = threadInfo.is_livepost.intValue();
                this.aNx.a(threadInfo.topic);
                this.aNy.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aNz = threadInfo.has_commented.intValue();
                this.aNA = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aNS = threadInfo.video_info;
                this.aNU = new AlaInfoData();
                this.aNU.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aNH = threadInfo.collect_status.intValue();
                this.aNI = threadInfo.collect_mark_pid;
                this.aNJ = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aNM = threadInfo.first_post_id + "";
                this.aNX = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aNN = threadInfo.is_ntitle.intValue();
                this.aNP = threadInfo.is_activity.intValue();
                this.aOR = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aOS = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aOU = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aNQ = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aOC = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aOA = threadInfo.rich_title;
                this.aOB = threadInfo.rich_abstract;
                this.aNF = threadInfo.is_godthread_recommend.intValue();
                if ((this.aNy == null || this.aNy.getUserId() == null || this.aNy.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNy = metaData;
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
                this.aNC = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aND.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aNS = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aNT = new bk();
                    this.aNT.a(threadInfo.video_channel_info);
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
                        this.aNE.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aNZ.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aOa = new bo();
                    this.aOa.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aOb = new d();
                    this.aOb.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aOc = new m();
                    this.aOc.a(threadInfo.cartoon_info);
                }
                this.aNK.setUserMap(this.userMap);
                this.aNK.parserProtobuf(threadInfo.zan);
                this.aNL.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aNK.setTitle(this.title);
                } else {
                    this.aNK.setTitle(this.aNC);
                }
                this.aOf = threadInfo.livecover_src;
                this.aOg = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aNY = threadInfo.post_num.intValue();
                this.aOj = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.ht(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aNR.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aOh = noticeInfo.notice;
                    }
                    this.aOn = zhiBoInfoTW.copythread_remind.intValue();
                    this.aOl = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aOm = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aOf)) {
                        this.aOf = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aLG = zhiBoInfoTW.user.tw_anchor_info;
                        this.aLH = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aOi = threadInfo.twzhibo_info.livecover_status;
                    this.aOj = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aOk = threadInfo.poll_info;
                this.aOo = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aOr.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aOs.add(cVar);
                    }
                }
                this.aOt.parserProtobuf(threadInfo.push_status);
                this.aOx = threadInfo.lego_card;
                this.aOu = threadInfo.skin_info;
                this.aOy = threadInfo.is_book_chapter.intValue();
                this.aOz.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.aOH = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.aOF = threadInfo.last_read_pid.longValue();
                this.aOG = threadInfo.cheak_repeat.intValue() == 1;
                this.aOK = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aOT.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.F(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.aLZ = sparseArray;
                }
                this.aOQ = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aOV = new ae();
                    this.aOV.a(threadInfo.link_info);
                }
                this.aOW = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aOX = new c();
                    this.aOX.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aOY = new MediaData();
                    this.aOY.parserProtobuf(threadInfo.pic_info);
                }
                this.aOE = threadInfo.is_called.intValue();
                this.aOZ = threadInfo.middle_page_num.intValue();
                this.aPa = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.origin_thread_info != null) {
                    this.aPb = new OriginalThreadInfo();
                    this.aPb.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.aPb = new OriginalThreadInfo();
                    this.aPb.parser(threadInfo.origin_thread_info);
                } else {
                    this.aPb = null;
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
                this.fid = jSONObject.optLong(ImageViewerConfig.FORUM_ID, 0L);
                this.tid = jSONObject.optString("tid");
                this.title = jSONObject.optString("title");
                this.is_god = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.aNV = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aNs = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.aNt = jSONObject.optLong("last_time_int", 0L);
                this.aNu = jSONObject.optInt("is_top", 0);
                this.aNv = jSONObject.optInt("is_good", 0);
                this.aNw = jSONObject.optInt("is_livepost", 0);
                this.aNx.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aNy.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aNz = jSONObject.optInt("has_commented", 0);
                this.aNA = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aNH = jSONObject.optInt("collect_status");
                this.aNI = jSONObject.optString("collect_mark_pid");
                this.aNJ = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aOR = jSONObject.optInt("agree_num");
                this.aOU = jSONObject.optLong("share_num");
                this.aNM = jSONObject.optString("first_post_id", "0");
                this.aNX = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.aNN = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.aOS = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aOr.parserJson(optJSONObject2);
                }
                if ((this.aNy == null || this.aNy.getUserId() == null) && this.userMap != null) {
                    this.aNy = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aNU = new AlaInfoData();
                this.aNU.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aNC = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aND.add(mediaData);
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
                        this.aNE.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aNZ.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aOa = new bo();
                    this.aOa.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aOb = new d();
                    this.aOb.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aOc = new m();
                    this.aOc.parserJson(optJSONObject6);
                }
                this.aNK.setUserMap(this.userMap);
                this.aNK.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aNL.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aNK.setTitle(this.title);
                } else {
                    this.aNK.setTitle(this.aNC);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aOr.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aOs.add(cVar);
                    }
                }
                this.aOy = jSONObject.optInt("is_book_chapter", 0);
                this.aOz.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.aOH = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.aOF = jSONObject.optLong("last_read_pid");
                this.aOG = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aNT = new bk();
                    this.aNT.e(optJSONObject8);
                }
                this.aOQ = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aOV = new ae();
                    this.aOV.parserJson(optJSONObject9);
                }
                this.aOW = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aOX = new c();
                    this.aOX.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aOY = new MediaData();
                    this.aOY.parserJson(optJSONObject11);
                }
                this.aOE = jSONObject.optInt("is_called", 0);
                this.aOZ = jSONObject.optInt("middle_page_num", 0);
                this.aPa = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.aNS = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.aPb = new OriginalThreadInfo();
                        this.aPb.parserJson(optJSONObject13);
                        return;
                    }
                    this.aPb = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder zx() {
        return this.aNB;
    }

    public boolean zy() {
        return yS() != 0;
    }

    public int zz() {
        if (this.aOr != null) {
            long yx = this.aOr.yx();
            long yy = this.aOr.yy();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < yx) {
                return 1;
            }
            if (currentTimeMillis > yy) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int zA() {
        if (zC() && this.aNZ.size() >= 1) {
            a aVar = this.aNZ.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int wS = aVar.wS();
            int wT = aVar.wT();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < wS) {
                return 4;
            }
            return currentTimeMillis > wT ? 2 : 1;
        }
        return -1;
    }

    public int zB() {
        if (!zC() || this.aNZ.size() < 1 || this.aNZ.get(0) == null) {
            return -1;
        }
        return this.aNZ.get(0).wR();
    }

    public boolean zC() {
        return this.aNP == 1;
    }

    public String getActUrl() {
        return (!zC() || this.aNZ.size() < 1 || this.aNZ.get(0) == null) ? "" : this.aNZ.get(0).getUrl();
    }

    private com.baidu.adp.widget.b cS(String str) {
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0108d.cp_cont_f_1));
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

    private void g(boolean z, boolean z2) {
        SpannableString spannableString;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && zD()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (yS() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (yS() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (yU() == 1 || this.aNx.Aw() != 0) {
                if (yD() != null && getThreadType() == 41) {
                    if (zz() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && zQ()) {
                Integer num = aOe.get(Integer.valueOf(zz()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (yT() == 1 && !zy() && aNf != getType() && aNk != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (getType() == aNo || getType() == aNp) {
                arrayList.add(Integer.valueOf(d.f.icon_vote_blue));
            }
            if (this.aNL != null && this.aNL.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (ze() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            if (!z && zB() == 2) {
                arrayList.add(Integer.valueOf(d.f.label_frs_activity_shai));
            } else {
                Integer num2 = aOd.get(new Point(zB(), zA()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (zk() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (zl() != null) {
                arrayList.add(Integer.valueOf(d.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = cS(this.category_name);
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
                Bitmap fQ = com.baidu.tbadk.core.util.aj.fQ(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(fQ);
                if (fQ != null) {
                    bitmapDrawable.setBounds(0, 0, fQ.getWidth(), fQ.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aNr));
                spannableString.setSpan(kVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder c = !z && yS() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aNB = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<k.a> arrayList) {
        if (zK() || !yZ() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new k.a(d.j.god_title));
        }
        return com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean zD() {
        return com.baidu.adp.lib.b.d.mz().an("isConveneThreadOpen") == 1;
    }

    public void h(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.F(a(z, z2, z3, false)) > 0) {
            i(z, z3);
            return;
        }
        String g = g(this.title, false);
        SpannableString a = a(new SpannableString(g + " "));
        if (z) {
            spannableStringBuilder = a(g, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aNB = spannableStringBuilder;
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
            if (this.aNN == 1) {
                this.aNB = a2;
                return a2;
            }
        } else if (this.aNN == 1) {
            this.aNB = new SpannableStringBuilder();
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
        if (this.aOA != null && this.aOA.size() > 0) {
            int size = this.aOA.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aOA.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (zK()) {
                            if (pbContent.text != null) {
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, cT(pbContent.text)) { // from class: com.baidu.tbadk.core.data.be.2
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view) {
                                        be.this.cU(getLink());
                                    }
                                }, i3, pbContent.text.length() + i3, 33);
                            }
                        } else {
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.be.3
                                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    be.this.cU(pbContent.link);
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

    private String cT(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData zE() {
        if (this.aOA != null && this.aOA.size() > 0) {
            int size = this.aOA.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.aOA.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && zK() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = cT(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, str));
        }
    }

    public void zF() {
        g(false, false);
    }

    public void zG() {
        g(true, false);
    }

    public void zH() {
        g(false, true);
    }

    public AnchorInfoData zI() {
        return this.aNL;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean zJ() {
        return this.threadType == 36;
    }

    public boolean zK() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int zL() {
        return this.aNY;
    }

    public void eW(int i) {
        this.aNY = i;
    }

    public long zM() {
        return this.aOj;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> zi = zi();
        if (zi == null || zy()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zi.size() || i2 >= 3) {
                break;
            }
            if (zi.get(i2) != null && zi.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(zi.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = zi.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = zi.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aNS != null && !StringUtils.isNull(this.aNS.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aNS.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aNy != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aNy.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean zN() {
        String userId;
        return this.aNy == null || (userId = this.aNy.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        int yS = yS();
        if (this.aNU != null && this.threadType == 60) {
            return aNi;
        }
        if (this.aNU != null && this.threadType == 49) {
            return aNg;
        }
        if (this.threadType == 51) {
            return aNh;
        }
        if (yS == 2 || yS == 1) {
            return aNb;
        }
        if (this.aNS != null && zY()) {
            return aNq;
        }
        if (this.aNS != null) {
            if (zb()) {
                return aNk;
            }
            return aNf;
        } else if (this.isShareThread) {
            return aNj;
        } else {
            if (yJ() != null && getThreadType() == 36 && yJ().type.intValue() == 2) {
                return aNo;
            }
            if (yJ() != null && getThreadType() == 36 && yJ().type.intValue() == 1) {
                return aNp;
            }
            if (zO()) {
                return aNl.get() ? aOq : aNc;
            } else if (zC() && zB() == 1) {
                return aNl.get() ? aOv : aNc;
            } else if (zC() && zB() == 2) {
                return aNl.get() ? aOp : aNc;
            } else if (isLinkThread()) {
                return aNd;
            } else {
                if (zb()) {
                    return aNe;
                }
                return aNc;
            }
        }
    }

    public boolean zO() {
        return yD() != null && getThreadType() == 41 && yU() == 1 && zz() == 2;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus zP() {
        return this.aOi;
    }

    public List<TwAnchorProfitItem> xB() {
        return this.aLH;
    }

    public void j(ArrayList<n> arrayList) {
        if (this.aNN == 1) {
            this.aKw = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aKw = 0;
        } else {
            this.aKw = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.xk() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.xk().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aKw = next.xl();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean zQ() {
        return this.threadType == 41;
    }

    public boolean zR() {
        return this.threadType == 48;
    }

    public boolean zS() {
        return this.aOw;
    }

    public void aS(boolean z) {
        this.aOw = z;
    }

    public String zT() {
        return this.aOx;
    }

    public m zU() {
        return this.aOc;
    }

    public boolean zV() {
        return yU() == 1 || yT() == 1 || yS() == 1 || zC() || this.aOy == 1 || zb() || zl() != null || zk() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || zR() || za();
    }

    public void zW() {
        if (this.aNW == 0) {
            this.aNW = 1;
        }
    }

    public boolean zX() {
        return this.aOC;
    }

    public void aT(boolean z) {
        this.aOI = z;
    }

    public boolean zY() {
        return this.aOI;
    }

    public void eX(int i) {
        this.aOJ = i + 1;
    }

    public int zZ() {
        return this.aOJ;
    }

    public List<ReportInfo> Aa() {
        return this.aOK;
    }

    public boolean Ab() {
        return this.aOD;
    }

    public void aU(boolean z) {
        this.aOD = z;
    }

    public bk Ac() {
        return this.aNT;
    }

    public void a(bk bkVar) {
        this.aNT = bkVar;
    }

    public void eY(int i) {
        if (this.aNT != null) {
            this.aNT.mCurrentPage = i;
        }
    }

    public boolean Ad() {
        return getThreadType() == 49;
    }

    public boolean Ae() {
        return getThreadType() == 40;
    }

    public boolean Af() {
        return getThreadType() == 50;
    }

    public boolean Ag() {
        return getThreadType() == 60;
    }

    public boolean Ah() {
        return getThreadType() == 40 && Ac() != null && Ac().channelId > 0;
    }

    public int Ai() {
        return this.aOP;
    }

    public void setSmartFrsPosition(int i) {
        this.aOP = i;
    }

    public SparseArray<String> xO() {
        return this.aLZ;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aLZ = sparseArray;
    }

    public String Aj() {
        return this.mRecomSource;
    }

    public boolean Ak() {
        return this.aOQ;
    }

    public int Al() {
        return this.aOR;
    }

    public int Am() {
        return this.aOS;
    }

    public void eZ(int i) {
        this.aOS = i;
    }

    public void fa(int i) {
        this.aOR = i;
    }

    public long An() {
        return this.aOU;
    }

    public void w(long j) {
        this.aOU = j;
    }

    public PostData Ao() {
        return this.aOT;
    }

    public ae Ap() {
        return this.aOV;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aNN == 1) {
            g = g(this.aNC, false);
            a = cQ(this.aNC);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aNB = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder i(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder j(boolean z, boolean z2) {
        SpannableString cQ;
        if (!StringUtils.isNull(this.title)) {
            cQ = a(new SpannableString(g(this.title, false) + " "));
        } else {
            g(this.aNC, false);
            cQ = cQ(this.aNC);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cQ);
        this.aNB = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<k.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<k.a> arrayList = new ArrayList<>();
        boolean yZ = yZ();
        if (z2) {
            if (z) {
                if (yZ && !zK()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if (yU() == 1 || getThreadType() == 33 || (yW() != null && yW().Aw() != 0)) {
                    if (yD() != null && zQ()) {
                        if (zz() == 2) {
                            arrayList.add(new k.a(d.j.interview_live));
                        }
                    } else if (!yZ) {
                        arrayList.add(new k.a(d.j.photo_live_tips));
                    }
                }
                if (yS() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (yT() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (zQ()) {
                    arrayList.add(aOM.get(zz()));
                }
                if (zC()) {
                    Integer num = aOL.get(new Point(zB(), zA()));
                    if (num != null) {
                        arrayList.add(new k.a(num.intValue(), d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (zR()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (zk() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
            } else {
                if (yZ && yS() != 1 && !zK()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if ((yU() == 1 || getThreadType() == 33) && !zQ() && !yZ) {
                    arrayList.add(new k.a(d.j.photo_live_tips));
                }
                if (yT() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (yS() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (zQ() && yD() != null && zz() == 2) {
                    arrayList.add(new k.a(d.j.interview_live));
                }
                if (zC()) {
                    Integer num2 = aOL.get(new Point(zB(), zA()));
                    if (num2 != null) {
                        arrayList.add(new k.a(num2.intValue(), d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (this.aOy == 1) {
                    arrayList.add(new k.a(d.j.card_tbread_text));
                }
                if (zl() != null) {
                    arrayList.add(new k.a(d.j.send_app_code_gift, d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (zk() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (zR()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
                if (z3 && Ad()) {
                    arrayList.add(new k.a(d.j.ala_live));
                }
                if (Ah()) {
                    arrayList.add(new k.a(d.j.frs_channel_tip));
                } else if (z3 && Af()) {
                    arrayList.add(new k.a(d.j.live_record));
                } else if (Ae()) {
                    arrayList.add(new k.a(d.j.video_title_str));
                }
                if (z4) {
                    arrayList.add(new k.a(d.j.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void k(ArrayList<MediaData> arrayList) {
        this.aND = arrayList;
    }
}
