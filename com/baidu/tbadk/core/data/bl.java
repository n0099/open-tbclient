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
    public List<TwAnchorProfitItem> XA;
    public TwZhiBoUser Xz;
    public int ZB;
    private int ZC;
    private int ZE;
    private String ZH;
    private int ZI;
    private String ZJ;
    private int ZL;
    private VideoInfo ZN;
    private bq ZO;
    private c ZP;
    private long ZR;
    private n ZY;
    private SpannableStringBuilder Zx;
    public String aaA;
    public String aaB;
    public String aaC;
    public long aaD;
    public String aaF;
    private List<ReportInfo> aaI;
    private p aaO;
    private boolean aaP;
    private int aaR;
    private aj aaT;
    public d aaV;
    private MediaData aaW;
    private LiveCoverStatus aae;
    private long aaf;
    private SkinInfo aaq;
    private boolean aas;
    private String aat;
    private boolean aay;
    private boolean aaz;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    private String latitude;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId YZ = BdUniqueId.gen();
    public static final BdUniqueId Za = BdUniqueId.gen();
    public static final BdUniqueId Zb = BdUniqueId.gen();
    public static final BdUniqueId Zc = BdUniqueId.gen();
    public static final BdUniqueId Zd = BdUniqueId.gen();
    public static final BdUniqueId Ze = BdUniqueId.gen();
    public static final BdUniqueId Zf = BdUniqueId.gen();
    public static final BdUniqueId Zg = BdUniqueId.gen();
    public static final BdUniqueId Zh = BdUniqueId.gen();
    public static AtomicBoolean Zi = new AtomicBoolean(false);
    public static AtomicBoolean Zj = new AtomicBoolean(false);
    public static AtomicBoolean Zk = new AtomicBoolean(false);
    public static final BdUniqueId Zl = BdUniqueId.gen();
    public static final BdUniqueId Zm = BdUniqueId.gen();
    public static final BdUniqueId Zn = BdUniqueId.gen();
    private static HashMap<Point, Integer> ZZ = new HashMap<>();
    private static HashMap<Integer, Integer> aaa = new HashMap<>();
    public static final BdUniqueId aal = BdUniqueId.gen();
    public static final BdUniqueId aam = BdUniqueId.gen();
    public static final BdUniqueId aar = BdUniqueId.gen();
    private static HashMap<Point, Integer> aaJ = new HashMap<>();
    private static SparseArray<m.a> aaK = new SparseArray<>(3);
    public int Zo = 1;
    private String ZD = null;
    private int VV = 0;
    public int ZS = 0;
    private String ZT = "";
    private String aab = "";
    public boolean aaE = true;
    public boolean aaL = false;
    public boolean aaM = false;
    private int aaN = -1;
    private SparseArray<String> XT = null;
    public boolean aaU = false;
    private String id = null;
    private String XS = null;
    private long fid = 0;
    private String title = null;
    private int ZQ = 0;
    private int reply_num = 0;
    private int Zp = 0;
    private int view_num = 0;
    private String last_time = null;
    private long Zq = 0;
    private int Zr = 0;
    private int Zs = 0;
    private int Zt = 0;
    private bo Zu = new bo();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Zz = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> ZA = new ArrayList<>();
    private int Zv = 0;
    private int Zw = 0;
    private String ad_url = null;
    private String Zy = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData ZF = new PraiseData();
    private AnchorInfoData ZG = new AnchorInfoData();
    private long time = 0;
    private int ZK = 0;
    private ArrayList<a> ZV = new ArrayList<>();
    private bu ZW = null;
    private e ZX = null;
    private int aac = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.e> ZM = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aad = null;
    private int ZU = 0;
    private PollInfo aag = null;
    private boolean aah = false;
    private boolean aai = false;
    private int aaj = 0;
    private boolean aak = false;
    private int anchorLevel = 0;
    public int aau = 0;
    public k aav = new k();
    private List<PbContent> aaw = new ArrayList();
    private List<PbContent> aax = new ArrayList();
    private String category_name = null;
    private bj aan = new bj();
    private ArrayList<com.baidu.tbadk.data.a> aao = new ArrayList<>();
    private PushStatusData aap = new PushStatusData();
    public boolean aaG = false;
    public int aaH = -1;
    private int aaQ = 0;
    private PostData aaS = new PostData();

    static {
        ZZ.put(new Point(1, 1), Integer.valueOf(d.g.label_frs_lottery_ing));
        ZZ.put(new Point(1, 2), Integer.valueOf(d.g.label_frs_lottery_over));
        ZZ.put(new Point(1, 3), Integer.valueOf(d.g.label_frs_lottery_off));
        ZZ.put(new Point(1, 4), Integer.valueOf(d.g.label_frs_lottery_d));
        ZZ.put(new Point(2, 1), Integer.valueOf(d.g.label_frs_activity_shaiing));
        ZZ.put(new Point(2, 2), Integer.valueOf(d.g.label_frs_activity_shai_over));
        ZZ.put(new Point(2, 3), Integer.valueOf(d.g.label_frs_activity_shai_off));
        ZZ.put(new Point(2, 4), Integer.valueOf(d.g.label_frs_activity_shai_d));
        aaJ.put(new Point(1, 1), Integer.valueOf(d.l.lottery_status_ing));
        aaJ.put(new Point(1, 2), Integer.valueOf(d.l.lottery_status_over));
        aaJ.put(new Point(1, 3), Integer.valueOf(d.l.lottery_status_off));
        aaJ.put(new Point(1, 4), Integer.valueOf(d.l.lottery_status_not_start));
        aaJ.put(new Point(2, 1), Integer.valueOf(d.l.share_picture_status_ing));
        aaJ.put(new Point(2, 2), Integer.valueOf(d.l.share_picture_status_over));
        aaJ.put(new Point(2, 3), Integer.valueOf(d.l.share_picture_status_off));
        aaJ.put(new Point(2, 4), Integer.valueOf(d.l.share_picture_status_not_start));
        aaa.put(1, Integer.valueOf(d.g.label_interview_no));
        aaa.put(2, Integer.valueOf(d.g.label_interview_live));
        aaa.put(3, Integer.valueOf(d.g.label_interview_off));
        aaK.put(1, new m.a(d.l.interview_live_status_not_start, d.e.cp_other_b, d.g.pic_dot_title_red));
        aaK.put(2, new m.a(d.l.interview_live_status_ing, d.e.cp_other_c, d.g.pic_dot_title_green));
        aaK.put(3, new m.a(d.l.interview_live_status_over, d.e.cp_other_d, d.g.pic_dot_title_blue));
    }

    public bl() {
        this.ZC = 0;
        this.ZL = 0;
        this.aaf = 0L;
        this.post_num = 0;
        this.post_num = 0;
        this.aaf = 0L;
        this.ZL = 0;
        this.ZC = 0;
    }

    public boolean rm() {
        return this.ZC == 1;
    }

    public bj rn() {
        return this.aan;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bP(int i) {
        this.anchorLevel = i;
    }

    public int ro() {
        return this.ZL;
    }

    public boolean rp() {
        return this.aak;
    }

    public boolean rq() {
        return this.aah;
    }

    public boolean rr() {
        return this.aai;
    }

    public void bQ(int i) {
        this.aaj = i;
    }

    public int rs() {
        return this.aaj;
    }

    public PollInfo rt() {
        return this.aag;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.ZR;
    }

    public String ru() {
        return this.ZH;
    }

    public PraiseData rv() {
        return this.ZF;
    }

    public void a(PraiseData praiseData) {
        this.ZF = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rw() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cF(String str) {
        this.XS = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.XS) || "0".equals(this.XS)) ? this.id : this.XS;
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

    public int rx() {
        return this.reply_num;
    }

    public int ry() {
        return this.view_num;
    }

    public void bS(int i) {
        this.view_num = i;
    }

    public long rz() {
        return this.Zq;
    }

    public void m(long j) {
        this.Zq = j;
    }

    public int rA() {
        return this.Zr;
    }

    public void bT(int i) {
        this.Zr = i;
    }

    public int rB() {
        return this.Zs;
    }

    public void bU(int i) {
        this.Zs = i;
    }

    public int rC() {
        return this.Zt;
    }

    public List<PbContent> rD() {
        return this.aaw;
    }

    public bo rE() {
        return this.Zu;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rF() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rG() {
        return this.ZQ != 0;
    }

    public boolean rH() {
        return this.ZQ == 1;
    }

    public boolean rI() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rJ() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rK() {
        return this.forum_name;
    }

    public void cJ(String str) {
        this.forum_name = str;
    }

    public int rL() {
        return this.Zw;
    }

    public String rM() {
        return this.ad_url;
    }

    public String rN() {
        return this.Zy;
    }

    public void cK(String str) {
        this.Zy = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aax == null || this.aax.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aax.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aax.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aaw == null || (size = this.aaw.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aaw.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cL(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.aax != null && (size = this.aax.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aax.get(i2);
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
                                bl.this.cO(pbContent.link);
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

    public String rO() {
        return this.ZD;
    }

    public void cM(String str) {
        this.ZD = str;
    }

    public ArrayList<MediaData> rP() {
        return this.Zz;
    }

    public ArrayList<a> rQ() {
        return this.ZV;
    }

    public void h(ArrayList<a> arrayList) {
        this.ZV = arrayList;
    }

    public bu rR() {
        return this.ZW;
    }

    public e rS() {
        return this.ZX;
    }

    public ArrayList<VoiceData.VoiceModel> rT() {
        return this.ZA;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rU() {
        return this.ZI;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rV() {
        return this.ZT;
    }

    public VideoInfo rW() {
        return this.ZN;
    }

    public void a(c cVar) {
        this.ZP = cVar;
    }

    public c rX() {
        return this.ZP;
    }

    public String getPhotoLiveCover() {
        return this.aab;
    }

    public void setPhotoLiveCover(String str) {
        this.aab = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.e> rY() {
        return this.ZM;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
        this.ZM.clear();
        this.ZM.addAll(arrayList);
    }

    public String getNotice() {
        return this.aad;
    }

    public PushStatusData rZ() {
        return this.aap;
    }

    public SkinInfo sa() {
        return this.aaq;
    }

    public long sb() {
        return this.aaD;
    }

    public boolean sc() {
        return this.aaE;
    }

    public String sd() {
        return this.aaF;
    }

    public p se() {
        return this.aaO;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.ZJ = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.ZC = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.XS = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.ZQ = threadInfo.is_god.intValue();
                this.ZR = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Zp = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.Zq = threadInfo.last_time_int.intValue();
                this.Zr = threadInfo.is_top.intValue();
                this.Zs = threadInfo.is_good.intValue();
                this.Zt = threadInfo.is_livepost.intValue();
                this.Zu.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Zv = threadInfo.has_commented.intValue();
                this.Zw = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.ZN = threadInfo.video_info;
                this.ZP = new c();
                this.ZP.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.ZD = threadInfo.collect_mark_pid;
                this.ZE = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.ZH = threadInfo.first_post_id + "";
                this.ZT = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.ZI = threadInfo.is_ntitle.intValue();
                this.ZK = threadInfo.is_activity.intValue();
                this.aaQ = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.aaR = threadInfo.agree.has_agree.intValue();
                }
                this.category_name = threadInfo.category_name;
                this.ZL = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aay = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aaw = threadInfo.rich_title;
                this.aax = threadInfo.rich_abstract;
                this.ZB = threadInfo.is_godthread_recommend.intValue();
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
                this.Zy = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Zz.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.ZN = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.ZO = new bq();
                    this.ZO.a(threadInfo.video_channel_info);
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
                        this.ZA.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.ZV.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.ZW = new bu();
                    this.ZW.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.ZX = new e();
                    this.ZX.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ZY = new n();
                    this.ZY.a(threadInfo.cartoon_info);
                }
                this.ZF.setUserMap(this.userMap);
                this.ZF.parserProtobuf(threadInfo.zan);
                this.ZG.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.ZF.setTitle(this.title);
                } else {
                    this.ZF.setTitle(this.Zy);
                }
                this.aab = threadInfo.livecover_src;
                this.aac = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ZU = threadInfo.post_num.intValue();
                this.aaf = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                                eVar.em(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                eVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                eVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.ZM.add(eVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aad = noticeInfo.notice;
                    }
                    this.aaj = zhiBoInfoTW.copythread_remind.intValue();
                    this.aah = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aai = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aab)) {
                        this.aab = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.Xz = zhiBoInfoTW.user.tw_anchor_info;
                        this.XA = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aae = threadInfo.twzhibo_info.livecover_status;
                    this.aaf = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aag = threadInfo.poll_info;
                this.aak = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aan.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.aao.add(aVar2);
                    }
                }
                this.aap.parserProtobuf(threadInfo.push_status);
                this.aat = threadInfo.lego_card;
                this.aaq = threadInfo.skin_info;
                this.aau = threadInfo.is_book_chapter.intValue();
                this.aav.a(threadInfo.book_chapter);
                this.aaA = threadInfo.recom_source;
                this.aaF = threadInfo.recom_reason;
                this.aaB = threadInfo.recom_weight;
                this.aaC = threadInfo.ab_tag;
                this.aaD = threadInfo.last_read_pid.longValue();
                this.aaE = threadInfo.cheak_repeat.intValue() == 1;
                this.aaI = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aaS.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.u.u(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.XT = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.u.v(threadInfo.declare_list)) {
                    this.aaO = new p();
                    this.aaO.a(threadInfo);
                }
                this.aaP = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.aaT = new aj();
                    this.aaT.a(threadInfo.link_info);
                }
                this.aaU = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.aaV = new d();
                    this.aaV.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.aaW = new MediaData();
                    this.aaW.parserProtobuf(threadInfo.pic_info);
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
                this.XS = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.ZQ = jSONObject.optInt("is_god");
                this.ZR = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Zp = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.Zq = jSONObject.optLong("last_time_int", 0L);
                this.Zr = jSONObject.optInt("is_top", 0);
                this.Zs = jSONObject.optInt("is_good", 0);
                this.Zt = jSONObject.optInt("is_livepost", 0);
                this.Zu.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Zv = jSONObject.optInt("has_commented", 0);
                this.Zw = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.ZD = jSONObject.optString("collect_mark_pid");
                this.ZE = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.ZH = jSONObject.optString("first_post_id", "0");
                this.ZT = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.ZI = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aan.parserJson(optJSONObject2);
                }
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.ZP = new c();
                this.ZP.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.Zy = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Zz.add(mediaData);
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
                        this.ZA.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.ZV.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.ZW = new bu();
                    this.ZW.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.ZX = new e();
                    this.ZX.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.ZY = new n();
                    this.ZY.parserJson(optJSONObject6);
                }
                this.ZF.setUserMap(this.userMap);
                this.ZF.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.ZG.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.ZF.setTitle(this.title);
                } else {
                    this.ZF.setTitle(this.Zy);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aan.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aao.add(aVar2);
                    }
                }
                this.aau = jSONObject.optInt("is_book_chapter", 0);
                this.aav.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.aaA = jSONObject.optString("recom_source");
                this.aaF = jSONObject.optString("recom_reason");
                this.aaB = jSONObject.optString("recom_weight");
                this.aaD = jSONObject.optLong("last_read_pid");
                this.aaE = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.ZO = new bq();
                    this.ZO.i(optJSONObject8);
                }
                this.aaP = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.aaT = new aj();
                    this.aaT.parserJson(optJSONObject9);
                }
                this.aaU = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.aaV = new d();
                    this.aaV.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.aaW = new MediaData();
                    this.aaW.parserJson(optJSONObject11);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sf() {
        return this.Zx;
    }

    public boolean sg() {
        return rA() != 0;
    }

    public int sh() {
        if (this.aan != null) {
            long rg = this.aan.rg();
            long rh = this.aan.rh();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rg) {
                return 1;
            }
            if (currentTimeMillis > rh) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int si() {
        if (sk() && this.ZV.size() >= 1) {
            a aVar = this.ZV.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pp = aVar.pp();
            int pq = aVar.pq();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pp) {
                return 4;
            }
            return currentTimeMillis > pq ? 2 : 1;
        }
        return -1;
    }

    public int sj() {
        if (!sk() || this.ZV.size() < 1 || this.ZV.get(0) == null) {
            return -1;
        }
        return this.ZV.get(0).po();
    }

    public boolean sk() {
        return this.ZK == 1;
    }

    public String sl() {
        return (!sk() || this.ZV.size() < 1 || this.ZV.get(0) == null) ? "" : this.ZV.get(0).getUrl();
    }

    private com.baidu.adp.widget.b cN(String str) {
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
            if (getThreadType() == 42 && sm()) {
                arrayList.add(Integer.valueOf(d.g.icon_convene));
            }
            if (rA() == 1) {
                arrayList.add(Integer.valueOf(d.g.icon_top));
            } else if (rA() == 2) {
                arrayList.add(Integer.valueOf(d.g.icon_notice));
            }
            if (rC() == 1 || this.Zu.te() != 0) {
                if (rn() != null && getThreadType() == 41) {
                    if (sh() == 2) {
                        arrayList.add(Integer.valueOf(d.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.g.icon_zhibo));
                }
            }
            if (z && sx()) {
                Integer num = aaa.get(Integer.valueOf(sh()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rB() == 1 && !sg() && Zd != getType() && Zh != getType()) {
                arrayList.add(Integer.valueOf(d.g.icon_elite));
            }
            if (getType() == Zl || getType() == Zm) {
                arrayList.add(Integer.valueOf(d.g.icon_vote_blue));
            }
            if (this.ZG != null && this.ZG.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.g.icon_live_on));
            }
            if (rL() == 1) {
                arrayList.add(Integer.valueOf(d.g.frs_post_ding));
            }
            if (!z && sj() == 2) {
                arrayList.add(Integer.valueOf(d.g.label_frs_activity_shai));
            } else {
                Integer num2 = ZZ.get(new Point(sj(), si()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rR() != null) {
                arrayList.add(Integer.valueOf(d.g.tag_act));
            }
            if (rS() != null) {
                arrayList.add(Integer.valueOf(d.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                bVar = cN(this.category_name);
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
                Bitmap cS = com.baidu.tbadk.core.util.ai.cS(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cS);
                if (cS != null) {
                    bitmapDrawable.setBounds(0, 0, cS.getWidth(), cS.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.Zo));
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
            SpannableStringBuilder c = !z && rA() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.Zx = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<m.a> arrayList) {
        if (ss() || !rG() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new m.a(d.l.god_title));
        }
        return com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean sm() {
        return com.baidu.adp.lib.b.d.fh().al("isConveneThreadOpen") == 1;
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
        this.Zx = a(g, a(new SpannableString(g + " ")), z, z2, z3);
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
            if (this.ZI == 1) {
                this.Zx = a;
                return a;
            }
        } else if (this.ZI == 1) {
            this.Zx = new SpannableStringBuilder();
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
        if (this.aaw != null && this.aaw.size() > 0) {
            int size = this.aaw.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aaw.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bl.2
                            @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bl.this.cO(pbContent.link);
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
    public void cO(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, str));
        }
    }

    public void sn() {
        d(false, false);
    }

    public void so() {
        d(true, false);
    }

    public void sp() {
        d(false, true);
    }

    public AnchorInfoData sq() {
        return this.ZG;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sr() {
        return this.threadType == 36;
    }

    public boolean ss() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int st() {
        return this.ZU;
    }

    public void bV(int i) {
        this.ZU = i;
    }

    public long su() {
        return this.aaf;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rP = rP();
        if (rP == null || sg()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rP.size() || i2 >= 3) {
                break;
            }
            if (rP.get(i2) != null && rP.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rP.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rP.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rP.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.ZN != null && !StringUtils.isNull(this.ZN.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.ZN.thumbnail_url;
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

    public boolean sv() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        int rA = rA();
        if (this.ZP != null && this.threadType == 60) {
            return Zg;
        }
        if (this.ZP != null && this.threadType == 49) {
            return Ze;
        }
        if (this.threadType == 51) {
            return Zf;
        }
        if (rA == 2 || rA == 1) {
            return YZ;
        }
        if (this.ZN != null && sF()) {
            return Zn;
        }
        if (this.ZN != null) {
            if (rI()) {
                return Zh;
            }
            return Zd;
        } else if (rt() != null && getThreadType() == 36 && rt().type.intValue() == 2) {
            return Zl;
        } else {
            if (rt() != null && getThreadType() == 36 && rt().type.intValue() == 1) {
                return Zm;
            }
            if (rn() != null && getThreadType() == 41 && rC() == 1 && sh() == 2) {
                return Zi.get() ? aam : Za;
            } else if (sk() && sj() == 1) {
                return Zi.get() ? aar : Za;
            } else if (sk() && sj() == 2) {
                return Zi.get() ? aal : Za;
            } else if (isLinkThread()) {
                return Zb;
            } else {
                if (rI()) {
                    return Zc;
                }
                return Za;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sw() {
        return this.aae;
    }

    public List<TwAnchorProfitItem> qj() {
        return this.XA;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.ZI == 1) {
            this.VV = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.VV = 0;
        } else {
            this.VV = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.pI() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pI().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.VV = next.pJ();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sx() {
        return this.threadType == 41;
    }

    public boolean sy() {
        return this.threadType == 48;
    }

    public boolean sz() {
        return this.aas;
    }

    public void ao(boolean z) {
        this.aas = z;
    }

    public String sA() {
        return this.aat;
    }

    public n sB() {
        return this.ZY;
    }

    public boolean sC() {
        return rC() == 1 || rB() == 1 || rA() == 1 || sk() || this.aau == 1 || rI() || rS() != null || rR() != null || !com.baidu.adp.lib.util.j.isEmpty(getCategory()) || sy() || rH();
    }

    public void sD() {
        if (this.ZS == 0) {
            this.ZS = 1;
        }
    }

    public boolean sE() {
        return this.aay;
    }

    public void ap(boolean z) {
        this.aaG = z;
    }

    public boolean sF() {
        return this.aaG;
    }

    public void bW(int i) {
        this.aaH = i + 1;
    }

    public int sG() {
        return this.aaH;
    }

    public List<ReportInfo> sH() {
        return this.aaI;
    }

    public boolean sI() {
        return this.aaz;
    }

    public void aq(boolean z) {
        this.aaz = z;
    }

    public bq sJ() {
        return this.ZO;
    }

    public void a(bq bqVar) {
        this.ZO = bqVar;
    }

    public void bX(int i) {
        if (this.ZO != null) {
            this.ZO.mCurrentPage = i;
        }
    }

    public boolean sK() {
        return getThreadType() == 49;
    }

    public boolean sL() {
        return getThreadType() == 40;
    }

    public boolean sM() {
        return getThreadType() == 50;
    }

    public boolean sN() {
        return getThreadType() == 60;
    }

    public boolean sO() {
        return getThreadType() == 40 && sJ() != null && sJ().channelId > 0;
    }

    public int sP() {
        return this.aaN;
    }

    public void setSmartFrsPosition(int i) {
        this.aaN = i;
    }

    public SparseArray<String> qw() {
        return this.XT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.XT = sparseArray;
    }

    public String sQ() {
        return this.aaA;
    }

    public boolean sR() {
        return this.aaP;
    }

    public int sS() {
        return this.aaQ;
    }

    public int sT() {
        return this.aaR;
    }

    public void bY(int i) {
        this.aaR = i;
    }

    public void bZ(int i) {
        this.aaQ = i;
    }

    public PostData sU() {
        return this.aaS;
    }

    public aj sV() {
        return this.aaT;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        String g;
        SpannableString a;
        if (this.ZI == 1) {
            g = g(this.Zy, false);
            a = cL(this.Zy);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        SpannableStringBuilder a2 = a(g, a, z, true, z2);
        this.Zx = a2;
        return a2;
    }

    private ArrayList<m.a> c(boolean z, boolean z2, boolean z3) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean rG = rG();
        if (z2) {
            if (z) {
                if (rG && !ss()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if (rC() == 1 || getThreadType() == 33 || (rE() != null && rE().te() != 0)) {
                    if (rn() != null && sx()) {
                        if (sh() == 2) {
                            arrayList.add(new m.a(d.l.interview_live));
                        }
                    } else if (!rG) {
                        arrayList.add(new m.a(d.l.photo_live_tips));
                    }
                }
                if (rA() == 1) {
                    arrayList.add(new m.a(d.l.commit_top));
                }
                if (rB() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (sx()) {
                    arrayList.add(aaK.get(sh()));
                }
                if (sk()) {
                    Integer num = aaJ.get(new Point(sj(), si()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (sy()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (rR() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.al.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (rG && rA() != 1 && !ss()) {
                    arrayList.add(new m.a(d.l.god_title));
                }
                if ((rC() == 1 || getThreadType() == 33) && !sx() && !rG) {
                    arrayList.add(new m.a(d.l.photo_live_tips));
                }
                if (rB() == 1) {
                    arrayList.add(new m.a(d.l.good));
                }
                if (rA() == 1) {
                    arrayList.add(new m.a(d.l.commit_top));
                }
                if (sx() && rn() != null && sh() == 2) {
                    arrayList.add(new m.a(d.l.interview_live));
                }
                if (sk()) {
                    Integer num2 = aaJ.get(new Point(sj(), si()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), d.e.cp_other_b, d.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(d.l.card_promotion_text));
                    }
                }
                if (this.aau == 1) {
                    arrayList.add(new m.a(d.l.card_tbread_text));
                }
                if (rS() != null) {
                    arrayList.add(new m.a(d.l.send_app_code_gift, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (rR() != null) {
                    arrayList.add(new m.a(d.l.card_promotion_text, d.e.cp_other_b, d.g.pic_dot_title_red));
                }
                if (sy()) {
                    arrayList.add(new m.a(d.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.al.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && sK()) {
                    arrayList.add(new m.a(d.l.frs_ala_live_title_prefix));
                }
                if (sO()) {
                    arrayList.add(new m.a(d.l.frs_channel_tip));
                } else if (z3 && sM()) {
                    arrayList.add(new m.a(d.l.frs_ala_record_title_prefix));
                } else if (sL()) {
                    arrayList.add(new m.a(d.l.frs_video_title_prefix));
                }
            }
        }
        return arrayList;
    }

    public MediaData sW() {
        return this.aaW;
    }
}
