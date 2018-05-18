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
import com.baidu.tieba.card.o;
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
import tbclient.ReportInfo;
import tbclient.SkinInfo;
import tbclient.ThreadInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class bd extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h, com.baidu.tbadk.core.util.ae {
    public static final BdUniqueId ZG = BdUniqueId.gen();
    public static final BdUniqueId ZH = BdUniqueId.gen();
    public static final BdUniqueId ZI = BdUniqueId.gen();
    public static final BdUniqueId ZJ = BdUniqueId.gen();
    public static final BdUniqueId ZK = BdUniqueId.gen();
    public static final BdUniqueId ZL = BdUniqueId.gen();
    public static final BdUniqueId ZM = BdUniqueId.gen();
    public static final BdUniqueId ZN = BdUniqueId.gen();
    public static final BdUniqueId ZO = BdUniqueId.gen();
    public static final BdUniqueId ZP = BdUniqueId.gen();
    public static final BdUniqueId ZQ = BdUniqueId.gen();
    public static AtomicBoolean ZR = new AtomicBoolean(false);
    public static AtomicBoolean ZS = new AtomicBoolean(false);
    public static AtomicBoolean ZT = new AtomicBoolean(false);
    public static final BdUniqueId ZU = BdUniqueId.gen();
    private static HashMap<Point, Integer> aaK = new HashMap<>();
    private static HashMap<Integer, Integer> aaL = new HashMap<>();
    public static final BdUniqueId aaV = BdUniqueId.gen();
    public static final BdUniqueId aaW = BdUniqueId.gen();
    public static final BdUniqueId abf = BdUniqueId.gen();
    private static HashMap<Point, Integer> abw = new HashMap<>();
    private static SparseArray<o.a> abx = new SparseArray<>(3);
    private String ZW;
    private String ZX;
    private bj aaA;
    private AlaInfoData aaB;
    private long aaC;
    private n aaJ;
    private LiveCoverStatus aaP;
    private long aaQ;
    public TwZhiBoUser aaY;
    public List<TwAnchorProfitItem> aaZ;
    private SpannableStringBuilder aai;
    public int aam;
    private int aan;
    private int aaq;
    private String aat;
    private int aau;
    private String aav;
    private int aax;
    private VideoInfo aaz;
    private boolean abB;
    private int abD;
    private long abF;
    private ae abG;
    public d abI;
    private MediaData abJ;
    public int abK;
    public OriginalThreadInfo abM;
    private String abQ;
    private String abR;
    private String abd;
    private SkinInfo abe;
    private boolean abg;
    private String abh;
    private boolean abm;
    private boolean abn;
    public long abp;
    public String abr;
    private List<ReportInfo> abv;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    public boolean isShareThread;
    private String latitude;
    private long mCreateTime;
    private String mFromType;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    private String mUrl;
    private int post_num;
    public int threadType;
    private HashMap<String, MetaData> userMap;
    public int ZV = 1;
    private String aap = null;
    private int Xd = 0;
    public int aaD = 0;
    private String aaE = "";
    private String aaM = "";
    public boolean abq = true;
    public boolean aby = false;
    public boolean abz = false;
    private int abA = -1;
    private SparseArray<String> YI = null;
    public boolean abH = false;
    private int abP = 0;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int ZY = 0;
    private int ZZ = 0;
    private String last_time = null;
    private long aaa = 0;
    private int aab = 0;
    private int aac = 0;
    private int aad = 0;
    private bh aae = new bh();
    private MetaData aaf = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aak = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aal = new ArrayList<>();
    private int aag = 0;
    private int aah = 0;
    private String ad_url = null;
    private String aaj = null;
    private String from = null;
    private int aao = 0;
    private PraiseData aar = new PraiseData();
    private AnchorInfoData aas = new AnchorInfoData();
    private long time = 0;
    private int aaw = 0;
    private ArrayList<a> aaG = new ArrayList<>();
    private bm aaH = null;
    private e aaI = null;
    private int aaN = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> aay = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aaO = null;
    private int aaF = 0;
    private boolean aaR = false;
    private boolean aaS = false;
    private int aaT = 0;
    private boolean aaU = false;
    private int anchorLevel = 0;
    public int abi = 0;
    public k abj = new k();
    private List<PbContent> abk = new ArrayList();
    private List<PbContent> abl = new ArrayList();
    private String category_name = null;
    private bb aaX = new bb();
    private ArrayList<com.baidu.tbadk.data.c> aba = new ArrayList<>();
    private PushStatusData abb = new PushStatusData();
    public boolean abt = false;
    public int abu = -1;
    private int abC = 0;
    private PostData abE = new PostData();
    private int abo = 0;
    public int abL = 0;
    private String tieba_game_information_source = "";
    public String abO = "";
    public String abN = "";

    static {
        aaK.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        aaK.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        aaK.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        aaK.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        aaK.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        aaK.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        aaK.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        aaK.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        abw.put(new Point(1, 1), Integer.valueOf(d.k.lottery_status_ing));
        abw.put(new Point(1, 2), Integer.valueOf(d.k.lottery_status_over));
        abw.put(new Point(1, 3), Integer.valueOf(d.k.lottery_status_off));
        abw.put(new Point(1, 4), Integer.valueOf(d.k.lottery_status_not_start));
        abw.put(new Point(2, 1), Integer.valueOf(d.k.share_picture_status_ing));
        abw.put(new Point(2, 2), Integer.valueOf(d.k.share_picture_status_over));
        abw.put(new Point(2, 3), Integer.valueOf(d.k.share_picture_status_off));
        abw.put(new Point(2, 4), Integer.valueOf(d.k.share_picture_status_not_start));
        aaL.put(1, Integer.valueOf(d.f.label_interview_no));
        aaL.put(2, Integer.valueOf(d.f.label_interview_live));
        aaL.put(3, Integer.valueOf(d.f.label_interview_off));
        abx.put(1, new o.a(d.k.interview_live_status_not_start, d.C0126d.cp_other_b, d.f.pic_dot_title_red));
        abx.put(2, new o.a(d.k.interview_live_status_ing, d.C0126d.cp_other_c, d.f.pic_dot_title_green));
        abx.put(3, new o.a(d.k.interview_live_status_over, d.C0126d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.aan = 0;
        this.aax = 0;
        this.aaQ = 0L;
        this.mUrl = "";
        this.abd = "";
        this.abK = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.aaQ = 0L;
        this.aax = 0;
        this.aan = 0;
        this.abK = 0;
        this.mUrl = "";
        this.abd = "";
    }

    public boolean ry() {
        return this.aan == 1;
    }

    public bb rz() {
        return this.aaX;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bL(int i) {
        this.anchorLevel = i;
    }

    public int rA() {
        return this.abo;
    }

    public void bM(int i) {
        this.abo = i;
    }

    public void bN(int i) {
        this.aaT = i;
    }

    public int rB() {
        return this.aaT;
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

    public long rC() {
        return this.aaC;
    }

    public String rD() {
        return this.aat;
    }

    public PraiseData rE() {
        return this.aar;
    }

    public void a(PraiseData praiseData) {
        this.aar = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rF() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cJ(String str) {
        this.tid = str;
    }

    public String rG() {
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

    public void r(List<PbContent> list) {
        this.abk = list;
    }

    public void s(List<PbContent> list) {
        this.abl = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void bO(int i) {
        this.reply_num = i;
    }

    public int rH() {
        return this.reply_num;
    }

    public int rI() {
        return this.ZZ;
    }

    public void bP(int i) {
        this.ZZ = i;
    }

    public long rJ() {
        return this.aaa;
    }

    public void n(long j) {
        this.aaa = j;
    }

    public int rK() {
        return this.aab;
    }

    public void bQ(int i) {
        this.aab = i;
    }

    public int rL() {
        return this.aac;
    }

    public void bR(int i) {
        this.aac = i;
    }

    public int rM() {
        return this.aad;
    }

    public List<PbContent> rN() {
        return this.abk;
    }

    public bh rO() {
        return this.aae;
    }

    public MetaData rP() {
        return this.aaf;
    }

    public boolean rQ() {
        return this.is_god != 0;
    }

    public boolean rR() {
        return this.is_god == 1;
    }

    public boolean rS() {
        return (this.aaf == null || this.aaf.getGodUserData() == null || this.aaf.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rT() {
        return (this.aaf == null || this.aaf.getGodUserData() == null || this.aaf.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aaf = metaData;
    }

    public String rU() {
        return this.forum_name;
    }

    public void cN(String str) {
        this.forum_name = str;
    }

    public int rV() {
        return this.aah;
    }

    public String rW() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aaj;
    }

    public void cO(String str) {
        this.aaj = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.abl == null || this.abl.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.abl.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.abl.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.abk == null || (size = this.abk.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.abk.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cP(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.abl != null && (size = this.abl.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.abl.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bd.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view2) {
                                bd.this.cT(pbContent.link);
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

    public int rX() {
        return this.aao;
    }

    public void bS(int i) {
        this.aao = i;
    }

    public String rY() {
        return this.aap;
    }

    public void cQ(String str) {
        this.aap = str;
    }

    public ArrayList<MediaData> rZ() {
        return this.aak;
    }

    public ArrayList<a> sa() {
        return this.aaG;
    }

    public void h(ArrayList<a> arrayList) {
        this.aaG = arrayList;
    }

    public bm sb() {
        return this.aaH;
    }

    public e sc() {
        return this.aaI;
    }

    public ArrayList<VoiceData.VoiceModel> sd() {
        return this.aal;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int se() {
        return this.aau;
    }

    public void bT(int i) {
        this.aau = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String sf() {
        return this.aaE;
    }

    public VideoInfo sg() {
        return this.aaz;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aaB = alaInfoData;
    }

    public AlaInfoData sh() {
        return this.aaB;
    }

    public PushStatusData si() {
        return this.abb;
    }

    public SkinInfo sj() {
        return this.abe;
    }

    public long sk() {
        return this.abp;
    }

    public boolean sl() {
        return this.abq;
    }

    public String sm() {
        return this.abr;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aav = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aan = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aaC = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.ZY = threadInfo.repost_num.intValue();
                this.ZZ = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aaa = threadInfo.last_time_int.intValue();
                this.aab = threadInfo.is_top.intValue();
                this.aac = threadInfo.is_good.intValue();
                this.aad = threadInfo.is_livepost.intValue();
                this.aae.a(threadInfo.topic);
                this.aaf.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aag = threadInfo.has_commented.intValue();
                this.aah = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aaz = threadInfo.video_info;
                this.aaB = new AlaInfoData();
                this.aaB.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aao = threadInfo.collect_status.intValue();
                this.aap = threadInfo.collect_mark_pid;
                this.aaq = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aat = threadInfo.first_post_id + "";
                this.aaE = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aau = threadInfo.is_ntitle.intValue();
                this.aaw = threadInfo.is_activity.intValue();
                this.abC = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.abD = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.abF = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aax = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.abm = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.abk = threadInfo.rich_title;
                this.abl = threadInfo.rich_abstract;
                this.aam = threadInfo.is_godthread_recommend.intValue();
                if ((this.aaf == null || this.aaf.getUserId() == null || this.aaf.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aaf = metaData;
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
                this.aaj = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aak.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aaz = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aaA = new bj();
                    this.aaA.a(threadInfo.video_channel_info);
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
                        this.aal.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aaG.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aaH = new bm();
                    this.aaH.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aaI = new e();
                    this.aaI.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aaJ = new n();
                    this.aaJ.a(threadInfo.cartoon_info);
                }
                this.aar.setUserMap(this.userMap);
                this.aar.parserProtobuf(threadInfo.zan);
                this.aas.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aar.setTitle(this.title);
                } else {
                    this.aar.setTitle(this.aaj);
                }
                this.aaM = threadInfo.livecover_src;
                this.aaN = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aaF = threadInfo.post_num.intValue();
                this.aaQ = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.eo(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.fD(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aay.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aaO = noticeInfo.notice;
                    }
                    this.aaT = zhiBoInfoTW.copythread_remind.intValue();
                    this.aaR = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aaS = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aaM)) {
                        this.aaM = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aaY = zhiBoInfoTW.user.tw_anchor_info;
                        this.aaZ = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aaP = threadInfo.twzhibo_info.livecover_status;
                    this.aaQ = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aaU = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aaX.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aba.add(cVar);
                    }
                }
                this.abb.parserProtobuf(threadInfo.push_status);
                this.abh = threadInfo.lego_card;
                this.abe = threadInfo.skin_info;
                this.abi = threadInfo.is_book_chapter.intValue();
                this.abj.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.abr = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.abp = threadInfo.last_read_pid.longValue();
                this.abq = threadInfo.cheak_repeat.intValue() == 1;
                this.abv = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.abE.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.v(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.YI = sparseArray;
                }
                this.abB = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.abG = new ae();
                    this.abG.a(threadInfo.link_info);
                }
                this.abH = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.abI = new d();
                    this.abI.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.abJ = new MediaData();
                    this.abJ.parserProtobuf(threadInfo.pic_info);
                }
                this.abo = threadInfo.is_called.intValue();
                this.abK = threadInfo.middle_page_num.intValue();
                this.abL = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.abN = threadInfo.star_rank_icon.icon_pic_url;
                    this.abO = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.abM = new OriginalThreadInfo();
                    this.abM.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.abM = new OriginalThreadInfo();
                    this.abM.parser(threadInfo.origin_thread_info);
                } else {
                    this.abM = null;
                }
                this.abP = threadInfo.is_topic.intValue();
                this.abQ = threadInfo.topic_user_name;
                this.abR = threadInfo.topic_h5_url;
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
                this.aaC = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.ZY = jSONObject.optInt("repost_num", 0);
                this.ZZ = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.aaa = jSONObject.optLong("last_time_int", 0L);
                this.aab = jSONObject.optInt("is_top", 0);
                this.aac = jSONObject.optInt("is_good", 0);
                this.aad = jSONObject.optInt("is_livepost", 0);
                this.aae.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aaf.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aag = jSONObject.optInt("has_commented", 0);
                this.aah = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aao = jSONObject.optInt("collect_status");
                this.aap = jSONObject.optString("collect_mark_pid");
                this.aaq = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.abC = jSONObject.optInt("agree_num");
                this.abF = jSONObject.optLong("share_num");
                this.aat = jSONObject.optString("first_post_id", "0");
                this.aaE = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.aau = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.abD = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aaX.parserJson(optJSONObject2);
                }
                if ((this.aaf == null || this.aaf.getUserId() == null) && this.userMap != null) {
                    this.aaf = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aaB = new AlaInfoData();
                this.aaB.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aaj = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aak.add(mediaData);
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
                        this.aal.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aaG.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aaH = new bm();
                    this.aaH.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aaI = new e();
                    this.aaI.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aaJ = new n();
                    this.aaJ.parserJson(optJSONObject6);
                }
                this.aar.setUserMap(this.userMap);
                this.aar.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aas.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aar.setTitle(this.title);
                } else {
                    this.aar.setTitle(this.aaj);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aaX.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aba.add(cVar);
                    }
                }
                this.abi = jSONObject.optInt("is_book_chapter", 0);
                this.abj.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.abr = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.abp = jSONObject.optLong("last_read_pid");
                this.abq = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aaA = new bj();
                    this.aaA.l(optJSONObject8);
                }
                this.abB = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.abG = new ae();
                    this.abG.parserJson(optJSONObject9);
                }
                this.abH = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.abI = new d();
                    this.abI.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.abJ = new MediaData();
                    this.abJ.parserJson(optJSONObject11);
                }
                this.abo = jSONObject.optInt("is_called", 0);
                this.abK = jSONObject.optInt("middle_page_num", 0);
                this.abL = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.aaz = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.abM = new OriginalThreadInfo();
                        this.abM.parserJson(optJSONObject13);
                        return;
                    }
                    this.abM = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sn() {
        return this.aai;
    }

    public boolean so() {
        return rK() != 0;
    }

    public int sp() {
        if (this.aaX != null) {
            long ru = this.aaX.ru();
            long rv = this.aaX.rv();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < ru) {
                return 1;
            }
            if (currentTimeMillis > rv) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sq() {
        if (ss() && this.aaG.size() >= 1) {
            a aVar = this.aaG.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int qn = aVar.qn();
            int qo = aVar.qo();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < qn) {
                return 4;
            }
            return currentTimeMillis > qo ? 2 : 1;
        }
        return -1;
    }

    public int sr() {
        if (!ss() || this.aaG.size() < 1 || this.aaG.get(0) == null) {
            return -1;
        }
        return this.aaG.get(0).qm();
    }

    public boolean ss() {
        return this.aaw == 1;
    }

    public String getActUrl() {
        return (!ss() || this.aaG.size() < 1 || this.aaG.get(0) == null) ? "" : this.aaG.get(0).getUrl();
    }

    private com.baidu.adp.widget.b cR(String str) {
        com.baidu.adp.widget.b bVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(d.i.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(d.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0126d.cp_cont_f_1));
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
            if (getThreadType() == 42 && su()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (rK() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (rK() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (rM() == 1 || this.aae.tq() != 0) {
                if (rz() != null && getThreadType() == 41) {
                    if (sp() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && sE()) {
                Integer num = aaL.get(Integer.valueOf(sp()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rL() == 1 && !so() && ZK != getType() && ZP != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (this.aas != null && this.aas.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (rV() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = aaK.get(new Point(sr(), sq()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (sb() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (sc() != null) {
                arrayList.add(Integer.valueOf(d.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = cR(this.category_name);
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
                Bitmap cO = com.baidu.tbadk.core.util.ak.cO(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                }
                com.baidu.tbadk.core.view.h hVar = new com.baidu.tbadk.core.view.h(bitmapDrawable);
                hVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.ZV));
                spannableString.setSpan(hVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder c = !z && rK() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aai = spannableStringBuilder;
    }

    public boolean st() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || sg() == null || sg().video_type.intValue() == 0) {
            return i == 1 && sg() != null && (sg().video_type.intValue() == 1 || sg().video_type.intValue() == 12 || sg().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds8);
        Bitmap cO = com.baidu.tbadk.core.util.ak.cO(d.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
        com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (rP() != null) {
            if (rP().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.he));
            } else if (rP().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(iVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private SpannableStringBuilder c(String str, ArrayList<o.a> arrayList) {
        if (sA() || !rQ() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(d.k.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean su() {
        return com.baidu.adp.lib.b.d.eE().ak("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.v(a(z, z2, z3, false)) > 0) {
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
        this.aai = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> a = a(z, z2, z3, z4);
        if (a == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, a, false);
        if (a.size() > 0) {
            if (a2 == null) {
                a2 = new SpannableStringBuilder();
            }
            if (this.aau == 1) {
                this.aai = a2;
                return a2;
            }
        } else if (this.aau == 1) {
            this.aai = new SpannableStringBuilder();
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

    public void M(String str, String str2) {
        this.mUrl = str;
        this.abd = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a w;
        com.baidu.adp.widget.ImageView.a w2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.abd) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.EY().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.u.v(this.mUrl, 10)) && (w = com.baidu.tbadk.core.util.d.u.w(this.mUrl, 10)) != null) {
                bitmap = w.kl();
                com.baidu.tbadk.imageManager.c.EY().b(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.EY().getBitmap(this.abd);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.u.v(this.abd, 10)) && (w2 = com.baidu.tbadk.core.util.d.u.w(this.abd, 10)) != null) {
                bitmap2 = w2.kl();
                com.baidu.tbadk.imageManager.c.EY().b(this.abd, bitmap2);
            }
            Bitmap bitmap3 = bitmap2;
            if (bitmap != null && !bitmap.isRecycled() && bitmap3 != null && !bitmap3.isRecycled()) {
                int i2 = 0;
                for (int i3 = 0; i3 < str.length(); i3++) {
                    if (str.charAt(i3) == '#') {
                        if (i2 % 2 == 0) {
                            bitmapDrawable = new BitmapDrawable(bitmap);
                            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        } else {
                            bitmapDrawable = new BitmapDrawable(bitmap3);
                            bitmapDrawable.setBounds(0, 0, bitmap3.getWidth(), bitmap3.getHeight());
                        }
                        com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                        jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.ZV));
                        spannableString.setSpan(jVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.fp().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bd.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.EY().b(str2, aVar.kl());
                    }
                }
            }, ZI);
            com.baidu.adp.lib.f.c.fp().a(this.abd, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bd.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.EY().b(str2, aVar.kl());
                    }
                }
            }, ZI);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.abk != null && this.abk.size() > 0) {
            int size = this.abk.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.abk.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (sA()) {
                            if (pbContent.text != null) {
                                String cS = cS(pbContent.text);
                                a(spannableString, pbContent.text, i3);
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, cS) { // from class: com.baidu.tbadk.core.data.bd.4
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        bd.this.cT(getLink());
                                    }
                                }, i3, pbContent.text.length() + i3, 33);
                            }
                        } else {
                            a(spannableString, pbContent.text, i3);
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bd.5
                                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                public void onClick(View view2) {
                                    bd.this.cT(pbContent.link);
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

    private String cS(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData sv() {
        if (this.abk != null && this.abk.size() > 0) {
            int size = this.abk.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.abk.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && sA() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = cS(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, str));
        }
    }

    public void sw() {
        d(false, false);
    }

    public void sx() {
        d(false, true);
    }

    public AnchorInfoData sy() {
        return this.aas;
    }

    public boolean sz() {
        return this.threadType == 36;
    }

    public boolean sA() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rZ = rZ();
        if (rZ == null || so()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rZ.size() || i2 >= 3) {
                break;
            }
            if (rZ.get(i2) != null && rZ.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rZ.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rZ.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rZ.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aaz != null && !StringUtils.isNull(this.aaz.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aaz.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aaf != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aaf.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean sB() {
        String userId;
        return this.aaf == null || (userId = this.aaf.getUserId()) == null || userId.equals("0");
    }

    private boolean sC() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        int rK = rK();
        if (this.aaB != null && this.threadType == 60) {
            return ZN;
        }
        if (this.aaB != null && this.threadType == 49) {
            return ZL;
        }
        if (this.threadType == 51) {
            return ZM;
        }
        if (rK == 2 || rK == 1) {
            return ZG;
        }
        if (this.aaz != null && sL() && !sC()) {
            return ZU;
        }
        if (this.aaz != null && !sC()) {
            if (rS()) {
                return ZP;
            }
            return ZK;
        } else if (this.isShareThread) {
            return ZO;
        } else {
            if (sD()) {
                return ZR.get() ? aaW : ZH;
            } else if (ss() && sr() == 1) {
                return ZR.get() ? abf : ZH;
            } else if (isLinkThread()) {
                return ZI;
            } else {
                if (rS()) {
                    return ZJ;
                }
                if (this.abP == 1) {
                    return ZQ;
                }
                return ZH;
            }
        }
    }

    public boolean sD() {
        return rz() != null && getThreadType() == 41 && rM() == 1 && sp() == 2;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.aau == 1) {
            this.Xd = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Xd = 0;
        } else {
            this.Xd = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.qw() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.qw().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Xd = next.qx();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sE() {
        return this.threadType == 41;
    }

    public boolean sF() {
        return this.abg;
    }

    public void ao(boolean z) {
        this.abg = z;
    }

    public String sG() {
        return this.abh;
    }

    public n sH() {
        return this.aaJ;
    }

    public boolean sI() {
        return rM() == 1 || rL() == 1 || rK() == 1 || ss() || this.abi == 1 || rS() || sc() != null || sb() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || rR();
    }

    public void sJ() {
        if (this.aaD == 0) {
            this.aaD = 1;
        }
    }

    public boolean sK() {
        return this.abm;
    }

    public void ap(boolean z) {
        this.abt = z;
    }

    public boolean sL() {
        return this.abt;
    }

    public void bU(int i) {
        this.abu = i + 1;
    }

    public int sM() {
        return this.abu;
    }

    public List<ReportInfo> sN() {
        return this.abv;
    }

    public boolean sO() {
        return this.abn;
    }

    public void aq(boolean z) {
        this.abn = z;
    }

    public bj sP() {
        return this.aaA;
    }

    public void a(bj bjVar) {
        this.aaA = bjVar;
    }

    public void bV(int i) {
        if (this.aaA != null) {
            this.aaA.mCurrentPage = i;
        }
    }

    public boolean sQ() {
        return getThreadType() == 49;
    }

    public boolean sR() {
        return getThreadType() == 40;
    }

    public boolean sS() {
        return getThreadType() == 50;
    }

    public boolean sT() {
        return getThreadType() == 60;
    }

    public boolean sU() {
        return getThreadType() == 40 && sP() != null && sP().channelId > 0;
    }

    public int sV() {
        return this.abA;
    }

    public void setSmartFrsPosition(int i) {
        this.abA = i;
    }

    public SparseArray<String> qT() {
        return this.YI;
    }

    public void a(SparseArray<String> sparseArray) {
        this.YI = sparseArray;
    }

    public String sW() {
        return this.mRecomSource;
    }

    public boolean sX() {
        return this.abB;
    }

    public int sY() {
        return this.abC;
    }

    public int sZ() {
        return this.abD;
    }

    public void bW(int i) {
        this.abD = i;
    }

    public void bX(int i) {
        this.abC = i;
    }

    public long ta() {
        return this.abF;
    }

    public void o(long j) {
        this.abF = j;
    }

    public PostData tb() {
        return this.abE;
    }

    public ae tc() {
        return this.abG;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aau == 1) {
            g = g(this.aaj, true);
            a = cP(this.aaj);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aai = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        SpannableString cP;
        if (!StringUtils.isNull(this.title) && this.aau != 1) {
            cP = a(new SpannableString(g(this.title, false) + " "));
        } else {
            cP = cP(this.aaj);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cP);
        this.aai = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString td() {
        if (this.aau == 1) {
            return null;
        }
        return cP(this.aaj);
    }

    private ArrayList<o.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean rQ = rQ();
        if (z2) {
            if (z) {
                if (rQ && !sA()) {
                    arrayList.add(new o.a(d.k.god_title));
                }
                if (rM() == 1 || getThreadType() == 33 || (rO() != null && rO().tq() != 0)) {
                    if (rz() != null && sE()) {
                        if (sp() == 2) {
                            arrayList.add(new o.a(d.k.interview_live));
                        }
                    } else if (!rQ) {
                        arrayList.add(new o.a(d.k.photo_live_tips));
                    }
                }
                if (rK() == 1) {
                    arrayList.add(new o.a(d.k.top));
                }
                if (rL() == 1) {
                    arrayList.add(new o.a(d.k.good));
                }
                if (sE()) {
                    arrayList.add(abx.get(sp()));
                }
                if (ss()) {
                    Integer num = abw.get(new Point(sr(), sq()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(d.k.card_promotion_text));
                    }
                }
                if (sb() != null) {
                    arrayList.add(new o.a(d.k.card_promotion_text, d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.an.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (rQ && rK() != 1 && !sA()) {
                    arrayList.add(new o.a(d.k.god_title));
                }
                if ((rM() == 1 || getThreadType() == 33) && !sE() && !rQ) {
                    arrayList.add(new o.a(d.k.photo_live_tips));
                }
                if (rL() == 1) {
                    arrayList.add(new o.a(d.k.good));
                }
                if (rK() == 1) {
                    arrayList.add(new o.a(d.k.top));
                }
                if (sE() && rz() != null && sp() == 2) {
                    arrayList.add(new o.a(d.k.interview_live));
                }
                if (ss()) {
                    Integer num2 = abw.get(new Point(sr(), sq()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(d.k.card_promotion_text));
                    }
                }
                if (this.abi == 1) {
                    arrayList.add(new o.a(d.k.card_tbread_text));
                }
                if (sc() != null) {
                    arrayList.add(new o.a(d.k.send_app_code_gift, d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (sb() != null) {
                    arrayList.add(new o.a(d.k.card_promotion_text, d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.an.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && sQ()) {
                    arrayList.add(new o.a(d.k.ala_live));
                }
                if (sU()) {
                    arrayList.add(new o.a(d.k.frs_channel_tip));
                } else if (z3 && sS()) {
                    arrayList.add(new o.a(d.k.live_record));
                } else if (sR()) {
                    arrayList.add(new o.a(d.k.video_title_str));
                }
                if (z4) {
                    arrayList.add(new o.a(d.k.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void j(ArrayList<MediaData> arrayList) {
        this.aak = arrayList;
    }

    public String te() {
        return this.abQ;
    }

    public void cU(String str) {
        this.abQ = str;
    }

    public void tf() {
        this.abP = 1;
    }

    public String tg() {
        return this.ZW;
    }

    public void cV(String str) {
        this.ZW = str;
    }

    public String th() {
        return this.ZX;
    }

    public void cW(String str) {
        this.ZX = str;
    }

    public String ti() {
        return this.abR;
    }

    public void cX(String str) {
        this.abR = str;
    }
}
