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
    private static HashMap<Point, Integer> aaJ = new HashMap<>();
    private static HashMap<Integer, Integer> aaK = new HashMap<>();
    public static final BdUniqueId aaU = BdUniqueId.gen();
    public static final BdUniqueId aaV = BdUniqueId.gen();
    public static final BdUniqueId abe = BdUniqueId.gen();
    private static HashMap<Point, Integer> abv = new HashMap<>();
    private static SparseArray<o.a> abw = new SparseArray<>(3);
    private String ZW;
    private String ZX;
    private AlaInfoData aaA;
    private long aaB;
    private n aaI;
    private LiveCoverStatus aaO;
    private long aaP;
    public TwZhiBoUser aaX;
    public List<TwAnchorProfitItem> aaY;
    private SpannableStringBuilder aah;
    public int aal;
    private int aam;
    private int aap;
    private String aas;
    private int aat;
    private String aau;
    private int aaw;
    private VideoInfo aay;
    private bj aaz;
    private boolean abA;
    private int abC;
    private long abE;
    private ae abF;
    public d abH;
    private MediaData abI;
    public int abJ;
    public OriginalThreadInfo abL;
    private String abP;
    private String abQ;
    private String abb;
    private SkinInfo abd;
    private boolean abf;
    private String abg;
    private boolean abl;
    private boolean abm;
    public long abo;
    public String abq;
    private List<ReportInfo> abu;
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
    private String aao = null;
    private int Xc = 0;
    public int aaC = 0;
    private String aaD = "";
    private String aaL = "";
    public boolean abp = true;
    public boolean abx = false;
    public boolean aby = false;
    private int abz = -1;
    private SparseArray<String> YI = null;
    public boolean abG = false;
    private int abO = 0;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int ZY = 0;
    private int view_num = 0;
    private String last_time = null;
    private long ZZ = 0;
    private int aaa = 0;
    private int aab = 0;
    private int aac = 0;
    private bh aad = new bh();
    private MetaData aae = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aaj = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aak = new ArrayList<>();
    private int aaf = 0;
    private int aag = 0;
    private String ad_url = null;
    private String aai = null;
    private String from = null;
    private int aan = 0;
    private PraiseData aaq = new PraiseData();
    private AnchorInfoData aar = new AnchorInfoData();
    private long time = 0;
    private int aav = 0;
    private ArrayList<a> aaF = new ArrayList<>();
    private bm aaG = null;
    private e aaH = null;
    private int aaM = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> aax = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aaN = null;
    private int aaE = 0;
    private boolean aaQ = false;
    private boolean aaR = false;
    private int aaS = 0;
    private boolean aaT = false;
    private int anchorLevel = 0;
    public int abh = 0;
    public k abi = new k();
    private List<PbContent> abj = new ArrayList();
    private List<PbContent> abk = new ArrayList();
    private String category_name = null;
    private bb aaW = new bb();
    private ArrayList<com.baidu.tbadk.data.c> aaZ = new ArrayList<>();
    private PushStatusData aba = new PushStatusData();
    public boolean abr = false;
    public int abt = -1;
    private int abB = 0;
    private PostData abD = new PostData();
    private int abn = 0;
    public int abK = 0;
    private String tieba_game_information_source = "";
    public String abN = "";
    public String abM = "";

    static {
        aaJ.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        aaJ.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        aaJ.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        aaJ.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        aaJ.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        aaJ.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        aaJ.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        aaJ.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        abv.put(new Point(1, 1), Integer.valueOf(d.k.lottery_status_ing));
        abv.put(new Point(1, 2), Integer.valueOf(d.k.lottery_status_over));
        abv.put(new Point(1, 3), Integer.valueOf(d.k.lottery_status_off));
        abv.put(new Point(1, 4), Integer.valueOf(d.k.lottery_status_not_start));
        abv.put(new Point(2, 1), Integer.valueOf(d.k.share_picture_status_ing));
        abv.put(new Point(2, 2), Integer.valueOf(d.k.share_picture_status_over));
        abv.put(new Point(2, 3), Integer.valueOf(d.k.share_picture_status_off));
        abv.put(new Point(2, 4), Integer.valueOf(d.k.share_picture_status_not_start));
        aaK.put(1, Integer.valueOf(d.f.label_interview_no));
        aaK.put(2, Integer.valueOf(d.f.label_interview_live));
        aaK.put(3, Integer.valueOf(d.f.label_interview_off));
        abw.put(1, new o.a(d.k.interview_live_status_not_start, d.C0126d.cp_other_b, d.f.pic_dot_title_red));
        abw.put(2, new o.a(d.k.interview_live_status_ing, d.C0126d.cp_other_c, d.f.pic_dot_title_green));
        abw.put(3, new o.a(d.k.interview_live_status_over, d.C0126d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.aam = 0;
        this.aaw = 0;
        this.aaP = 0L;
        this.mUrl = "";
        this.abb = "";
        this.abJ = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.aaP = 0L;
        this.aaw = 0;
        this.aam = 0;
        this.abJ = 0;
        this.mUrl = "";
        this.abb = "";
    }

    public boolean rz() {
        return this.aam == 1;
    }

    public bb rA() {
        return this.aaW;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bK(int i) {
        this.anchorLevel = i;
    }

    public int rB() {
        return this.abn;
    }

    public void bL(int i) {
        this.abn = i;
    }

    public void bM(int i) {
        this.aaS = i;
    }

    public int rC() {
        return this.aaS;
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

    public long rD() {
        return this.aaB;
    }

    public String rE() {
        return this.aas;
    }

    public PraiseData rF() {
        return this.aaq;
    }

    public void a(PraiseData praiseData) {
        this.aaq = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rG() {
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

    public String rH() {
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
        this.abj = list;
    }

    public void s(List<PbContent> list) {
        this.abk = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void bN(int i) {
        this.reply_num = i;
    }

    public int rI() {
        return this.reply_num;
    }

    public int rJ() {
        return this.view_num;
    }

    public void bO(int i) {
        this.view_num = i;
    }

    public long rK() {
        return this.ZZ;
    }

    public void n(long j) {
        this.ZZ = j;
    }

    public int rL() {
        return this.aaa;
    }

    public void bP(int i) {
        this.aaa = i;
    }

    public int rM() {
        return this.aab;
    }

    public void bQ(int i) {
        this.aab = i;
    }

    public int rN() {
        return this.aac;
    }

    public List<PbContent> rO() {
        return this.abj;
    }

    public bh rP() {
        return this.aad;
    }

    public MetaData rQ() {
        return this.aae;
    }

    public boolean rR() {
        return this.is_god != 0;
    }

    public boolean rS() {
        return this.is_god == 1;
    }

    public boolean rT() {
        return (this.aae == null || this.aae.getGodUserData() == null || this.aae.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rU() {
        return (this.aae == null || this.aae.getGodUserData() == null || this.aae.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aae = metaData;
    }

    public String rV() {
        return this.forum_name;
    }

    public void cN(String str) {
        this.forum_name = str;
    }

    public int rW() {
        return this.aag;
    }

    public String rX() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aai;
    }

    public void cO(String str) {
        this.aai = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.abk == null || this.abk.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.abk.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.abk.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.abj == null || (size = this.abj.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.abj.get(i2);
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
        if (this.abk != null && (size = this.abk.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.abk.get(i2);
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

    public int rY() {
        return this.aan;
    }

    public void bR(int i) {
        this.aan = i;
    }

    public String rZ() {
        return this.aao;
    }

    public void cQ(String str) {
        this.aao = str;
    }

    public ArrayList<MediaData> sa() {
        return this.aaj;
    }

    public ArrayList<a> sb() {
        return this.aaF;
    }

    public void h(ArrayList<a> arrayList) {
        this.aaF = arrayList;
    }

    public bm sc() {
        return this.aaG;
    }

    public e sd() {
        return this.aaH;
    }

    public ArrayList<VoiceData.VoiceModel> se() {
        return this.aak;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int sf() {
        return this.aat;
    }

    public void bS(int i) {
        this.aat = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String sg() {
        return this.aaD;
    }

    public VideoInfo sh() {
        return this.aay;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aaA = alaInfoData;
    }

    public AlaInfoData si() {
        return this.aaA;
    }

    public PushStatusData sj() {
        return this.aba;
    }

    public SkinInfo sk() {
        return this.abd;
    }

    public long sl() {
        return this.abo;
    }

    public boolean sm() {
        return this.abp;
    }

    public String sn() {
        return this.abq;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aau = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aam = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aaB = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.ZY = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.ZZ = threadInfo.last_time_int.intValue();
                this.aaa = threadInfo.is_top.intValue();
                this.aab = threadInfo.is_good.intValue();
                this.aac = threadInfo.is_livepost.intValue();
                this.aad.a(threadInfo.topic);
                this.aae.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aaf = threadInfo.has_commented.intValue();
                this.aag = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aay = threadInfo.video_info;
                this.aaA = new AlaInfoData();
                this.aaA.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aan = threadInfo.collect_status.intValue();
                this.aao = threadInfo.collect_mark_pid;
                this.aap = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aas = threadInfo.first_post_id + "";
                this.aaD = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aat = threadInfo.is_ntitle.intValue();
                this.aav = threadInfo.is_activity.intValue();
                this.abB = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.abC = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.abE = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aaw = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.abl = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.abj = threadInfo.rich_title;
                this.abk = threadInfo.rich_abstract;
                this.aal = threadInfo.is_godthread_recommend.intValue();
                if ((this.aae == null || this.aae.getUserId() == null || this.aae.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aae = metaData;
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
                this.aai = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aaj.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aay = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aaz = new bj();
                    this.aaz.a(threadInfo.video_channel_info);
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
                        this.aak.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aaF.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aaG = new bm();
                    this.aaG.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aaH = new e();
                    this.aaH.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aaI = new n();
                    this.aaI.a(threadInfo.cartoon_info);
                }
                this.aaq.setUserMap(this.userMap);
                this.aaq.parserProtobuf(threadInfo.zan);
                this.aar.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aaq.setTitle(this.title);
                } else {
                    this.aaq.setTitle(this.aai);
                }
                this.aaL = threadInfo.livecover_src;
                this.aaM = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aaE = threadInfo.post_num.intValue();
                this.aaP = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.en(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.fD(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aax.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aaN = noticeInfo.notice;
                    }
                    this.aaS = zhiBoInfoTW.copythread_remind.intValue();
                    this.aaQ = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aaR = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aaL)) {
                        this.aaL = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aaX = zhiBoInfoTW.user.tw_anchor_info;
                        this.aaY = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aaO = threadInfo.twzhibo_info.livecover_status;
                    this.aaP = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aaT = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aaW.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aaZ.add(cVar);
                    }
                }
                this.aba.parserProtobuf(threadInfo.push_status);
                this.abg = threadInfo.lego_card;
                this.abd = threadInfo.skin_info;
                this.abh = threadInfo.is_book_chapter.intValue();
                this.abi.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.abq = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.abo = threadInfo.last_read_pid.longValue();
                this.abp = threadInfo.cheak_repeat.intValue() == 1;
                this.abu = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.abD.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.abA = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.abF = new ae();
                    this.abF.a(threadInfo.link_info);
                }
                this.abG = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.abH = new d();
                    this.abH.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.abI = new MediaData();
                    this.abI.parserProtobuf(threadInfo.pic_info);
                }
                this.abn = threadInfo.is_called.intValue();
                this.abJ = threadInfo.middle_page_num.intValue();
                this.abK = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.abM = threadInfo.star_rank_icon.icon_pic_url;
                    this.abN = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.abL = new OriginalThreadInfo();
                    this.abL.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.abL = new OriginalThreadInfo();
                    this.abL.parser(threadInfo.origin_thread_info);
                } else {
                    this.abL = null;
                }
                this.abO = threadInfo.is_topic.intValue();
                this.abP = threadInfo.topic_user_name;
                this.abQ = threadInfo.topic_h5_url;
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
                this.aaB = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.ZY = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.ZZ = jSONObject.optLong("last_time_int", 0L);
                this.aaa = jSONObject.optInt("is_top", 0);
                this.aab = jSONObject.optInt("is_good", 0);
                this.aac = jSONObject.optInt("is_livepost", 0);
                this.aad.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aae.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aaf = jSONObject.optInt("has_commented", 0);
                this.aag = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aan = jSONObject.optInt("collect_status");
                this.aao = jSONObject.optString("collect_mark_pid");
                this.aap = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.abB = jSONObject.optInt("agree_num");
                this.abE = jSONObject.optLong("share_num");
                this.aas = jSONObject.optString("first_post_id", "0");
                this.aaD = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.aat = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.abC = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aaW.parserJson(optJSONObject2);
                }
                if ((this.aae == null || this.aae.getUserId() == null) && this.userMap != null) {
                    this.aae = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aaA = new AlaInfoData();
                this.aaA.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aai = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aaj.add(mediaData);
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
                        this.aak.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aaF.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aaG = new bm();
                    this.aaG.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aaH = new e();
                    this.aaH.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aaI = new n();
                    this.aaI.parserJson(optJSONObject6);
                }
                this.aaq.setUserMap(this.userMap);
                this.aaq.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aar.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aaq.setTitle(this.title);
                } else {
                    this.aaq.setTitle(this.aai);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aaW.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aaZ.add(cVar);
                    }
                }
                this.abh = jSONObject.optInt("is_book_chapter", 0);
                this.abi.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.abq = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.abo = jSONObject.optLong("last_read_pid");
                this.abp = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aaz = new bj();
                    this.aaz.l(optJSONObject8);
                }
                this.abA = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.abF = new ae();
                    this.abF.parserJson(optJSONObject9);
                }
                this.abG = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.abH = new d();
                    this.abH.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.abI = new MediaData();
                    this.abI.parserJson(optJSONObject11);
                }
                this.abn = jSONObject.optInt("is_called", 0);
                this.abJ = jSONObject.optInt("middle_page_num", 0);
                this.abK = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.aay = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.abL = new OriginalThreadInfo();
                        this.abL.parserJson(optJSONObject13);
                        return;
                    }
                    this.abL = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder so() {
        return this.aah;
    }

    public boolean sp() {
        return rL() != 0;
    }

    public int sq() {
        if (this.aaW != null) {
            long rv = this.aaW.rv();
            long rw = this.aaW.rw();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rv) {
                return 1;
            }
            if (currentTimeMillis > rw) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sr() {
        if (st() && this.aaF.size() >= 1) {
            a aVar = this.aaF.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int qo = aVar.qo();
            int qp = aVar.qp();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < qo) {
                return 4;
            }
            return currentTimeMillis > qp ? 2 : 1;
        }
        return -1;
    }

    public int ss() {
        if (!st() || this.aaF.size() < 1 || this.aaF.get(0) == null) {
            return -1;
        }
        return this.aaF.get(0).qn();
    }

    public boolean st() {
        return this.aav == 1;
    }

    public String getActUrl() {
        return (!st() || this.aaF.size() < 1 || this.aaF.get(0) == null) ? "" : this.aaF.get(0).getUrl();
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
            if (getThreadType() == 42 && sv()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (rL() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (rL() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (rN() == 1 || this.aad.tr() != 0) {
                if (rA() != null && getThreadType() == 41) {
                    if (sq() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && sF()) {
                Integer num = aaK.get(Integer.valueOf(sq()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rM() == 1 && !sp() && ZK != getType() && ZP != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (this.aar != null && this.aar.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (rW() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = aaJ.get(new Point(ss(), sr()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (sc() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (sd() != null) {
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
                Bitmap cN = com.baidu.tbadk.core.util.ak.cN(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                if (cN != null) {
                    bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
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
            SpannableStringBuilder c = !z && rL() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aah = spannableStringBuilder;
    }

    public boolean su() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || sh() == null || sh().video_type.intValue() == 0) {
            return i == 1 && sh() != null && (sh().video_type.intValue() == 1 || sh().video_type.intValue() == 12 || sh().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds8);
        Bitmap cN = com.baidu.tbadk.core.util.ak.cN(d.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
        bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
        com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (rQ() != null) {
            if (rQ().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.he));
            } else if (rQ().getGender() == 2) {
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
        if (sB() || !rR() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(d.k.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean sv() {
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
        this.aah = spannableStringBuilder;
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
            if (this.aat == 1) {
                this.aah = a2;
                return a2;
            }
        } else if (this.aat == 1) {
            this.aah = new SpannableStringBuilder();
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
        this.abb = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a w;
        com.baidu.adp.widget.ImageView.a w2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.abb) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.Fa().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.s.v(this.mUrl, 10)) && (w = com.baidu.tbadk.core.util.d.s.w(this.mUrl, 10)) != null) {
                bitmap = w.km();
                com.baidu.tbadk.imageManager.c.Fa().b(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.Fa().getBitmap(this.abb);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.s.v(this.abb, 10)) && (w2 = com.baidu.tbadk.core.util.d.s.w(this.abb, 10)) != null) {
                bitmap2 = w2.km();
                com.baidu.tbadk.imageManager.c.Fa().b(this.abb, bitmap2);
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
                        com.baidu.tbadk.imageManager.c.Fa().b(str2, aVar.km());
                    }
                }
            }, ZI);
            com.baidu.adp.lib.f.c.fp().a(this.abb, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bd.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.Fa().b(str2, aVar.km());
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
        if (this.abj != null && this.abj.size() > 0) {
            int size = this.abj.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.abj.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (sB()) {
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

    public ActivityItemData sw() {
        if (this.abj != null && this.abj.size() > 0) {
            int size = this.abj.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.abj.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && sB() && pbContent.text != null && pbContent.text.length() >= 3) {
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

    public void sx() {
        d(false, false);
    }

    public void sy() {
        d(false, true);
    }

    public AnchorInfoData sz() {
        return this.aar;
    }

    public boolean sA() {
        return this.threadType == 36;
    }

    public boolean sB() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> sa = sa();
        if (sa == null || sp()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sa.size() || i2 >= 3) {
                break;
            }
            if (sa.get(i2) != null && sa.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(sa.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = sa.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = sa.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aay != null && !StringUtils.isNull(this.aay.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aay.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aae != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aae.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean sC() {
        String userId;
        return this.aae == null || (userId = this.aae.getUserId()) == null || userId.equals("0");
    }

    private boolean sD() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        int rL = rL();
        if (this.aaA != null && this.threadType == 60) {
            return ZN;
        }
        if (this.aaA != null && this.threadType == 49) {
            return ZL;
        }
        if (this.threadType == 51) {
            return ZM;
        }
        if (rL == 2 || rL == 1) {
            return ZG;
        }
        if (this.aay != null && sM() && !sD()) {
            return ZU;
        }
        if (this.aay != null && !sD()) {
            if (rT()) {
                return ZP;
            }
            return ZK;
        } else if (this.isShareThread) {
            return ZO;
        } else {
            if (sE()) {
                return ZR.get() ? aaV : ZH;
            } else if (st() && ss() == 1) {
                return ZR.get() ? abe : ZH;
            } else if (isLinkThread()) {
                return ZI;
            } else {
                if (rT()) {
                    return ZJ;
                }
                if (this.abO == 1) {
                    return ZQ;
                }
                return ZH;
            }
        }
    }

    public boolean sE() {
        return rA() != null && getThreadType() == 41 && rN() == 1 && sq() == 2;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.aat == 1) {
            this.Xc = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Xc = 0;
        } else {
            this.Xc = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.qx() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.qx().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Xc = next.qy();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sF() {
        return this.threadType == 41;
    }

    public boolean sG() {
        return this.abf;
    }

    public void ao(boolean z) {
        this.abf = z;
    }

    public String sH() {
        return this.abg;
    }

    public n sI() {
        return this.aaI;
    }

    public boolean sJ() {
        return rN() == 1 || rM() == 1 || rL() == 1 || st() || this.abh == 1 || rT() || sd() != null || sc() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || rS();
    }

    public void sK() {
        if (this.aaC == 0) {
            this.aaC = 1;
        }
    }

    public boolean sL() {
        return this.abl;
    }

    public void ap(boolean z) {
        this.abr = z;
    }

    public boolean sM() {
        return this.abr;
    }

    public void bT(int i) {
        this.abt = i + 1;
    }

    public int sN() {
        return this.abt;
    }

    public List<ReportInfo> sO() {
        return this.abu;
    }

    public boolean sP() {
        return this.abm;
    }

    public void aq(boolean z) {
        this.abm = z;
    }

    public bj sQ() {
        return this.aaz;
    }

    public void a(bj bjVar) {
        this.aaz = bjVar;
    }

    public void bU(int i) {
        if (this.aaz != null) {
            this.aaz.mCurrentPage = i;
        }
    }

    public boolean sR() {
        return getThreadType() == 49;
    }

    public boolean sS() {
        return getThreadType() == 40;
    }

    public boolean sT() {
        return getThreadType() == 50;
    }

    public boolean sU() {
        return getThreadType() == 60;
    }

    public boolean sV() {
        return getThreadType() == 40 && sQ() != null && sQ().channelId > 0;
    }

    public int sW() {
        return this.abz;
    }

    public void setSmartFrsPosition(int i) {
        this.abz = i;
    }

    public SparseArray<String> qU() {
        return this.YI;
    }

    public void a(SparseArray<String> sparseArray) {
        this.YI = sparseArray;
    }

    public String sX() {
        return this.mRecomSource;
    }

    public boolean sY() {
        return this.abA;
    }

    public int sZ() {
        return this.abB;
    }

    public int ta() {
        return this.abC;
    }

    public void bV(int i) {
        this.abC = i;
    }

    public void bW(int i) {
        this.abB = i;
    }

    public long tb() {
        return this.abE;
    }

    public void o(long j) {
        this.abE = j;
    }

    public PostData tc() {
        return this.abD;
    }

    public ae td() {
        return this.abF;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aat == 1) {
            g = g(this.aai, true);
            a = cP(this.aai);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aah = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        SpannableString cP;
        if (!StringUtils.isNull(this.title) && this.aat != 1) {
            cP = a(new SpannableString(g(this.title, false) + " "));
        } else {
            cP = cP(this.aai);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cP);
        this.aah = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString te() {
        if (this.aat == 1) {
            return null;
        }
        return cP(this.aai);
    }

    private ArrayList<o.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean rR = rR();
        if (z2) {
            if (z) {
                if (rR && !sB()) {
                    arrayList.add(new o.a(d.k.god_title));
                }
                if (rN() == 1 || getThreadType() == 33 || (rP() != null && rP().tr() != 0)) {
                    if (rA() != null && sF()) {
                        if (sq() == 2) {
                            arrayList.add(new o.a(d.k.interview_live));
                        }
                    } else if (!rR) {
                        arrayList.add(new o.a(d.k.photo_live_tips));
                    }
                }
                if (rL() == 1) {
                    arrayList.add(new o.a(d.k.top));
                }
                if (rM() == 1) {
                    arrayList.add(new o.a(d.k.good));
                }
                if (sF()) {
                    arrayList.add(abw.get(sq()));
                }
                if (st()) {
                    Integer num = abv.get(new Point(ss(), sr()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(d.k.card_promotion_text));
                    }
                }
                if (sc() != null) {
                    arrayList.add(new o.a(d.k.card_promotion_text, d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.an.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (rR && rL() != 1 && !sB()) {
                    arrayList.add(new o.a(d.k.god_title));
                }
                if ((rN() == 1 || getThreadType() == 33) && !sF() && !rR) {
                    arrayList.add(new o.a(d.k.photo_live_tips));
                }
                if (rM() == 1) {
                    arrayList.add(new o.a(d.k.good));
                }
                if (rL() == 1) {
                    arrayList.add(new o.a(d.k.top));
                }
                if (sF() && rA() != null && sq() == 2) {
                    arrayList.add(new o.a(d.k.interview_live));
                }
                if (st()) {
                    Integer num2 = abv.get(new Point(ss(), sr()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(d.k.card_promotion_text));
                    }
                }
                if (this.abh == 1) {
                    arrayList.add(new o.a(d.k.card_tbread_text));
                }
                if (sd() != null) {
                    arrayList.add(new o.a(d.k.send_app_code_gift, d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (sc() != null) {
                    arrayList.add(new o.a(d.k.card_promotion_text, d.C0126d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.an.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && sR()) {
                    arrayList.add(new o.a(d.k.ala_live));
                }
                if (sV()) {
                    arrayList.add(new o.a(d.k.frs_channel_tip));
                } else if (z3 && sT()) {
                    arrayList.add(new o.a(d.k.live_record));
                } else if (sS()) {
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
        this.aaj = arrayList;
    }

    public String tf() {
        return this.abP;
    }

    public void cU(String str) {
        this.abP = str;
    }

    public void tg() {
        this.abO = 1;
    }

    public String th() {
        return this.ZW;
    }

    public void cV(String str) {
        this.ZW = str;
    }

    public String ti() {
        return this.ZX;
    }

    public void cW(String str) {
        this.ZX = str;
    }

    public String tj() {
        return this.abQ;
    }

    public void cX(String str) {
        this.abQ = str;
    }
}
