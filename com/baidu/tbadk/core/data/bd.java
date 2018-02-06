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
    private SpannableStringBuilder aOT;
    public int aOX;
    private int aOY;
    private LiveCoverStatus aPA;
    private long aPB;
    public TwZhiBoUser aPK;
    public List<TwAnchorProfitItem> aPL;
    private SkinInfo aPO;
    private boolean aPQ;
    private String aPR;
    private boolean aPW;
    private boolean aPX;
    public String aPZ;
    private int aPb;
    private String aPe;
    private int aPf;
    private String aPg;
    private int aPi;
    private VideoInfo aPk;
    private bj aPl;
    private AlaInfoData aPm;
    private long aPn;
    private m aPu;
    public long aQa;
    public String aQc;
    private List<ReportInfo> aQf;
    private boolean aQl;
    private int aQn;
    private long aQp;
    private ad aQq;
    public c aQs;
    private MediaData aQt;
    public int aQu;
    public OriginalThreadInfo aQw;
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
    public static final BdUniqueId aOt = BdUniqueId.gen();
    public static final BdUniqueId aOu = BdUniqueId.gen();
    public static final BdUniqueId aOv = BdUniqueId.gen();
    public static final BdUniqueId aOw = BdUniqueId.gen();
    public static final BdUniqueId aOx = BdUniqueId.gen();
    public static final BdUniqueId aOy = BdUniqueId.gen();
    public static final BdUniqueId aOz = BdUniqueId.gen();
    public static final BdUniqueId aOA = BdUniqueId.gen();
    public static final BdUniqueId aOB = BdUniqueId.gen();
    public static final BdUniqueId aOC = BdUniqueId.gen();
    public static AtomicBoolean aOD = new AtomicBoolean(false);
    public static AtomicBoolean aOE = new AtomicBoolean(false);
    public static AtomicBoolean aOF = new AtomicBoolean(false);
    public static final BdUniqueId aOG = BdUniqueId.gen();
    public static final BdUniqueId aOH = BdUniqueId.gen();
    public static final BdUniqueId aOI = BdUniqueId.gen();
    private static HashMap<Point, Integer> aPv = new HashMap<>();
    private static HashMap<Integer, Integer> aPw = new HashMap<>();
    public static final BdUniqueId aPH = BdUniqueId.gen();
    public static final BdUniqueId aPI = BdUniqueId.gen();
    public static final BdUniqueId aPP = BdUniqueId.gen();
    private static HashMap<Point, Integer> aQg = new HashMap<>();
    private static SparseArray<j.a> aQh = new SparseArray<>(3);
    public int aOJ = 1;
    private String aPa = null;
    private int aLR = 0;
    public int aPo = 0;
    private String aPp = "";
    private String aPx = "";
    public boolean aQb = true;
    public boolean aQi = false;
    public boolean aQj = false;
    private int aQk = -1;
    private SparseArray<String> aNr = null;
    public boolean aQr = false;
    public int aQz = 0;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aOK = 0;
    private int view_num = 0;
    private String last_time = null;
    private long aOL = 0;
    private int aOM = 0;
    private int aON = 0;
    private int aOO = 0;
    private bh aOP = new bh();
    private MetaData aOQ = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aOV = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aOW = new ArrayList<>();
    private int aOR = 0;
    private int aOS = 0;
    private String ad_url = null;
    private String aOU = null;
    private String from = null;
    private int aOZ = 0;
    private PraiseData aPc = new PraiseData();
    private AnchorInfoData aPd = new AnchorInfoData();
    private long time = 0;
    private int aPh = 0;
    private ArrayList<a> aPr = new ArrayList<>();
    private bn aPs = null;
    private d aPt = null;
    private int aPy = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> aPj = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aPz = null;
    private int aPq = 0;
    private PollInfo aPC = null;
    private boolean aPD = false;
    private boolean aPE = false;
    private int aPF = 0;
    private boolean aPG = false;
    private int anchorLevel = 0;
    public int aPS = 0;
    public j aPT = new j();
    private List<PbContent> aPU = new ArrayList();
    private List<PbContent> aPV = new ArrayList();
    private String category_name = null;
    private bb aPJ = new bb();
    private ArrayList<com.baidu.tbadk.data.c> aPM = new ArrayList<>();
    private PushStatusData aPN = new PushStatusData();
    public boolean aQd = false;
    public int aQe = -1;
    private int aQm = 0;
    private PostData aQo = new PostData();
    private int aPY = 0;
    public int aQv = 0;
    private String tieba_game_information_source = "";
    public String aQy = "";
    public String aQx = "";

    static {
        aPv.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        aPv.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        aPv.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        aPv.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        aPv.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        aPv.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        aPv.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        aPv.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        aQg.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        aQg.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        aQg.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        aQg.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        aQg.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        aQg.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        aQg.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        aQg.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        aPw.put(1, Integer.valueOf(d.f.label_interview_no));
        aPw.put(2, Integer.valueOf(d.f.label_interview_live));
        aPw.put(3, Integer.valueOf(d.f.label_interview_off));
        aQh.put(1, new j.a(d.j.interview_live_status_not_start, d.C0140d.cp_other_b, d.f.pic_dot_title_red));
        aQh.put(2, new j.a(d.j.interview_live_status_ing, d.C0140d.cp_other_c, d.f.pic_dot_title_green));
        aQh.put(3, new j.a(d.j.interview_live_status_over, d.C0140d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.aOY = 0;
        this.aPi = 0;
        this.aPB = 0L;
        this.aQu = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.aPB = 0L;
        this.aPi = 0;
        this.aOY = 0;
        this.aQu = 0;
    }

    public boolean yU() {
        return this.aOY == 1;
    }

    public bb yV() {
        return this.aPJ;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void eM(int i) {
        this.anchorLevel = i;
    }

    public int yW() {
        return this.aPi;
    }

    public int yX() {
        return this.aPY;
    }

    public void eN(int i) {
        this.aPY = i;
    }

    public void eO(int i) {
        this.aPF = i;
    }

    public int yY() {
        return this.aPF;
    }

    public PollInfo yZ() {
        return this.aPC;
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
        return this.aPn;
    }

    public String zb() {
        return this.aPe;
    }

    public PraiseData zc() {
        return this.aPc;
    }

    public void a(PraiseData praiseData) {
        this.aPc = praiseData;
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
        return this.aOL;
    }

    public void v(long j) {
        this.aOL = j;
    }

    public int zi() {
        return this.aOM;
    }

    public void eR(int i) {
        this.aOM = i;
    }

    public int zj() {
        return this.aON;
    }

    public void eS(int i) {
        this.aON = i;
    }

    public int zk() {
        return this.aOO;
    }

    public List<PbContent> zl() {
        return this.aPU;
    }

    public bh zm() {
        return this.aOP;
    }

    public MetaData zn() {
        return this.aOQ;
    }

    public UserTbVipInfoData zo() {
        if (this.aOQ == null) {
            return null;
        }
        return this.aOQ.getUserTbVipInfoData();
    }

    public boolean zp() {
        return this.is_god != 0;
    }

    public boolean zq() {
        return this.is_god == 1;
    }

    public boolean zr() {
        return (this.aOQ == null || this.aOQ.getGodUserData() == null || this.aOQ.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean zs() {
        return (this.aOQ == null || this.aOQ.getGodUserData() == null || this.aOQ.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aOQ = metaData;
    }

    public String zt() {
        return this.forum_name;
    }

    public void cZ(String str) {
        this.forum_name = str;
    }

    public int zu() {
        return this.aOS;
    }

    public String zv() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aOU;
    }

    public void da(String str) {
        this.aOU = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aPV == null || this.aPV.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aPV.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aPV.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aPU == null || (size = this.aPU.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aPU.get(i2);
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
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.aPV != null && (size = this.aPV.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aPV.get(i2);
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
        return this.aOZ;
    }

    public void eT(int i) {
        this.aOZ = i;
    }

    public String zx() {
        return this.aPa;
    }

    public void dc(String str) {
        this.aPa = str;
    }

    public ArrayList<MediaData> zy() {
        return this.aOV;
    }

    public ArrayList<a> zz() {
        return this.aPr;
    }

    public void i(ArrayList<a> arrayList) {
        this.aPr = arrayList;
    }

    public bn zA() {
        return this.aPs;
    }

    public d zB() {
        return this.aPt;
    }

    public ArrayList<VoiceData.VoiceModel> zC() {
        return this.aOW;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int zD() {
        return this.aPf;
    }

    public void eU(int i) {
        this.aPf = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String zE() {
        return this.aPp;
    }

    public VideoInfo zF() {
        return this.aPk;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aPm = alaInfoData;
    }

    public AlaInfoData zG() {
        return this.aPm;
    }

    public String getPhotoLiveCover() {
        return this.aPx;
    }

    public void setPhotoLiveCover(String str) {
        this.aPx = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> zH() {
        return this.aPj;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.aPj.clear();
        this.aPj.addAll(arrayList);
    }

    public PushStatusData zI() {
        return this.aPN;
    }

    public SkinInfo zJ() {
        return this.aPO;
    }

    public long zK() {
        return this.aQa;
    }

    public boolean zL() {
        return this.aQb;
    }

    public String zM() {
        return this.aQc;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aPg = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aOY = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aPn = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aOK = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aOL = threadInfo.last_time_int.intValue();
                this.aOM = threadInfo.is_top.intValue();
                this.aON = threadInfo.is_good.intValue();
                this.aOO = threadInfo.is_livepost.intValue();
                this.aOP.a(threadInfo.topic);
                this.aOQ.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aOR = threadInfo.has_commented.intValue();
                this.aOS = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aPk = threadInfo.video_info;
                this.aPm = new AlaInfoData();
                this.aPm.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aOZ = threadInfo.collect_status.intValue();
                this.aPa = threadInfo.collect_mark_pid;
                this.aPb = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aPe = threadInfo.first_post_id + "";
                this.aPp = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aPf = threadInfo.is_ntitle.intValue();
                this.aPh = threadInfo.is_activity.intValue();
                this.aQm = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aQn = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aQp = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aPi = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aPW = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aPU = threadInfo.rich_title;
                this.aPV = threadInfo.rich_abstract;
                this.aOX = threadInfo.is_godthread_recommend.intValue();
                if ((this.aOQ == null || this.aOQ.getUserId() == null || this.aOQ.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aOQ = metaData;
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
                this.aOU = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aOV.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aPk = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aPl = new bj();
                    this.aPl.a(threadInfo.video_channel_info);
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
                        this.aOW.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aPr.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aPs = new bn();
                    this.aPs.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aPt = new d();
                    this.aPt.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aPu = new m();
                    this.aPu.a(threadInfo.cartoon_info);
                }
                this.aPc.setUserMap(this.userMap);
                this.aPc.parserProtobuf(threadInfo.zan);
                this.aPd.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aPc.setTitle(this.title);
                } else {
                    this.aPc.setTitle(this.aOU);
                }
                this.aPx = threadInfo.livecover_src;
                this.aPy = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aPq = threadInfo.post_num.intValue();
                this.aPB = threadInfo.freq_num.longValue();
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
                                this.aPj.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aPz = noticeInfo.notice;
                    }
                    this.aPF = zhiBoInfoTW.copythread_remind.intValue();
                    this.aPD = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aPE = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aPx)) {
                        this.aPx = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aPK = zhiBoInfoTW.user.tw_anchor_info;
                        this.aPL = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aPA = threadInfo.twzhibo_info.livecover_status;
                    this.aPB = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aPC = threadInfo.poll_info;
                this.aPG = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aPJ.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aPM.add(cVar);
                    }
                }
                this.aPN.parserProtobuf(threadInfo.push_status);
                this.aPR = threadInfo.lego_card;
                this.aPO = threadInfo.skin_info;
                this.aPS = threadInfo.is_book_chapter.intValue();
                this.aPT.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.aQc = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.aPZ = threadInfo.recom_extra;
                this.aQa = threadInfo.last_read_pid.longValue();
                this.aQb = threadInfo.cheak_repeat.intValue() == 1;
                this.aQf = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aQo.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.D(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.aNr = sparseArray;
                }
                this.aQl = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aQq = new ad();
                    this.aQq.a(threadInfo.link_info);
                }
                this.aQr = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aQs = new c();
                    this.aQs.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aQt = new MediaData();
                    this.aQt.parserProtobuf(threadInfo.pic_info);
                }
                this.aPY = threadInfo.is_called.intValue();
                this.aQu = threadInfo.middle_page_num.intValue();
                this.aQv = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.aQx = threadInfo.star_rank_icon.icon_pic_url;
                    this.aQy = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.aQw = new OriginalThreadInfo();
                    this.aQw.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.aQw = new OriginalThreadInfo();
                    this.aQw.parser(threadInfo.origin_thread_info);
                } else {
                    this.aQw = null;
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
                this.aPn = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aOK = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.aOL = jSONObject.optLong("last_time_int", 0L);
                this.aOM = jSONObject.optInt("is_top", 0);
                this.aON = jSONObject.optInt("is_good", 0);
                this.aOO = jSONObject.optInt("is_livepost", 0);
                this.aOP.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aOQ.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aOR = jSONObject.optInt("has_commented", 0);
                this.aOS = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aOZ = jSONObject.optInt("collect_status");
                this.aPa = jSONObject.optString("collect_mark_pid");
                this.aPb = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aQm = jSONObject.optInt("agree_num");
                this.aQp = jSONObject.optLong("share_num");
                this.aPe = jSONObject.optString("first_post_id", "0");
                this.aPp = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.aPf = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.aQn = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aPJ.parserJson(optJSONObject2);
                }
                if ((this.aOQ == null || this.aOQ.getUserId() == null) && this.userMap != null) {
                    this.aOQ = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aPm = new AlaInfoData();
                this.aPm.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aOU = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aOV.add(mediaData);
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
                        this.aOW.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aPr.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aPs = new bn();
                    this.aPs.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aPt = new d();
                    this.aPt.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aPu = new m();
                    this.aPu.parserJson(optJSONObject6);
                }
                this.aPc.setUserMap(this.userMap);
                this.aPc.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aPd.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aPc.setTitle(this.title);
                } else {
                    this.aPc.setTitle(this.aOU);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aPJ.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aPM.add(cVar);
                    }
                }
                this.aPS = jSONObject.optInt("is_book_chapter", 0);
                this.aPT.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.aQc = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.aPZ = jSONObject.optString("recom_extra");
                this.aQa = jSONObject.optLong("last_read_pid");
                this.aQb = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aPl = new bj();
                    this.aPl.i(optJSONObject8);
                }
                this.aQl = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aQq = new ad();
                    this.aQq.parserJson(optJSONObject9);
                }
                this.aQr = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aQs = new c();
                    this.aQs.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aQt = new MediaData();
                    this.aQt.parserJson(optJSONObject11);
                }
                this.aPY = jSONObject.optInt("is_called", 0);
                this.aQu = jSONObject.optInt("middle_page_num", 0);
                this.aQv = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.aPk = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.aQw = new OriginalThreadInfo();
                        this.aQw.parserJson(optJSONObject13);
                        return;
                    }
                    this.aQw = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder zN() {
        return this.aOT;
    }

    public boolean zO() {
        return zi() != 0;
    }

    public int zP() {
        if (this.aPJ != null) {
            long yQ = this.aPJ.yQ();
            long yR = this.aPJ.yR();
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
        if (zS() && this.aPr.size() >= 1) {
            a aVar = this.aPr.get(0);
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
        if (!zS() || this.aPr.size() < 1 || this.aPr.get(0) == null) {
            return -1;
        }
        return this.aPr.get(0).xE();
    }

    public boolean zS() {
        return this.aPh == 1;
    }

    public String getActUrl() {
        return (!zS() || this.aPr.size() < 1 || this.aPr.get(0) == null) ? "" : this.aPr.get(0).getUrl();
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_cont_f_1));
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
            if (getThreadType() == 42 && zU()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (zi() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (zi() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (zk() == 1 || this.aOP.AI() != 0) {
                if (yV() != null && getThreadType() == 41) {
                    if (zP() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && Ad()) {
                Integer num = aPw.get(Integer.valueOf(zP()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (zj() == 1 && !zO() && aOx != getType() && aOC != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (getType() == aOG || getType() == aOH) {
                arrayList.add(Integer.valueOf(d.f.icon_vote_blue));
            }
            if (this.aPd != null && this.aPd.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (zu() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = aPv.get(new Point(zR(), zQ()));
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
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aOJ));
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
            SpannableStringBuilder c = !z && zi() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aOT = spannableStringBuilder;
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
        String g = g(this.title, false);
        SpannableString a = a(new SpannableString(g + " "));
        if (z) {
            spannableStringBuilder = a(g, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aOT = spannableStringBuilder;
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
            if (this.aPf == 1) {
                this.aOT = a2;
                return a2;
            }
        } else if (this.aPf == 1) {
            this.aOT = new SpannableStringBuilder();
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
        if (this.aPU != null && this.aPU.size() > 0) {
            int size = this.aPU.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aPU.get(i2);
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
        if (this.aPU != null && this.aPU.size() > 0) {
            int size = this.aPU.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.aPU.get(i);
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
        return this.aPd;
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
        if (this.aPk != null && !StringUtils.isNull(this.aPk.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aPk.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aOQ != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aOQ.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean Ab() {
        String userId;
        return this.aOQ == null || (userId = this.aOQ.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        int zi = zi();
        if (this.aPm != null && this.threadType == 60) {
            return aOA;
        }
        if (this.aPm != null && this.threadType == 49) {
            return aOy;
        }
        if (this.threadType == 51) {
            return aOz;
        }
        if (zi == 2 || zi == 1) {
            return aOt;
        }
        if (this.aPk != null && Ak()) {
            return aOI;
        }
        if (this.aPk != null) {
            if (zr()) {
                return aOC;
            }
            return aOx;
        } else if (this.isShareThread) {
            return aOB;
        } else {
            if (yZ() != null && getThreadType() == 36 && yZ().type.intValue() == 2) {
                return aOG;
            }
            if (yZ() != null && getThreadType() == 36 && yZ().type.intValue() == 1) {
                return aOH;
            }
            if (Ac()) {
                return aOD.get() ? aPI : aOu;
            } else if (zS() && zR() == 1) {
                return aOD.get() ? aPP : aOu;
            } else if (isLinkThread()) {
                return aOv;
            } else {
                if (zr()) {
                    return aOw;
                }
                return aOu;
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
        if (this.aPf == 1) {
            this.aLR = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aLR = 0;
        } else {
            this.aLR = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.xQ() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.xQ().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aLR = next.xR();
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
        return this.aPQ;
    }

    public void aW(boolean z) {
        this.aPQ = z;
    }

    public String Af() {
        return this.aPR;
    }

    public m Ag() {
        return this.aPu;
    }

    public boolean Ah() {
        return zk() == 1 || zj() == 1 || zi() == 1 || zS() || this.aPS == 1 || zr() || zB() != null || zA() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || zq();
    }

    public void Ai() {
        if (this.aPo == 0) {
            this.aPo = 1;
        }
    }

    public boolean Aj() {
        return this.aPW;
    }

    public void aX(boolean z) {
        this.aQd = z;
    }

    public boolean Ak() {
        return this.aQd;
    }

    public void eV(int i) {
        this.aQe = i + 1;
    }

    public int Al() {
        return this.aQe;
    }

    public List<ReportInfo> Am() {
        return this.aQf;
    }

    public boolean An() {
        return this.aPX;
    }

    public void aY(boolean z) {
        this.aPX = z;
    }

    public bj Ao() {
        return this.aPl;
    }

    public void a(bj bjVar) {
        this.aPl = bjVar;
    }

    public void eW(int i) {
        if (this.aPl != null) {
            this.aPl.mCurrentPage = i;
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
        return this.aQk;
    }

    public void setSmartFrsPosition(int i) {
        this.aQk = i;
    }

    public SparseArray<String> yo() {
        return this.aNr;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aNr = sparseArray;
    }

    public String Av() {
        return this.mRecomSource;
    }

    public boolean Aw() {
        return this.aQl;
    }

    public int Ax() {
        return this.aQm;
    }

    public int Ay() {
        return this.aQn;
    }

    public void eX(int i) {
        this.aQn = i;
    }

    public void eY(int i) {
        this.aQm = i;
    }

    public long Az() {
        return this.aQp;
    }

    public void w(long j) {
        this.aQp = j;
    }

    public PostData AA() {
        return this.aQo;
    }

    public ad AB() {
        return this.aQq;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aPf == 1) {
            g = g(this.aOU, false);
            a = db(this.aOU);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aOT = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder i(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder j(boolean z, boolean z2) {
        SpannableString db;
        if (!StringUtils.isNull(this.title)) {
            db = a(new SpannableString(g(this.title, false) + " "));
        } else {
            g(this.aOU, false);
            db = db(this.aOU);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(db);
        this.aOT = spannableStringBuilder;
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
                    arrayList.add(aQh.get(zP()));
                }
                if (zS()) {
                    Integer num = aQg.get(new Point(zR(), zQ()));
                    if (num != null) {
                        arrayList.add(new j.a(num.intValue(), d.C0140d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new j.a(d.j.card_promotion_text));
                    }
                }
                if (zA() != null) {
                    arrayList.add(new j.a(d.j.card_promotion_text, d.C0140d.cp_other_b, d.f.pic_dot_title_red));
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
                    Integer num2 = aQg.get(new Point(zR(), zQ()));
                    if (num2 != null) {
                        arrayList.add(new j.a(num2.intValue(), d.C0140d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new j.a(d.j.card_promotion_text));
                    }
                }
                if (this.aPS == 1) {
                    arrayList.add(new j.a(d.j.card_tbread_text));
                }
                if (zB() != null) {
                    arrayList.add(new j.a(d.j.send_app_code_gift, d.C0140d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (zA() != null) {
                    arrayList.add(new j.a(d.j.card_promotion_text, d.C0140d.cp_other_b, d.f.pic_dot_title_red));
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
        this.aOV = arrayList;
    }
}
