package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.Headers;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
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
public class bd extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.i, com.baidu.tbadk.core.util.ae {
    private SpannableStringBuilder aNA;
    public int aNE;
    private int aNF;
    private int aNI;
    private String aNL;
    private int aNM;
    private String aNN;
    private int aNP;
    private VideoInfo aNR;
    private bj aNS;
    private AlaInfoData aNT;
    private long aNU;
    private boolean aOD;
    private boolean aOE;
    public long aOG;
    public String aOI;
    private List<ReportInfo> aOL;
    private boolean aOR;
    private int aOT;
    private long aOV;
    private ad aOW;
    public c aOY;
    private MediaData aOZ;
    private m aOb;
    private LiveCoverStatus aOh;
    private long aOi;
    public TwZhiBoUser aOr;
    public List<TwAnchorProfitItem> aOs;
    private SkinInfo aOv;
    private boolean aOx;
    private String aOy;
    public int aPa;
    public OriginalThreadInfo aPc;
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
    public static final BdUniqueId aNa = BdUniqueId.gen();
    public static final BdUniqueId aNb = BdUniqueId.gen();
    public static final BdUniqueId aNc = BdUniqueId.gen();
    public static final BdUniqueId aNd = BdUniqueId.gen();
    public static final BdUniqueId aNe = BdUniqueId.gen();
    public static final BdUniqueId aNf = BdUniqueId.gen();
    public static final BdUniqueId aNg = BdUniqueId.gen();
    public static final BdUniqueId aNh = BdUniqueId.gen();
    public static final BdUniqueId aNi = BdUniqueId.gen();
    public static final BdUniqueId aNj = BdUniqueId.gen();
    public static AtomicBoolean aNk = new AtomicBoolean(false);
    public static AtomicBoolean aNl = new AtomicBoolean(false);
    public static AtomicBoolean aNm = new AtomicBoolean(false);
    public static final BdUniqueId aNn = BdUniqueId.gen();
    public static final BdUniqueId aNo = BdUniqueId.gen();
    public static final BdUniqueId aNp = BdUniqueId.gen();
    private static HashMap<Point, Integer> aOc = new HashMap<>();
    private static HashMap<Integer, Integer> aOd = new HashMap<>();
    public static final BdUniqueId aOo = BdUniqueId.gen();
    public static final BdUniqueId aOp = BdUniqueId.gen();
    public static final BdUniqueId aOw = BdUniqueId.gen();
    private static HashMap<Point, Integer> aOM = new HashMap<>();
    private static SparseArray<k.a> aON = new SparseArray<>(3);
    public int aNq = 1;
    private String aNH = null;
    private int aKx = 0;
    public int aNV = 0;
    private String aNW = "";
    private String aOe = "";
    public boolean aOH = true;
    public boolean aOO = false;
    public boolean aOP = false;
    private int aOQ = -1;
    private SparseArray<String> aLY = null;
    public boolean aOX = false;
    public int aPd = 0;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aNr = 0;
    private int view_num = 0;
    private String last_time = null;
    private long aNs = 0;
    private int aNt = 0;
    private int aNu = 0;
    private int aNv = 0;
    private bh aNw = new bh();
    private MetaData aNx = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aNC = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aND = new ArrayList<>();
    private int aNy = 0;
    private int aNz = 0;
    private String ad_url = null;
    private String aNB = null;
    private String from = null;
    private int aNG = 0;
    private PraiseData aNJ = new PraiseData();
    private AnchorInfoData aNK = new AnchorInfoData();
    private long time = 0;
    private int aNO = 0;
    private ArrayList<a> aNY = new ArrayList<>();
    private bn aNZ = null;
    private d aOa = null;
    private int aOf = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> aNQ = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aOg = null;
    private int aNX = 0;
    private PollInfo aOj = null;
    private boolean aOk = false;
    private boolean aOl = false;
    private int aOm = 0;
    private boolean aOn = false;
    private int anchorLevel = 0;
    public int aOz = 0;
    public j aOA = new j();
    private List<PbContent> aOB = new ArrayList();
    private List<PbContent> aOC = new ArrayList();
    private String category_name = null;
    private bb aOq = new bb();
    private ArrayList<com.baidu.tbadk.data.c> aOt = new ArrayList<>();
    private PushStatusData aOu = new PushStatusData();
    public boolean aOJ = false;
    public int aOK = -1;
    private int aOS = 0;
    private PostData aOU = new PostData();
    private int aOF = 0;
    public int aPb = 0;
    private String tieba_game_information_source = "";

    static {
        aOc.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        aOc.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        aOc.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        aOc.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        aOc.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        aOc.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        aOc.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        aOc.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        aOM.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        aOM.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        aOM.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        aOM.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        aOM.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        aOM.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        aOM.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        aOM.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        aOd.put(1, Integer.valueOf(d.f.label_interview_no));
        aOd.put(2, Integer.valueOf(d.f.label_interview_live));
        aOd.put(3, Integer.valueOf(d.f.label_interview_off));
        aON.put(1, new k.a(d.j.interview_live_status_not_start, d.C0108d.cp_other_b, d.f.pic_dot_title_red));
        aON.put(2, new k.a(d.j.interview_live_status_ing, d.C0108d.cp_other_c, d.f.pic_dot_title_green));
        aON.put(3, new k.a(d.j.interview_live_status_over, d.C0108d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.aNF = 0;
        this.aNP = 0;
        this.aOi = 0L;
        this.aPa = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.aOi = 0L;
        this.aNP = 0;
        this.aNF = 0;
        this.aPa = 0;
    }

    public boolean yA() {
        return this.aNF == 1;
    }

    public bb yB() {
        return this.aOq;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void eM(int i) {
        this.anchorLevel = i;
    }

    public int yC() {
        return this.aNP;
    }

    public int yD() {
        return this.aOF;
    }

    public void eN(int i) {
        this.aOF = i;
    }

    public void eO(int i) {
        this.aOm = i;
    }

    public int yE() {
        return this.aOm;
    }

    public PollInfo yF() {
        return this.aOj;
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

    public long yG() {
        return this.aNU;
    }

    public String yH() {
        return this.aNL;
    }

    public PraiseData yI() {
        return this.aNJ;
    }

    public void a(PraiseData praiseData) {
        this.aNJ = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String yJ() {
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

    public String yK() {
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

    public void eP(int i) {
        this.reply_num = i;
    }

    public int yL() {
        return this.reply_num;
    }

    public int yM() {
        return this.view_num;
    }

    public void eQ(int i) {
        this.view_num = i;
    }

    public long yN() {
        return this.aNs;
    }

    public void v(long j) {
        this.aNs = j;
    }

    public int yO() {
        return this.aNt;
    }

    public void eR(int i) {
        this.aNt = i;
    }

    public int yP() {
        return this.aNu;
    }

    public void eS(int i) {
        this.aNu = i;
    }

    public int yQ() {
        return this.aNv;
    }

    public List<PbContent> yR() {
        return this.aOB;
    }

    public bh yS() {
        return this.aNw;
    }

    public MetaData yT() {
        return this.aNx;
    }

    public UserTbVipInfoData yU() {
        if (this.aNx == null) {
            return null;
        }
        return this.aNx.getUserTbVipInfoData();
    }

    public boolean yV() {
        return this.is_god != 0;
    }

    public boolean yW() {
        return this.is_god == 1;
    }

    public boolean yX() {
        return (this.aNx == null || this.aNx.getGodUserData() == null || this.aNx.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean yY() {
        return (this.aNx == null || this.aNx.getGodUserData() == null || this.aNx.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aNx = metaData;
    }

    public String yZ() {
        return this.forum_name;
    }

    public void cO(String str) {
        this.forum_name = str;
    }

    public int za() {
        return this.aNz;
    }

    public String zb() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aNB;
    }

    public void cP(String str) {
        this.aNB = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aOC == null || this.aOC.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aOC.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aOC.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aOB == null || (size = this.aOB.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aOB.get(i2);
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
        if (this.aOC != null && (size = this.aOC.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aOC.get(i2);
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
                                bd.this.cU(pbContent.link);
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

    public int zc() {
        return this.aNG;
    }

    public void eT(int i) {
        this.aNG = i;
    }

    public String zd() {
        return this.aNH;
    }

    public void cR(String str) {
        this.aNH = str;
    }

    public ArrayList<MediaData> ze() {
        return this.aNC;
    }

    public ArrayList<a> zf() {
        return this.aNY;
    }

    public void i(ArrayList<a> arrayList) {
        this.aNY = arrayList;
    }

    public bn zg() {
        return this.aNZ;
    }

    public d zh() {
        return this.aOa;
    }

    public ArrayList<VoiceData.VoiceModel> zi() {
        return this.aND;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int zj() {
        return this.aNM;
    }

    public void eU(int i) {
        this.aNM = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String zk() {
        return this.aNW;
    }

    public VideoInfo zl() {
        return this.aNR;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aNT = alaInfoData;
    }

    public AlaInfoData zm() {
        return this.aNT;
    }

    public String getPhotoLiveCover() {
        return this.aOe;
    }

    public void setPhotoLiveCover(String str) {
        this.aOe = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> zn() {
        return this.aNQ;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.aNQ.clear();
        this.aNQ.addAll(arrayList);
    }

    public PushStatusData zo() {
        return this.aOu;
    }

    public SkinInfo zp() {
        return this.aOv;
    }

    public long zq() {
        return this.aOG;
    }

    public boolean zr() {
        return this.aOH;
    }

    public String zs() {
        return this.aOI;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aNN = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aNF = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aNU = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aNr = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aNs = threadInfo.last_time_int.intValue();
                this.aNt = threadInfo.is_top.intValue();
                this.aNu = threadInfo.is_good.intValue();
                this.aNv = threadInfo.is_livepost.intValue();
                this.aNw.a(threadInfo.topic);
                this.aNx.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aNy = threadInfo.has_commented.intValue();
                this.aNz = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aNR = threadInfo.video_info;
                this.aNT = new AlaInfoData();
                this.aNT.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aNG = threadInfo.collect_status.intValue();
                this.aNH = threadInfo.collect_mark_pid;
                this.aNI = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aNL = threadInfo.first_post_id + "";
                this.aNW = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aNM = threadInfo.is_ntitle.intValue();
                this.aNO = threadInfo.is_activity.intValue();
                this.aOS = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aOT = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aOV = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aNP = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aOD = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aOB = threadInfo.rich_title;
                this.aOC = threadInfo.rich_abstract;
                this.aNE = threadInfo.is_godthread_recommend.intValue();
                if ((this.aNx == null || this.aNx.getUserId() == null || this.aNx.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNx = metaData;
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
                this.aNB = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aNC.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aNR = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aNS = new bj();
                    this.aNS.a(threadInfo.video_channel_info);
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
                        this.aND.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aNY.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aNZ = new bn();
                    this.aNZ.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aOa = new d();
                    this.aOa.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aOb = new m();
                    this.aOb.a(threadInfo.cartoon_info);
                }
                this.aNJ.setUserMap(this.userMap);
                this.aNJ.parserProtobuf(threadInfo.zan);
                this.aNK.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aNJ.setTitle(this.title);
                } else {
                    this.aNJ.setTitle(this.aNB);
                }
                this.aOe = threadInfo.livecover_src;
                this.aOf = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aNX = threadInfo.post_num.intValue();
                this.aOi = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.hp(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.fC(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aNQ.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aOg = noticeInfo.notice;
                    }
                    this.aOm = zhiBoInfoTW.copythread_remind.intValue();
                    this.aOk = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aOl = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aOe)) {
                        this.aOe = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aOr = zhiBoInfoTW.user.tw_anchor_info;
                        this.aOs = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aOh = threadInfo.twzhibo_info.livecover_status;
                    this.aOi = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aOj = threadInfo.poll_info;
                this.aOn = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aOq.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aOt.add(cVar);
                    }
                }
                this.aOu.parserProtobuf(threadInfo.push_status);
                this.aOy = threadInfo.lego_card;
                this.aOv = threadInfo.skin_info;
                this.aOz = threadInfo.is_book_chapter.intValue();
                this.aOA.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.aOI = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.aOG = threadInfo.last_read_pid.longValue();
                this.aOH = threadInfo.cheak_repeat.intValue() == 1;
                this.aOL = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aOU.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.D(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.aLY = sparseArray;
                }
                this.aOR = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aOW = new ad();
                    this.aOW.a(threadInfo.link_info);
                }
                this.aOX = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aOY = new c();
                    this.aOY.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aOZ = new MediaData();
                    this.aOZ.parserProtobuf(threadInfo.pic_info);
                }
                this.aOF = threadInfo.is_called.intValue();
                this.aPa = threadInfo.middle_page_num.intValue();
                this.aPb = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.origin_thread_info != null) {
                    this.aPc = new OriginalThreadInfo();
                    this.aPc.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.aPc = new OriginalThreadInfo();
                    this.aPc.parser(threadInfo.origin_thread_info);
                } else {
                    this.aPc = null;
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
                this.aNU = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aNr = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.aNs = jSONObject.optLong("last_time_int", 0L);
                this.aNt = jSONObject.optInt("is_top", 0);
                this.aNu = jSONObject.optInt("is_good", 0);
                this.aNv = jSONObject.optInt("is_livepost", 0);
                this.aNw.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aNx.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aNy = jSONObject.optInt("has_commented", 0);
                this.aNz = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aNG = jSONObject.optInt("collect_status");
                this.aNH = jSONObject.optString("collect_mark_pid");
                this.aNI = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aOS = jSONObject.optInt("agree_num");
                this.aOV = jSONObject.optLong("share_num");
                this.aNL = jSONObject.optString("first_post_id", "0");
                this.aNW = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.aNM = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.aOT = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aOq.parserJson(optJSONObject2);
                }
                if ((this.aNx == null || this.aNx.getUserId() == null) && this.userMap != null) {
                    this.aNx = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aNT = new AlaInfoData();
                this.aNT.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aNB = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aNC.add(mediaData);
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
                        this.aND.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aNY.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aNZ = new bn();
                    this.aNZ.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aOa = new d();
                    this.aOa.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aOb = new m();
                    this.aOb.parserJson(optJSONObject6);
                }
                this.aNJ.setUserMap(this.userMap);
                this.aNJ.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aNK.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aNJ.setTitle(this.title);
                } else {
                    this.aNJ.setTitle(this.aNB);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aOq.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aOt.add(cVar);
                    }
                }
                this.aOz = jSONObject.optInt("is_book_chapter", 0);
                this.aOA.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.aOI = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.aOG = jSONObject.optLong("last_read_pid");
                this.aOH = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aNS = new bj();
                    this.aNS.e(optJSONObject8);
                }
                this.aOR = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aOW = new ad();
                    this.aOW.parserJson(optJSONObject9);
                }
                this.aOX = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aOY = new c();
                    this.aOY.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aOZ = new MediaData();
                    this.aOZ.parserJson(optJSONObject11);
                }
                this.aOF = jSONObject.optInt("is_called", 0);
                this.aPa = jSONObject.optInt("middle_page_num", 0);
                this.aPb = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    builder.video_type = new Integer(optJSONObject12.optInt("video_type", 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    this.aNR = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.aPc = new OriginalThreadInfo();
                        this.aPc.parserJson(optJSONObject13);
                        return;
                    }
                    this.aPc = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder zt() {
        return this.aNA;
    }

    public boolean zu() {
        return yO() != 0;
    }

    public int zv() {
        if (this.aOq != null) {
            long yv = this.aOq.yv();
            long yw = this.aOq.yw();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < yv) {
                return 1;
            }
            if (currentTimeMillis > yw) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int zw() {
        if (zy() && this.aNY.size() >= 1) {
            a aVar = this.aNY.get(0);
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

    public int zx() {
        if (!zy() || this.aNY.size() < 1 || this.aNY.get(0) == null) {
            return -1;
        }
        return this.aNY.get(0).wR();
    }

    public boolean zy() {
        return this.aNO == 1;
    }

    public String getActUrl() {
        return (!zy() || this.aNY.size() < 1 || this.aNY.get(0) == null) ? "" : this.aNY.get(0).getUrl();
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
            if (getThreadType() == 42 && zA()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (yO() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (yO() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (yQ() == 1 || this.aNw.Ap() != 0) {
                if (yB() != null && getThreadType() == 41) {
                    if (zv() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && zJ()) {
                Integer num = aOd.get(Integer.valueOf(zv()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (yP() == 1 && !zu() && aNe != getType() && aNj != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (getType() == aNn || getType() == aNo) {
                arrayList.add(Integer.valueOf(d.f.icon_vote_blue));
            }
            if (this.aNK != null && this.aNK.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (za() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            if (!z && zx() == 2) {
                arrayList.add(Integer.valueOf(d.f.label_frs_activity_shai));
            } else {
                Integer num2 = aOc.get(new Point(zx(), zw()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (zg() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (zh() != null) {
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
                Bitmap fO = com.baidu.tbadk.core.util.aj.fO(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
                if (fO != null) {
                    bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aNq));
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
            SpannableStringBuilder c = !z && yO() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aNA = spannableStringBuilder;
    }

    public boolean zz() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || zl() == null || zl().video_type.intValue() == 0) {
            return i == 1 && zl() != null && (zl().video_type.intValue() == 1 || zl().video_type.intValue() == 12 || zl().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds8);
        Bitmap fO = com.baidu.tbadk.core.util.aj.fO(d.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
        bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
        com.baidu.tbadk.core.view.n nVar = new com.baidu.tbadk.core.view.n(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (yT() != null) {
            if (yT().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.he));
            } else if (yT().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(nVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private SpannableStringBuilder c(String str, ArrayList<k.a> arrayList) {
        if (zG() || !yV() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new k.a(d.j.god_title));
        }
        return com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean zA() {
        return com.baidu.adp.lib.b.d.mA().an("isConveneThreadOpen") == 1;
    }

    public void h(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.D(a(z, z2, z3, false)) > 0) {
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
        this.aNA = spannableStringBuilder;
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
            if (this.aNM == 1) {
                this.aNA = a2;
                return a2;
            }
        } else if (this.aNM == 1) {
            this.aNA = new SpannableStringBuilder();
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
        if (this.aOB != null && this.aOB.size() > 0) {
            int size = this.aOB.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aOB.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (zG()) {
                            if (pbContent.text != null) {
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, cT(pbContent.text)) { // from class: com.baidu.tbadk.core.data.bd.2
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view) {
                                        bd.this.cU(getLink());
                                    }
                                }, i3, pbContent.text.length() + i3, 33);
                            }
                        } else {
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bd.3
                                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    bd.this.cU(pbContent.link);
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

    public ActivityItemData zB() {
        if (this.aOB != null && this.aOB.size() > 0) {
            int size = this.aOB.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.aOB.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && zG() && pbContent.text != null && pbContent.text.length() >= 3) {
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

    public void zC() {
        g(false, false);
    }

    public void zD() {
        g(false, true);
    }

    public AnchorInfoData zE() {
        return this.aNK;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean zF() {
        return this.threadType == 36;
    }

    public boolean zG() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> ze = ze();
        if (ze == null || zu()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ze.size() || i2 >= 3) {
                break;
            }
            if (ze.get(i2) != null && ze.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(ze.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = ze.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = ze.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aNR != null && !StringUtils.isNull(this.aNR.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aNR.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aNx != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aNx.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean zH() {
        String userId;
        return this.aNx == null || (userId = this.aNx.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        int yO = yO();
        if (this.aNT != null && this.threadType == 60) {
            return aNh;
        }
        if (this.aNT != null && this.threadType == 49) {
            return aNf;
        }
        if (this.threadType == 51) {
            return aNg;
        }
        if (yO == 2 || yO == 1) {
            return aNa;
        }
        if (this.aNR != null && zR()) {
            return aNp;
        }
        if (this.aNR != null) {
            if (yX()) {
                return aNj;
            }
            return aNe;
        } else if (this.isShareThread) {
            return aNi;
        } else {
            if (yF() != null && getThreadType() == 36 && yF().type.intValue() == 2) {
                return aNn;
            }
            if (yF() != null && getThreadType() == 36 && yF().type.intValue() == 1) {
                return aNo;
            }
            if (zI()) {
                return aNk.get() ? aOp : aNb;
            } else if (zy() && zx() == 1) {
                return aNk.get() ? aOw : aNb;
            } else if (zy() && zx() == 2) {
                return aNk.get() ? aOo : aNb;
            } else if (isLinkThread()) {
                return aNc;
            } else {
                if (yX()) {
                    return aNd;
                }
                return aNb;
            }
        }
    }

    public boolean zI() {
        return yB() != null && getThreadType() == 41 && yQ() == 1 && zv() == 2;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public void j(ArrayList<n> arrayList) {
        if (this.aNM == 1) {
            this.aKx = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aKx = 0;
        } else {
            this.aKx = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.xk() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.xk().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aKx = next.xl();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean zJ() {
        return this.threadType == 41;
    }

    public boolean zK() {
        return this.threadType == 48;
    }

    public boolean zL() {
        return this.aOx;
    }

    public void aT(boolean z) {
        this.aOx = z;
    }

    public String zM() {
        return this.aOy;
    }

    public m zN() {
        return this.aOb;
    }

    public boolean zO() {
        return yQ() == 1 || yP() == 1 || yO() == 1 || zy() || this.aOz == 1 || yX() || zh() != null || zg() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || zK() || yW();
    }

    public void zP() {
        if (this.aNV == 0) {
            this.aNV = 1;
        }
    }

    public boolean zQ() {
        return this.aOD;
    }

    public void aU(boolean z) {
        this.aOJ = z;
    }

    public boolean zR() {
        return this.aOJ;
    }

    public void eV(int i) {
        this.aOK = i + 1;
    }

    public int zS() {
        return this.aOK;
    }

    public List<ReportInfo> zT() {
        return this.aOL;
    }

    public boolean zU() {
        return this.aOE;
    }

    public void aV(boolean z) {
        this.aOE = z;
    }

    public bj zV() {
        return this.aNS;
    }

    public void a(bj bjVar) {
        this.aNS = bjVar;
    }

    public void eW(int i) {
        if (this.aNS != null) {
            this.aNS.mCurrentPage = i;
        }
    }

    public boolean zW() {
        return getThreadType() == 49;
    }

    public boolean zX() {
        return getThreadType() == 40;
    }

    public boolean zY() {
        return getThreadType() == 50;
    }

    public boolean zZ() {
        return getThreadType() == 60;
    }

    public boolean Aa() {
        return getThreadType() == 40 && zV() != null && zV().channelId > 0;
    }

    public int Ab() {
        return this.aOQ;
    }

    public void setSmartFrsPosition(int i) {
        this.aOQ = i;
    }

    public SparseArray<String> xM() {
        return this.aLY;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aLY = sparseArray;
    }

    public String Ac() {
        return this.mRecomSource;
    }

    public boolean Ad() {
        return this.aOR;
    }

    public int Ae() {
        return this.aOS;
    }

    public int Af() {
        return this.aOT;
    }

    public void eX(int i) {
        this.aOT = i;
    }

    public void eY(int i) {
        this.aOS = i;
    }

    public long Ag() {
        return this.aOV;
    }

    public void w(long j) {
        this.aOV = j;
    }

    public PostData Ah() {
        return this.aOU;
    }

    public ad Ai() {
        return this.aOW;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aNM == 1) {
            g = g(this.aNB, false);
            a = cQ(this.aNB);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aNA = spannableStringBuilder;
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
            g(this.aNB, false);
            cQ = cQ(this.aNB);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cQ);
        this.aNA = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<k.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<k.a> arrayList = new ArrayList<>();
        boolean yV = yV();
        if (z2) {
            if (z) {
                if (yV && !zG()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if (yQ() == 1 || getThreadType() == 33 || (yS() != null && yS().Ap() != 0)) {
                    if (yB() != null && zJ()) {
                        if (zv() == 2) {
                            arrayList.add(new k.a(d.j.interview_live));
                        }
                    } else if (!yV) {
                        arrayList.add(new k.a(d.j.photo_live_tips));
                    }
                }
                if (yO() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (yP() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (zJ()) {
                    arrayList.add(aON.get(zv()));
                }
                if (zy()) {
                    Integer num = aOM.get(new Point(zx(), zw()));
                    if (num != null) {
                        arrayList.add(new k.a(num.intValue(), d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (zK()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (zg() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
            } else {
                if (yV && yO() != 1 && !zG()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if ((yQ() == 1 || getThreadType() == 33) && !zJ() && !yV) {
                    arrayList.add(new k.a(d.j.photo_live_tips));
                }
                if (yP() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (yO() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (zJ() && yB() != null && zv() == 2) {
                    arrayList.add(new k.a(d.j.interview_live));
                }
                if (zy()) {
                    Integer num2 = aOM.get(new Point(zx(), zw()));
                    if (num2 != null) {
                        arrayList.add(new k.a(num2.intValue(), d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (this.aOz == 1) {
                    arrayList.add(new k.a(d.j.card_tbread_text));
                }
                if (zh() != null) {
                    arrayList.add(new k.a(d.j.send_app_code_gift, d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (zg() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0108d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (zK()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
                if (z3 && zW()) {
                    arrayList.add(new k.a(d.j.ala_live));
                }
                if (Aa()) {
                    arrayList.add(new k.a(d.j.frs_channel_tip));
                } else if (z3 && zY()) {
                    arrayList.add(new k.a(d.j.live_record));
                } else if (zX()) {
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
        this.aNC = arrayList;
    }
}
