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
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.video.ActivityItemData;
import com.sina.weibo.sdk.constant.WBConstants;
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
    private SpannableStringBuilder aOI;
    public int aOM;
    private int aON;
    private int aOQ;
    private String aOT;
    private int aOU;
    private String aOV;
    private int aOX;
    private VideoInfo aOZ;
    public List<TwAnchorProfitItem> aPA;
    private SkinInfo aPD;
    private boolean aPF;
    private String aPG;
    private boolean aPL;
    private boolean aPM;
    public String aPO;
    public long aPP;
    public String aPR;
    private List<ReportInfo> aPU;
    private bj aPa;
    private AlaInfoData aPb;
    private long aPc;
    private m aPj;
    private LiveCoverStatus aPp;
    private long aPq;
    public TwZhiBoUser aPz;
    private boolean aQa;
    private int aQc;
    private long aQe;
    private ad aQf;
    public c aQh;
    private MediaData aQi;
    public int aQj;
    public OriginalThreadInfo aQl;
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
    public static final BdUniqueId aOi = BdUniqueId.gen();
    public static final BdUniqueId aOj = BdUniqueId.gen();
    public static final BdUniqueId aOk = BdUniqueId.gen();
    public static final BdUniqueId aOl = BdUniqueId.gen();
    public static final BdUniqueId aOm = BdUniqueId.gen();
    public static final BdUniqueId aOn = BdUniqueId.gen();
    public static final BdUniqueId aOo = BdUniqueId.gen();
    public static final BdUniqueId aOp = BdUniqueId.gen();
    public static final BdUniqueId aOq = BdUniqueId.gen();
    public static final BdUniqueId aOr = BdUniqueId.gen();
    public static AtomicBoolean aOs = new AtomicBoolean(false);
    public static AtomicBoolean aOt = new AtomicBoolean(false);
    public static AtomicBoolean aOu = new AtomicBoolean(false);
    public static final BdUniqueId aOv = BdUniqueId.gen();
    public static final BdUniqueId aOw = BdUniqueId.gen();
    public static final BdUniqueId aOx = BdUniqueId.gen();
    private static HashMap<Point, Integer> aPk = new HashMap<>();
    private static HashMap<Integer, Integer> aPl = new HashMap<>();
    public static final BdUniqueId aPw = BdUniqueId.gen();
    public static final BdUniqueId aPx = BdUniqueId.gen();
    public static final BdUniqueId aPE = BdUniqueId.gen();
    private static HashMap<Point, Integer> aPV = new HashMap<>();
    private static SparseArray<j.a> aPW = new SparseArray<>(3);
    public int aOy = 1;
    private String aOP = null;
    private int aLG = 0;
    public int aPd = 0;
    private String aPe = "";
    private String aPm = "";
    public boolean aPQ = true;
    public boolean aPX = false;
    public boolean aPY = false;
    private int aPZ = -1;
    private SparseArray<String> aNg = null;
    public boolean aQg = false;
    public int aQo = 0;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aOz = 0;
    private int view_num = 0;
    private String last_time = null;
    private long aOA = 0;
    private int aOB = 0;
    private int aOC = 0;
    private int aOD = 0;
    private bh aOE = new bh();
    private MetaData aOF = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aOK = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aOL = new ArrayList<>();
    private int aOG = 0;
    private int aOH = 0;
    private String ad_url = null;
    private String aOJ = null;
    private String from = null;
    private int aOO = 0;
    private PraiseData aOR = new PraiseData();
    private AnchorInfoData aOS = new AnchorInfoData();
    private long time = 0;
    private int aOW = 0;
    private ArrayList<a> aPg = new ArrayList<>();
    private bn aPh = null;
    private d aPi = null;
    private int aPn = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> aOY = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aPo = null;
    private int aPf = 0;
    private PollInfo aPr = null;
    private boolean aPs = false;
    private boolean aPt = false;
    private int aPu = 0;
    private boolean aPv = false;
    private int anchorLevel = 0;
    public int aPH = 0;
    public j aPI = new j();
    private List<PbContent> aPJ = new ArrayList();
    private List<PbContent> aPK = new ArrayList();
    private String category_name = null;
    private bb aPy = new bb();
    private ArrayList<com.baidu.tbadk.data.c> aPB = new ArrayList<>();
    private PushStatusData aPC = new PushStatusData();
    public boolean aPS = false;
    public int aPT = -1;
    private int aQb = 0;
    private PostData aQd = new PostData();
    private int aPN = 0;
    public int aQk = 0;
    private String tieba_game_information_source = "";
    public String aQn = "";
    public String aQm = "";

    static {
        aPk.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        aPk.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        aPk.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        aPk.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        aPk.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        aPk.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        aPk.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        aPk.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        aPV.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        aPV.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        aPV.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        aPV.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        aPV.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        aPV.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        aPV.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        aPV.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        aPl.put(1, Integer.valueOf(d.f.label_interview_no));
        aPl.put(2, Integer.valueOf(d.f.label_interview_live));
        aPl.put(3, Integer.valueOf(d.f.label_interview_off));
        aPW.put(1, new j.a(d.j.interview_live_status_not_start, d.C0141d.cp_other_b, d.f.pic_dot_title_red));
        aPW.put(2, new j.a(d.j.interview_live_status_ing, d.C0141d.cp_other_c, d.f.pic_dot_title_green));
        aPW.put(3, new j.a(d.j.interview_live_status_over, d.C0141d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.aON = 0;
        this.aOX = 0;
        this.aPq = 0L;
        this.aQj = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.aPq = 0L;
        this.aOX = 0;
        this.aON = 0;
        this.aQj = 0;
    }

    public boolean yU() {
        return this.aON == 1;
    }

    public bb yV() {
        return this.aPy;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void eM(int i) {
        this.anchorLevel = i;
    }

    public int yW() {
        return this.aOX;
    }

    public int yX() {
        return this.aPN;
    }

    public void eN(int i) {
        this.aPN = i;
    }

    public void eO(int i) {
        this.aPu = i;
    }

    public int yY() {
        return this.aPu;
    }

    public PollInfo yZ() {
        return this.aPr;
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

    public long za() {
        return this.aPc;
    }

    public String zb() {
        return this.aOT;
    }

    public PraiseData zc() {
        return this.aOR;
    }

    public void a(PraiseData praiseData) {
        this.aOR = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String zd() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cV(String str) {
        this.tid = str;
    }

    public String ze() {
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

    public int zf() {
        return this.reply_num;
    }

    public int zg() {
        return this.view_num;
    }

    public void eQ(int i) {
        this.view_num = i;
    }

    public long zh() {
        return this.aOA;
    }

    public void v(long j) {
        this.aOA = j;
    }

    public int zi() {
        return this.aOB;
    }

    public void eR(int i) {
        this.aOB = i;
    }

    public int zj() {
        return this.aOC;
    }

    public void eS(int i) {
        this.aOC = i;
    }

    public int zk() {
        return this.aOD;
    }

    public List<PbContent> zl() {
        return this.aPJ;
    }

    public bh zm() {
        return this.aOE;
    }

    public MetaData zn() {
        return this.aOF;
    }

    public UserTbVipInfoData zo() {
        if (this.aOF == null) {
            return null;
        }
        return this.aOF.getUserTbVipInfoData();
    }

    public boolean zp() {
        return this.is_god != 0;
    }

    public boolean zq() {
        return this.is_god == 1;
    }

    public boolean zr() {
        return (this.aOF == null || this.aOF.getGodUserData() == null || this.aOF.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean zs() {
        return (this.aOF == null || this.aOF.getGodUserData() == null || this.aOF.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aOF = metaData;
    }

    public String zt() {
        return this.forum_name;
    }

    public void cZ(String str) {
        this.forum_name = str;
    }

    public int zu() {
        return this.aOH;
    }

    public String zv() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aOJ;
    }

    public void da(String str) {
        this.aOJ = str;
    }

    public String f(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aPK == null || this.aPK.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aPK.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aPK.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aPJ == null || (size = this.aPJ.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aPJ.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString db(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(f(str, true));
        if (this.aPK != null && (size = this.aPK.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aPK.get(i2);
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
                                bd.this.df(pbContent.link);
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

    public int zw() {
        return this.aOO;
    }

    public void eT(int i) {
        this.aOO = i;
    }

    public String zx() {
        return this.aOP;
    }

    public void dc(String str) {
        this.aOP = str;
    }

    public ArrayList<MediaData> zy() {
        return this.aOK;
    }

    public ArrayList<a> zz() {
        return this.aPg;
    }

    public void i(ArrayList<a> arrayList) {
        this.aPg = arrayList;
    }

    public bn zA() {
        return this.aPh;
    }

    public d zB() {
        return this.aPi;
    }

    public ArrayList<VoiceData.VoiceModel> zC() {
        return this.aOL;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int zD() {
        return this.aOU;
    }

    public void eU(int i) {
        this.aOU = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String zE() {
        return this.aPe;
    }

    public VideoInfo zF() {
        return this.aOZ;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aPb = alaInfoData;
    }

    public AlaInfoData zG() {
        return this.aPb;
    }

    public String getPhotoLiveCover() {
        return this.aPm;
    }

    public void setPhotoLiveCover(String str) {
        this.aPm = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> zH() {
        return this.aOY;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.aOY.clear();
        this.aOY.addAll(arrayList);
    }

    public PushStatusData zI() {
        return this.aPC;
    }

    public SkinInfo zJ() {
        return this.aPD;
    }

    public long zK() {
        return this.aPP;
    }

    public boolean zL() {
        return this.aPQ;
    }

    public String zM() {
        return this.aPR;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aOV = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aON = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aPc = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aOz = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aOA = threadInfo.last_time_int.intValue();
                this.aOB = threadInfo.is_top.intValue();
                this.aOC = threadInfo.is_good.intValue();
                this.aOD = threadInfo.is_livepost.intValue();
                this.aOE.a(threadInfo.topic);
                this.aOF.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aOG = threadInfo.has_commented.intValue();
                this.aOH = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aOZ = threadInfo.video_info;
                this.aPb = new AlaInfoData();
                this.aPb.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aOO = threadInfo.collect_status.intValue();
                this.aOP = threadInfo.collect_mark_pid;
                this.aOQ = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aOT = threadInfo.first_post_id + "";
                this.aPe = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aOU = threadInfo.is_ntitle.intValue();
                this.aOW = threadInfo.is_activity.intValue();
                this.aQb = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aQc = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aQe = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aOX = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aPL = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aPJ = threadInfo.rich_title;
                this.aPK = threadInfo.rich_abstract;
                this.aOM = threadInfo.is_godthread_recommend.intValue();
                if ((this.aOF == null || this.aOF.getUserId() == null || this.aOF.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aOF = metaData;
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
                this.aOJ = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aOK.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aOZ = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aPa = new bj();
                    this.aPa.a(threadInfo.video_channel_info);
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
                        this.aOL.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aPg.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aPh = new bn();
                    this.aPh.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aPi = new d();
                    this.aPi.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aPj = new m();
                    this.aPj.a(threadInfo.cartoon_info);
                }
                this.aOR.setUserMap(this.userMap);
                this.aOR.parserProtobuf(threadInfo.zan);
                this.aOS.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aOR.setTitle(this.title);
                } else {
                    this.aOR.setTitle(this.aOJ);
                }
                this.aPm = threadInfo.livecover_src;
                this.aPn = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aPf = threadInfo.post_num.intValue();
                this.aPq = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.ho(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.fL(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aOY.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aPo = noticeInfo.notice;
                    }
                    this.aPu = zhiBoInfoTW.copythread_remind.intValue();
                    this.aPs = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aPt = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aPm)) {
                        this.aPm = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aPz = zhiBoInfoTW.user.tw_anchor_info;
                        this.aPA = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aPp = threadInfo.twzhibo_info.livecover_status;
                    this.aPq = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aPr = threadInfo.poll_info;
                this.aPv = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aPy.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aPB.add(cVar);
                    }
                }
                this.aPC.parserProtobuf(threadInfo.push_status);
                this.aPG = threadInfo.lego_card;
                this.aPD = threadInfo.skin_info;
                this.aPH = threadInfo.is_book_chapter.intValue();
                this.aPI.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.aPR = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.aPO = threadInfo.recom_extra;
                this.aPP = threadInfo.last_read_pid.longValue();
                this.aPQ = threadInfo.cheak_repeat.intValue() == 1;
                this.aPU = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aQd.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.D(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.aNg = sparseArray;
                }
                this.aQa = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aQf = new ad();
                    this.aQf.a(threadInfo.link_info);
                }
                this.aQg = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aQh = new c();
                    this.aQh.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aQi = new MediaData();
                    this.aQi.parserProtobuf(threadInfo.pic_info);
                }
                this.aPN = threadInfo.is_called.intValue();
                this.aQj = threadInfo.middle_page_num.intValue();
                this.aQk = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.aQm = threadInfo.star_rank_icon.icon_pic_url;
                    this.aQn = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.aQl = new OriginalThreadInfo();
                    this.aQl.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.aQl = new OriginalThreadInfo();
                    this.aQl.parser(threadInfo.origin_thread_info);
                } else {
                    this.aQl = null;
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
                this.mCreateTime = jSONObject.optLong(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, 0L) * 1000;
                this.aPc = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aOz = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.aOA = jSONObject.optLong("last_time_int", 0L);
                this.aOB = jSONObject.optInt("is_top", 0);
                this.aOC = jSONObject.optInt("is_good", 0);
                this.aOD = jSONObject.optInt("is_livepost", 0);
                this.aOE.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aOF.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aOG = jSONObject.optInt("has_commented", 0);
                this.aOH = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aOO = jSONObject.optInt("collect_status");
                this.aOP = jSONObject.optString("collect_mark_pid");
                this.aOQ = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aQb = jSONObject.optInt("agree_num");
                this.aQe = jSONObject.optLong("share_num");
                this.aOT = jSONObject.optString("first_post_id", "0");
                this.aPe = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.aOU = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.aQc = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aPy.parserJson(optJSONObject2);
                }
                if ((this.aOF == null || this.aOF.getUserId() == null) && this.userMap != null) {
                    this.aOF = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aPb = new AlaInfoData();
                this.aPb.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aOJ = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aOK.add(mediaData);
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
                        this.aOL.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aPg.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aPh = new bn();
                    this.aPh.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aPi = new d();
                    this.aPi.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aPj = new m();
                    this.aPj.parserJson(optJSONObject6);
                }
                this.aOR.setUserMap(this.userMap);
                this.aOR.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aOS.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aOR.setTitle(this.title);
                } else {
                    this.aOR.setTitle(this.aOJ);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aPy.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aPB.add(cVar);
                    }
                }
                this.aPH = jSONObject.optInt("is_book_chapter", 0);
                this.aPI.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.aPR = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.aPO = jSONObject.optString("recom_extra");
                this.aPP = jSONObject.optLong("last_read_pid");
                this.aPQ = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aPa = new bj();
                    this.aPa.i(optJSONObject8);
                }
                this.aQa = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aQf = new ad();
                    this.aQf.parserJson(optJSONObject9);
                }
                this.aQg = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aQh = new c();
                    this.aQh.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aQi = new MediaData();
                    this.aQi.parserJson(optJSONObject11);
                }
                this.aPN = jSONObject.optInt("is_called", 0);
                this.aQj = jSONObject.optInt("middle_page_num", 0);
                this.aQk = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject12 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject12.optString("video_md5");
                    builder.video_url = optJSONObject12.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    builder.video_duration = new Integer(optJSONObject12.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
                    builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                    builder.video_type = new Integer(optJSONObject12.optInt("video_type", 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    this.aOZ = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.aQl = new OriginalThreadInfo();
                        this.aQl.parserJson(optJSONObject13);
                        return;
                    }
                    this.aQl = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder zN() {
        return this.aOI;
    }

    public boolean zO() {
        return zi() != 0;
    }

    public int zP() {
        if (this.aPy != null) {
            long yQ = this.aPy.yQ();
            long yR = this.aPy.yR();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < yQ) {
                return 1;
            }
            if (currentTimeMillis > yR) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int zQ() {
        if (zS() && this.aPg.size() >= 1) {
            a aVar = this.aPg.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int xF = aVar.xF();
            int xG = aVar.xG();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < xF) {
                return 4;
            }
            return currentTimeMillis > xG ? 2 : 1;
        }
        return -1;
    }

    public int zR() {
        if (!zS() || this.aPg.size() < 1 || this.aPg.get(0) == null) {
            return -1;
        }
        return this.aPg.get(0).xE();
    }

    public boolean zS() {
        return this.aOW == 1;
    }

    public String getActUrl() {
        return (!zS() || this.aPg.size() < 1 || this.aPg.get(0) == null) ? "" : this.aPg.get(0).getUrl();
    }

    private com.baidu.adp.widget.b dd(String str) {
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_cont_f_1));
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
        String f = f(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && zU()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (zi() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (zi() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (zk() == 1 || this.aOE.AI() != 0) {
                if (yV() != null && getThreadType() == 41) {
                    if (zP() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && Ad()) {
                Integer num = aPl.get(Integer.valueOf(zP()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (zj() == 1 && !zO() && aOm != getType() && aOr != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (getType() == aOv || getType() == aOw) {
                arrayList.add(Integer.valueOf(d.f.icon_vote_blue));
            }
            if (this.aOS != null && this.aOS.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (zu() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = aPk.get(new Point(zR(), zQ()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (zA() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (zB() != null) {
                arrayList.add(Integer.valueOf(d.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = dd(this.category_name);
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
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aOy));
                spannableString.setSpan(mVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(f + " "));
        if (a != null) {
            SpannableStringBuilder c = !z && zi() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aOI = spannableStringBuilder;
    }

    public boolean zT() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || zF() == null || zF().video_type.intValue() == 0) {
            return i == 1 && zF() != null && (zF().video_type.intValue() == 1 || zF().video_type.intValue() == 12 || zF().video_type.intValue() == 13);
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
        if (zn() != null) {
            if (zn().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.he));
            } else if (zn().getGender() == 2) {
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

    private SpannableStringBuilder c(String str, ArrayList<j.a> arrayList) {
        if (Aa() || !zp() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new j.a(d.j.god_title));
        }
        return com.baidu.tieba.card.j.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean zU() {
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
        String f = f(this.title, false);
        SpannableString a = a(new SpannableString(f + " "));
        if (z) {
            spannableStringBuilder = a(f, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aOI = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<j.a> a = a(z, z2, z3, z4);
        if (a == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.j.a((Context) TbadkCoreApplication.getInst(), str, a, false);
        if (a.size() > 0) {
            if (a2 == null) {
                a2 = new SpannableStringBuilder();
            }
            if (this.aOU == 1) {
                this.aOI = a2;
                return a2;
            }
        } else if (this.aOU == 1) {
            this.aOI = new SpannableStringBuilder();
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
        if (this.aPJ != null && this.aPJ.size() > 0) {
            int size = this.aPJ.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aPJ.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (Aa()) {
                            if (pbContent.text != null) {
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, de(pbContent.text)) { // from class: com.baidu.tbadk.core.data.bd.2
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view) {
                                        bd.this.df(getLink());
                                    }
                                }, i3, pbContent.text.length() + i3, 33);
                            }
                        } else {
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bd.3
                                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    bd.this.df(pbContent.link);
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

    private String de(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData zV() {
        if (this.aPJ != null && this.aPJ.size() > 0) {
            int size = this.aPJ.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.aPJ.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && Aa() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = de(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void df(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, str));
        }
    }

    public void zW() {
        g(false, false);
    }

    public void zX() {
        g(false, true);
    }

    public AnchorInfoData zY() {
        return this.aOS;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean zZ() {
        return this.threadType == 36;
    }

    public boolean Aa() {
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
        ArrayList<MediaData> zy = zy();
        if (zy == null || zO()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zy.size() || i2 >= 3) {
                break;
            }
            if (zy.get(i2) != null && zy.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(zy.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = zy.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = zy.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aOZ != null && !StringUtils.isNull(this.aOZ.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aOZ.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aOF != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aOF.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean Ab() {
        String userId;
        return this.aOF == null || (userId = this.aOF.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        int zi = zi();
        if (this.aPb != null && this.threadType == 60) {
            return aOp;
        }
        if (this.aPb != null && this.threadType == 49) {
            return aOn;
        }
        if (this.threadType == 51) {
            return aOo;
        }
        if (zi == 2 || zi == 1) {
            return aOi;
        }
        if (this.aOZ != null && Ak()) {
            return aOx;
        }
        if (this.aOZ != null) {
            if (zr()) {
                return aOr;
            }
            return aOm;
        } else if (this.isShareThread) {
            return aOq;
        } else {
            if (yZ() != null && getThreadType() == 36 && yZ().type.intValue() == 2) {
                return aOv;
            }
            if (yZ() != null && getThreadType() == 36 && yZ().type.intValue() == 1) {
                return aOw;
            }
            if (Ac()) {
                return aOs.get() ? aPx : aOj;
            } else if (zS() && zR() == 1) {
                return aOs.get() ? aPE : aOj;
            } else if (isLinkThread()) {
                return aOk;
            } else {
                if (zr()) {
                    return aOl;
                }
                return aOj;
            }
        }
    }

    public boolean Ac() {
        return yV() != null && getThreadType() == 41 && zk() == 1 && zP() == 2;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public void j(ArrayList<n> arrayList) {
        if (this.aOU == 1) {
            this.aLG = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aLG = 0;
        } else {
            this.aLG = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.xQ() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.xQ().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aLG = next.xR();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean Ad() {
        return this.threadType == 41;
    }

    public boolean Ae() {
        return this.aPF;
    }

    public void aW(boolean z) {
        this.aPF = z;
    }

    public String Af() {
        return this.aPG;
    }

    public m Ag() {
        return this.aPj;
    }

    public boolean Ah() {
        return zk() == 1 || zj() == 1 || zi() == 1 || zS() || this.aPH == 1 || zr() || zB() != null || zA() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || zq();
    }

    public void Ai() {
        if (this.aPd == 0) {
            this.aPd = 1;
        }
    }

    public boolean Aj() {
        return this.aPL;
    }

    public void aX(boolean z) {
        this.aPS = z;
    }

    public boolean Ak() {
        return this.aPS;
    }

    public void eV(int i) {
        this.aPT = i + 1;
    }

    public int Al() {
        return this.aPT;
    }

    public List<ReportInfo> Am() {
        return this.aPU;
    }

    public boolean An() {
        return this.aPM;
    }

    public void aY(boolean z) {
        this.aPM = z;
    }

    public bj Ao() {
        return this.aPa;
    }

    public void a(bj bjVar) {
        this.aPa = bjVar;
    }

    public void eW(int i) {
        if (this.aPa != null) {
            this.aPa.mCurrentPage = i;
        }
    }

    public boolean Ap() {
        return getThreadType() == 49;
    }

    public boolean Aq() {
        return getThreadType() == 40;
    }

    public boolean Ar() {
        return getThreadType() == 50;
    }

    public boolean As() {
        return getThreadType() == 60;
    }

    public boolean At() {
        return getThreadType() == 40 && Ao() != null && Ao().channelId > 0;
    }

    public int Au() {
        return this.aPZ;
    }

    public void setSmartFrsPosition(int i) {
        this.aPZ = i;
    }

    public SparseArray<String> yo() {
        return this.aNg;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aNg = sparseArray;
    }

    public String Av() {
        return this.mRecomSource;
    }

    public boolean Aw() {
        return this.aQa;
    }

    public int Ax() {
        return this.aQb;
    }

    public int Ay() {
        return this.aQc;
    }

    public void eX(int i) {
        this.aQc = i;
    }

    public void eY(int i) {
        this.aQb = i;
    }

    public long Az() {
        return this.aQe;
    }

    public void w(long j) {
        this.aQe = j;
    }

    public PostData AA() {
        return this.aQd;
    }

    public ad AB() {
        return this.aQf;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        String f;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aOU == 1) {
            f = f(this.aOJ, false);
            a = db(this.aOJ);
        } else {
            f = f(this.title, false);
            a = a(new SpannableString(f + " "));
        }
        if (z) {
            spannableStringBuilder = a(f, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aOI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder i(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder j(boolean z, boolean z2) {
        SpannableString db;
        if (!StringUtils.isNull(this.title)) {
            db = a(new SpannableString(f(this.title, false) + " "));
        } else {
            f(this.aOJ, false);
            db = db(this.aOJ);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(db);
        this.aOI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    private ArrayList<j.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<j.a> arrayList = new ArrayList<>();
        boolean zp = zp();
        if (z2) {
            if (z) {
                if (zp && !Aa()) {
                    arrayList.add(new j.a(d.j.god_title));
                }
                if (zk() == 1 || getThreadType() == 33 || (zm() != null && zm().AI() != 0)) {
                    if (yV() != null && Ad()) {
                        if (zP() == 2) {
                            arrayList.add(new j.a(d.j.interview_live));
                        }
                    } else if (!zp) {
                        arrayList.add(new j.a(d.j.photo_live_tips));
                    }
                }
                if (zi() == 1) {
                    arrayList.add(new j.a(d.j.top));
                }
                if (zj() == 1) {
                    arrayList.add(new j.a(d.j.good));
                }
                if (Ad()) {
                    arrayList.add(aPW.get(zP()));
                }
                if (zS()) {
                    Integer num = aPV.get(new Point(zR(), zQ()));
                    if (num != null) {
                        arrayList.add(new j.a(num.intValue(), d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new j.a(d.j.card_promotion_text));
                    }
                }
                if (zA() != null) {
                    arrayList.add(new j.a(d.j.card_promotion_text, d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new j.a(getCategory()));
                }
            } else {
                if (zp && zi() != 1 && !Aa()) {
                    arrayList.add(new j.a(d.j.god_title));
                }
                if ((zk() == 1 || getThreadType() == 33) && !Ad() && !zp) {
                    arrayList.add(new j.a(d.j.photo_live_tips));
                }
                if (zj() == 1) {
                    arrayList.add(new j.a(d.j.good));
                }
                if (zi() == 1) {
                    arrayList.add(new j.a(d.j.top));
                }
                if (Ad() && yV() != null && zP() == 2) {
                    arrayList.add(new j.a(d.j.interview_live));
                }
                if (zS()) {
                    Integer num2 = aPV.get(new Point(zR(), zQ()));
                    if (num2 != null) {
                        arrayList.add(new j.a(num2.intValue(), d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new j.a(d.j.card_promotion_text));
                    }
                }
                if (this.aPH == 1) {
                    arrayList.add(new j.a(d.j.card_tbread_text));
                }
                if (zB() != null) {
                    arrayList.add(new j.a(d.j.send_app_code_gift, d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (zA() != null) {
                    arrayList.add(new j.a(d.j.card_promotion_text, d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.am.isEmpty(getCategory())) {
                    arrayList.add(new j.a(getCategory()));
                }
                if (z3 && Ap()) {
                    arrayList.add(new j.a(d.j.ala_live));
                }
                if (At()) {
                    arrayList.add(new j.a(d.j.frs_channel_tip));
                } else if (z3 && Ar()) {
                    arrayList.add(new j.a(d.j.live_record));
                } else if (Aq()) {
                    arrayList.add(new j.a(d.j.video_title_str));
                }
                if (z4) {
                    arrayList.add(new j.a(d.j.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void k(ArrayList<MediaData> arrayList) {
        this.aOK = arrayList;
    }
}
