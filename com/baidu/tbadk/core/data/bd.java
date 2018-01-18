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
    public int aNB;
    private int aNC;
    private int aNF;
    private String aNI;
    private int aNJ;
    private String aNK;
    private int aNM;
    private VideoInfo aNO;
    private bj aNP;
    private AlaInfoData aNQ;
    private long aNR;
    private m aNY;
    private SpannableStringBuilder aNx;
    private boolean aOA;
    private boolean aOB;
    public long aOD;
    public String aOF;
    private List<ReportInfo> aOI;
    private boolean aOO;
    private int aOQ;
    private long aOS;
    private ad aOT;
    public c aOV;
    private MediaData aOW;
    public int aOX;
    public OriginalThreadInfo aOZ;
    private LiveCoverStatus aOe;
    private long aOf;
    public TwZhiBoUser aOo;
    public List<TwAnchorProfitItem> aOp;
    private SkinInfo aOs;
    private boolean aOu;
    private String aOv;
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
    public static final BdUniqueId aMX = BdUniqueId.gen();
    public static final BdUniqueId aMY = BdUniqueId.gen();
    public static final BdUniqueId aMZ = BdUniqueId.gen();
    public static final BdUniqueId aNa = BdUniqueId.gen();
    public static final BdUniqueId aNb = BdUniqueId.gen();
    public static final BdUniqueId aNc = BdUniqueId.gen();
    public static final BdUniqueId aNd = BdUniqueId.gen();
    public static final BdUniqueId aNe = BdUniqueId.gen();
    public static final BdUniqueId aNf = BdUniqueId.gen();
    public static final BdUniqueId aNg = BdUniqueId.gen();
    public static AtomicBoolean aNh = new AtomicBoolean(false);
    public static AtomicBoolean aNi = new AtomicBoolean(false);
    public static AtomicBoolean aNj = new AtomicBoolean(false);
    public static final BdUniqueId aNk = BdUniqueId.gen();
    public static final BdUniqueId aNl = BdUniqueId.gen();
    public static final BdUniqueId aNm = BdUniqueId.gen();
    private static HashMap<Point, Integer> aNZ = new HashMap<>();
    private static HashMap<Integer, Integer> aOa = new HashMap<>();
    public static final BdUniqueId aOl = BdUniqueId.gen();
    public static final BdUniqueId aOm = BdUniqueId.gen();
    public static final BdUniqueId aOt = BdUniqueId.gen();
    private static HashMap<Point, Integer> aOJ = new HashMap<>();
    private static SparseArray<k.a> aOK = new SparseArray<>(3);
    public int aNn = 1;
    private String aNE = null;
    private int aKu = 0;
    public int aNS = 0;
    private String aNT = "";
    private String aOb = "";
    public boolean aOE = true;
    public boolean aOL = false;
    public boolean aOM = false;
    private int aON = -1;
    private SparseArray<String> aLV = null;
    public boolean aOU = false;
    public int aPa = 0;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aNo = 0;
    private int view_num = 0;
    private String last_time = null;
    private long aNp = 0;
    private int aNq = 0;
    private int aNr = 0;
    private int aNs = 0;
    private bh aNt = new bh();
    private MetaData aNu = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aNz = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aNA = new ArrayList<>();
    private int aNv = 0;
    private int aNw = 0;
    private String ad_url = null;
    private String aNy = null;
    private String from = null;
    private int aND = 0;
    private PraiseData aNG = new PraiseData();
    private AnchorInfoData aNH = new AnchorInfoData();
    private long time = 0;
    private int aNL = 0;
    private ArrayList<a> aNV = new ArrayList<>();
    private bn aNW = null;
    private d aNX = null;
    private int aOc = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> aNN = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aOd = null;
    private int aNU = 0;
    private PollInfo aOg = null;
    private boolean aOh = false;
    private boolean aOi = false;
    private int aOj = 0;
    private boolean aOk = false;
    private int anchorLevel = 0;
    public int aOw = 0;
    public j aOx = new j();
    private List<PbContent> aOy = new ArrayList();
    private List<PbContent> aOz = new ArrayList();
    private String category_name = null;
    private bb aOn = new bb();
    private ArrayList<com.baidu.tbadk.data.c> aOq = new ArrayList<>();
    private PushStatusData aOr = new PushStatusData();
    public boolean aOG = false;
    public int aOH = -1;
    private int aOP = 0;
    private PostData aOR = new PostData();
    private int aOC = 0;
    public int aOY = 0;
    private String tieba_game_information_source = "";

    static {
        aNZ.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        aNZ.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        aNZ.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        aNZ.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        aNZ.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        aNZ.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        aNZ.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        aNZ.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        aOJ.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        aOJ.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        aOJ.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        aOJ.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        aOJ.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        aOJ.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        aOJ.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        aOJ.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        aOa.put(1, Integer.valueOf(d.f.label_interview_no));
        aOa.put(2, Integer.valueOf(d.f.label_interview_live));
        aOa.put(3, Integer.valueOf(d.f.label_interview_off));
        aOK.put(1, new k.a(d.j.interview_live_status_not_start, d.C0107d.cp_other_b, d.f.pic_dot_title_red));
        aOK.put(2, new k.a(d.j.interview_live_status_ing, d.C0107d.cp_other_c, d.f.pic_dot_title_green));
        aOK.put(3, new k.a(d.j.interview_live_status_over, d.C0107d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.aNC = 0;
        this.aNM = 0;
        this.aOf = 0L;
        this.aOX = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.aOf = 0L;
        this.aNM = 0;
        this.aNC = 0;
        this.aOX = 0;
    }

    public boolean yz() {
        return this.aNC == 1;
    }

    public bb yA() {
        return this.aOn;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void eM(int i) {
        this.anchorLevel = i;
    }

    public int yB() {
        return this.aNM;
    }

    public int yC() {
        return this.aOC;
    }

    public void eN(int i) {
        this.aOC = i;
    }

    public void eO(int i) {
        this.aOj = i;
    }

    public int yD() {
        return this.aOj;
    }

    public PollInfo yE() {
        return this.aOg;
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

    public long yF() {
        return this.aNR;
    }

    public String yG() {
        return this.aNI;
    }

    public PraiseData yH() {
        return this.aNG;
    }

    public void a(PraiseData praiseData) {
        this.aNG = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String yI() {
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

    public String yJ() {
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

    public int yK() {
        return this.reply_num;
    }

    public int yL() {
        return this.view_num;
    }

    public void eQ(int i) {
        this.view_num = i;
    }

    public long yM() {
        return this.aNp;
    }

    public void v(long j) {
        this.aNp = j;
    }

    public int yN() {
        return this.aNq;
    }

    public void eR(int i) {
        this.aNq = i;
    }

    public int yO() {
        return this.aNr;
    }

    public void eS(int i) {
        this.aNr = i;
    }

    public int yP() {
        return this.aNs;
    }

    public List<PbContent> yQ() {
        return this.aOy;
    }

    public bh yR() {
        return this.aNt;
    }

    public MetaData yS() {
        return this.aNu;
    }

    public UserTbVipInfoData yT() {
        if (this.aNu == null) {
            return null;
        }
        return this.aNu.getUserTbVipInfoData();
    }

    public boolean yU() {
        return this.is_god != 0;
    }

    public boolean yV() {
        return this.is_god == 1;
    }

    public boolean yW() {
        return (this.aNu == null || this.aNu.getGodUserData() == null || this.aNu.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean yX() {
        return (this.aNu == null || this.aNu.getGodUserData() == null || this.aNu.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aNu = metaData;
    }

    public String yY() {
        return this.forum_name;
    }

    public void cO(String str) {
        this.forum_name = str;
    }

    public int yZ() {
        return this.aNw;
    }

    public String za() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aNy;
    }

    public void cP(String str) {
        this.aNy = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aOz == null || this.aOz.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aOz.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aOz.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aOy == null || (size = this.aOy.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aOy.get(i2);
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
        if (this.aOz != null && (size = this.aOz.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aOz.get(i2);
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

    public int zb() {
        return this.aND;
    }

    public void eT(int i) {
        this.aND = i;
    }

    public String zc() {
        return this.aNE;
    }

    public void cR(String str) {
        this.aNE = str;
    }

    public ArrayList<MediaData> zd() {
        return this.aNz;
    }

    public ArrayList<a> ze() {
        return this.aNV;
    }

    public void i(ArrayList<a> arrayList) {
        this.aNV = arrayList;
    }

    public bn zf() {
        return this.aNW;
    }

    public d zg() {
        return this.aNX;
    }

    public ArrayList<VoiceData.VoiceModel> zh() {
        return this.aNA;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int zi() {
        return this.aNJ;
    }

    public void eU(int i) {
        this.aNJ = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String zj() {
        return this.aNT;
    }

    public VideoInfo zk() {
        return this.aNO;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aNQ = alaInfoData;
    }

    public AlaInfoData zl() {
        return this.aNQ;
    }

    public String getPhotoLiveCover() {
        return this.aOb;
    }

    public void setPhotoLiveCover(String str) {
        this.aOb = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> zm() {
        return this.aNN;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.aNN.clear();
        this.aNN.addAll(arrayList);
    }

    public PushStatusData zn() {
        return this.aOr;
    }

    public SkinInfo zo() {
        return this.aOs;
    }

    public long zp() {
        return this.aOD;
    }

    public boolean zq() {
        return this.aOE;
    }

    public String zr() {
        return this.aOF;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aNK = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aNC = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aNR = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aNo = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aNp = threadInfo.last_time_int.intValue();
                this.aNq = threadInfo.is_top.intValue();
                this.aNr = threadInfo.is_good.intValue();
                this.aNs = threadInfo.is_livepost.intValue();
                this.aNt.a(threadInfo.topic);
                this.aNu.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aNv = threadInfo.has_commented.intValue();
                this.aNw = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aNO = threadInfo.video_info;
                this.aNQ = new AlaInfoData();
                this.aNQ.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aND = threadInfo.collect_status.intValue();
                this.aNE = threadInfo.collect_mark_pid;
                this.aNF = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aNI = threadInfo.first_post_id + "";
                this.aNT = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aNJ = threadInfo.is_ntitle.intValue();
                this.aNL = threadInfo.is_activity.intValue();
                this.aOP = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aOQ = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aOS = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aNM = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aOA = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aOy = threadInfo.rich_title;
                this.aOz = threadInfo.rich_abstract;
                this.aNB = threadInfo.is_godthread_recommend.intValue();
                if ((this.aNu == null || this.aNu.getUserId() == null || this.aNu.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNu = metaData;
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
                this.aNy = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aNz.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aNO = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aNP = new bj();
                    this.aNP.a(threadInfo.video_channel_info);
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
                        this.aNA.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aNV.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aNW = new bn();
                    this.aNW.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aNX = new d();
                    this.aNX.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aNY = new m();
                    this.aNY.a(threadInfo.cartoon_info);
                }
                this.aNG.setUserMap(this.userMap);
                this.aNG.parserProtobuf(threadInfo.zan);
                this.aNH.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aNG.setTitle(this.title);
                } else {
                    this.aNG.setTitle(this.aNy);
                }
                this.aOb = threadInfo.livecover_src;
                this.aOc = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aNU = threadInfo.post_num.intValue();
                this.aOf = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.hp(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.fu(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aNN.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aOd = noticeInfo.notice;
                    }
                    this.aOj = zhiBoInfoTW.copythread_remind.intValue();
                    this.aOh = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aOi = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aOb)) {
                        this.aOb = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aOo = zhiBoInfoTW.user.tw_anchor_info;
                        this.aOp = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aOe = threadInfo.twzhibo_info.livecover_status;
                    this.aOf = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aOg = threadInfo.poll_info;
                this.aOk = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aOn.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aOq.add(cVar);
                    }
                }
                this.aOr.parserProtobuf(threadInfo.push_status);
                this.aOv = threadInfo.lego_card;
                this.aOs = threadInfo.skin_info;
                this.aOw = threadInfo.is_book_chapter.intValue();
                this.aOx.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.aOF = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.aOD = threadInfo.last_read_pid.longValue();
                this.aOE = threadInfo.cheak_repeat.intValue() == 1;
                this.aOI = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aOR.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.D(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.aLV = sparseArray;
                }
                this.aOO = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aOT = new ad();
                    this.aOT.a(threadInfo.link_info);
                }
                this.aOU = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aOV = new c();
                    this.aOV.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aOW = new MediaData();
                    this.aOW.parserProtobuf(threadInfo.pic_info);
                }
                this.aOC = threadInfo.is_called.intValue();
                this.aOX = threadInfo.middle_page_num.intValue();
                this.aOY = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.origin_thread_info != null) {
                    this.aOZ = new OriginalThreadInfo();
                    this.aOZ.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.aOZ = new OriginalThreadInfo();
                    this.aOZ.parser(threadInfo.origin_thread_info);
                } else {
                    this.aOZ = null;
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
                this.aNR = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aNo = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.aNp = jSONObject.optLong("last_time_int", 0L);
                this.aNq = jSONObject.optInt("is_top", 0);
                this.aNr = jSONObject.optInt("is_good", 0);
                this.aNs = jSONObject.optInt("is_livepost", 0);
                this.aNt.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aNu.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aNv = jSONObject.optInt("has_commented", 0);
                this.aNw = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aND = jSONObject.optInt("collect_status");
                this.aNE = jSONObject.optString("collect_mark_pid");
                this.aNF = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aOP = jSONObject.optInt("agree_num");
                this.aOS = jSONObject.optLong("share_num");
                this.aNI = jSONObject.optString("first_post_id", "0");
                this.aNT = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.aNJ = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.aOQ = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aOn.parserJson(optJSONObject2);
                }
                if ((this.aNu == null || this.aNu.getUserId() == null) && this.userMap != null) {
                    this.aNu = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aNQ = new AlaInfoData();
                this.aNQ.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aNy = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aNz.add(mediaData);
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
                        this.aNA.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aNV.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aNW = new bn();
                    this.aNW.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aNX = new d();
                    this.aNX.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aNY = new m();
                    this.aNY.parserJson(optJSONObject6);
                }
                this.aNG.setUserMap(this.userMap);
                this.aNG.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aNH.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aNG.setTitle(this.title);
                } else {
                    this.aNG.setTitle(this.aNy);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aOn.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aOq.add(cVar);
                    }
                }
                this.aOw = jSONObject.optInt("is_book_chapter", 0);
                this.aOx.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.aOF = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.aOD = jSONObject.optLong("last_read_pid");
                this.aOE = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aNP = new bj();
                    this.aNP.e(optJSONObject8);
                }
                this.aOO = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aOT = new ad();
                    this.aOT.parserJson(optJSONObject9);
                }
                this.aOU = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aOV = new c();
                    this.aOV.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aOW = new MediaData();
                    this.aOW.parserJson(optJSONObject11);
                }
                this.aOC = jSONObject.optInt("is_called", 0);
                this.aOX = jSONObject.optInt("middle_page_num", 0);
                this.aOY = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.aNO = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.aOZ = new OriginalThreadInfo();
                        this.aOZ.parserJson(optJSONObject13);
                        return;
                    }
                    this.aOZ = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder zs() {
        return this.aNx;
    }

    public boolean zt() {
        return yN() != 0;
    }

    public int zu() {
        if (this.aOn != null) {
            long yu = this.aOn.yu();
            long yv = this.aOn.yv();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < yu) {
                return 1;
            }
            if (currentTimeMillis > yv) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int zv() {
        if (zx() && this.aNV.size() >= 1) {
            a aVar = this.aNV.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int wR = aVar.wR();
            int wS = aVar.wS();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < wR) {
                return 4;
            }
            return currentTimeMillis > wS ? 2 : 1;
        }
        return -1;
    }

    public int zw() {
        if (!zx() || this.aNV.size() < 1 || this.aNV.get(0) == null) {
            return -1;
        }
        return this.aNV.get(0).wQ();
    }

    public boolean zx() {
        return this.aNL == 1;
    }

    public String getActUrl() {
        return (!zx() || this.aNV.size() < 1 || this.aNV.get(0) == null) ? "" : this.aNV.get(0).getUrl();
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0107d.cp_cont_f_1));
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
            if (getThreadType() == 42 && zz()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (yN() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (yN() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (yP() == 1 || this.aNt.Ao() != 0) {
                if (yA() != null && getThreadType() == 41) {
                    if (zu() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && zI()) {
                Integer num = aOa.get(Integer.valueOf(zu()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (yO() == 1 && !zt() && aNb != getType() && aNg != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (getType() == aNk || getType() == aNl) {
                arrayList.add(Integer.valueOf(d.f.icon_vote_blue));
            }
            if (this.aNH != null && this.aNH.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (yZ() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            if (!z && zw() == 2) {
                arrayList.add(Integer.valueOf(d.f.label_frs_activity_shai));
            } else {
                Integer num2 = aNZ.get(new Point(zw(), zv()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (zf() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (zg() != null) {
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
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aNn));
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
            SpannableStringBuilder c = !z && yN() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aNx = spannableStringBuilder;
    }

    public boolean zy() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || zk() == null || zk().video_type.intValue() == 0) {
            return i == 1 && zk() != null && (zk().video_type.intValue() == 1 || zk().video_type.intValue() == 12 || zk().video_type.intValue() == 13);
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
        if (yS() != null) {
            if (yS().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.he));
            } else if (yS().getGender() == 2) {
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
        if (zF() || !yU() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new k.a(d.j.god_title));
        }
        return com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean zz() {
        return com.baidu.adp.lib.b.d.mz().an("isConveneThreadOpen") == 1;
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
        this.aNx = spannableStringBuilder;
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
            if (this.aNJ == 1) {
                this.aNx = a2;
                return a2;
            }
        } else if (this.aNJ == 1) {
            this.aNx = new SpannableStringBuilder();
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
        if (this.aOy != null && this.aOy.size() > 0) {
            int size = this.aOy.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aOy.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (zF()) {
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

    public ActivityItemData zA() {
        if (this.aOy != null && this.aOy.size() > 0) {
            int size = this.aOy.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.aOy.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && zF() && pbContent.text != null && pbContent.text.length() >= 3) {
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

    public void zB() {
        g(false, false);
    }

    public void zC() {
        g(false, true);
    }

    public AnchorInfoData zD() {
        return this.aNH;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean zE() {
        return this.threadType == 36;
    }

    public boolean zF() {
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
        ArrayList<MediaData> zd = zd();
        if (zd == null || zt()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zd.size() || i2 >= 3) {
                break;
            }
            if (zd.get(i2) != null && zd.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(zd.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = zd.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = zd.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aNO != null && !StringUtils.isNull(this.aNO.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aNO.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aNu != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aNu.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean zG() {
        String userId;
        return this.aNu == null || (userId = this.aNu.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        int yN = yN();
        if (this.aNQ != null && this.threadType == 60) {
            return aNe;
        }
        if (this.aNQ != null && this.threadType == 49) {
            return aNc;
        }
        if (this.threadType == 51) {
            return aNd;
        }
        if (yN == 2 || yN == 1) {
            return aMX;
        }
        if (this.aNO != null && zQ()) {
            return aNm;
        }
        if (this.aNO != null) {
            if (yW()) {
                return aNg;
            }
            return aNb;
        } else if (this.isShareThread) {
            return aNf;
        } else {
            if (yE() != null && getThreadType() == 36 && yE().type.intValue() == 2) {
                return aNk;
            }
            if (yE() != null && getThreadType() == 36 && yE().type.intValue() == 1) {
                return aNl;
            }
            if (zH()) {
                return aNh.get() ? aOm : aMY;
            } else if (zx() && zw() == 1) {
                return aNh.get() ? aOt : aMY;
            } else if (zx() && zw() == 2) {
                return aNh.get() ? aOl : aMY;
            } else if (isLinkThread()) {
                return aMZ;
            } else {
                if (yW()) {
                    return aNa;
                }
                return aMY;
            }
        }
    }

    public boolean zH() {
        return yA() != null && getThreadType() == 41 && yP() == 1 && zu() == 2;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public void j(ArrayList<n> arrayList) {
        if (this.aNJ == 1) {
            this.aKu = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aKu = 0;
        } else {
            this.aKu = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.xj() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.xj().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aKu = next.xk();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean zI() {
        return this.threadType == 41;
    }

    public boolean zJ() {
        return this.threadType == 48;
    }

    public boolean zK() {
        return this.aOu;
    }

    public void aS(boolean z) {
        this.aOu = z;
    }

    public String zL() {
        return this.aOv;
    }

    public m zM() {
        return this.aNY;
    }

    public boolean zN() {
        return yP() == 1 || yO() == 1 || yN() == 1 || zx() || this.aOw == 1 || yW() || zg() != null || zf() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || zJ() || yV();
    }

    public void zO() {
        if (this.aNS == 0) {
            this.aNS = 1;
        }
    }

    public boolean zP() {
        return this.aOA;
    }

    public void aT(boolean z) {
        this.aOG = z;
    }

    public boolean zQ() {
        return this.aOG;
    }

    public void eV(int i) {
        this.aOH = i + 1;
    }

    public int zR() {
        return this.aOH;
    }

    public List<ReportInfo> zS() {
        return this.aOI;
    }

    public boolean zT() {
        return this.aOB;
    }

    public void aU(boolean z) {
        this.aOB = z;
    }

    public bj zU() {
        return this.aNP;
    }

    public void a(bj bjVar) {
        this.aNP = bjVar;
    }

    public void eW(int i) {
        if (this.aNP != null) {
            this.aNP.mCurrentPage = i;
        }
    }

    public boolean zV() {
        return getThreadType() == 49;
    }

    public boolean zW() {
        return getThreadType() == 40;
    }

    public boolean zX() {
        return getThreadType() == 50;
    }

    public boolean zY() {
        return getThreadType() == 60;
    }

    public boolean zZ() {
        return getThreadType() == 40 && zU() != null && zU().channelId > 0;
    }

    public int Aa() {
        return this.aON;
    }

    public void setSmartFrsPosition(int i) {
        this.aON = i;
    }

    public SparseArray<String> xL() {
        return this.aLV;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aLV = sparseArray;
    }

    public String Ab() {
        return this.mRecomSource;
    }

    public boolean Ac() {
        return this.aOO;
    }

    public int Ad() {
        return this.aOP;
    }

    public int Ae() {
        return this.aOQ;
    }

    public void eX(int i) {
        this.aOQ = i;
    }

    public void eY(int i) {
        this.aOP = i;
    }

    public long Af() {
        return this.aOS;
    }

    public void w(long j) {
        this.aOS = j;
    }

    public PostData Ag() {
        return this.aOR;
    }

    public ad Ah() {
        return this.aOT;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aNJ == 1) {
            g = g(this.aNy, false);
            a = cQ(this.aNy);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aNx = spannableStringBuilder;
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
            g(this.aNy, false);
            cQ = cQ(this.aNy);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cQ);
        this.aNx = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<k.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<k.a> arrayList = new ArrayList<>();
        boolean yU = yU();
        if (z2) {
            if (z) {
                if (yU && !zF()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if (yP() == 1 || getThreadType() == 33 || (yR() != null && yR().Ao() != 0)) {
                    if (yA() != null && zI()) {
                        if (zu() == 2) {
                            arrayList.add(new k.a(d.j.interview_live));
                        }
                    } else if (!yU) {
                        arrayList.add(new k.a(d.j.photo_live_tips));
                    }
                }
                if (yN() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (yO() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (zI()) {
                    arrayList.add(aOK.get(zu()));
                }
                if (zx()) {
                    Integer num = aOJ.get(new Point(zw(), zv()));
                    if (num != null) {
                        arrayList.add(new k.a(num.intValue(), d.C0107d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (zJ()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (zf() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0107d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
            } else {
                if (yU && yN() != 1 && !zF()) {
                    arrayList.add(new k.a(d.j.god_title));
                }
                if ((yP() == 1 || getThreadType() == 33) && !zI() && !yU) {
                    arrayList.add(new k.a(d.j.photo_live_tips));
                }
                if (yO() == 1) {
                    arrayList.add(new k.a(d.j.good));
                }
                if (yN() == 1) {
                    arrayList.add(new k.a(d.j.top));
                }
                if (zI() && yA() != null && zu() == 2) {
                    arrayList.add(new k.a(d.j.interview_live));
                }
                if (zx()) {
                    Integer num2 = aOJ.get(new Point(zw(), zv()));
                    if (num2 != null) {
                        arrayList.add(new k.a(num2.intValue(), d.C0107d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new k.a(d.j.card_promotion_text));
                    }
                }
                if (this.aOw == 1) {
                    arrayList.add(new k.a(d.j.card_tbread_text));
                }
                if (zg() != null) {
                    arrayList.add(new k.a(d.j.send_app_code_gift, d.C0107d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (zf() != null) {
                    arrayList.add(new k.a(d.j.card_promotion_text, d.C0107d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (zJ()) {
                    arrayList.add(new k.a(d.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new k.a(getCategory()));
                }
                if (z3 && zV()) {
                    arrayList.add(new k.a(d.j.ala_live));
                }
                if (zZ()) {
                    arrayList.add(new k.a(d.j.frs_channel_tip));
                } else if (z3 && zX()) {
                    arrayList.add(new k.a(d.j.live_record));
                } else if (zW()) {
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
        this.aNz = arrayList;
    }
}
