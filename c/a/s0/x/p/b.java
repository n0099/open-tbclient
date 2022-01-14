package c.a.s0.x.p;

import android.content.Context;
import c.a.s0.c0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b implements c.a.s0.c0.a {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<Integer> f14198b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f14199c;

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, String> f14200d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1827740453, "Lc/a/s0/x/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1827740453, "Lc/a/s0/x/p/b;");
                return;
            }
        }
        a = new HashMap<>(200);
        f14198b = new ArrayList<>(180);
        f14199c = new HashMap<>(180);
        HashMap<String, String> hashMap = new HashMap<>(180);
        f14200d = hashMap;
        hashMap.put("image_emoticon", "呵呵");
        f14200d.put("image_emoticon2", "哈哈");
        f14200d.put("image_emoticon3", "吐舌");
        f14200d.put("image_emoticon4", "啊");
        f14200d.put("image_emoticon5", "酷");
        f14200d.put("image_emoticon6", "怒");
        f14200d.put("image_emoticon7", "开心");
        f14200d.put("image_emoticon8", "汗");
        f14200d.put("image_emoticon9", "泪");
        f14200d.put("image_emoticon10", "黑线");
        f14200d.put("image_emoticon11", "鄙视");
        f14200d.put("image_emoticon12", "不高兴");
        f14200d.put("image_emoticon13", "真棒");
        f14200d.put("image_emoticon14", "钱");
        f14200d.put("image_emoticon15", "疑问");
        f14200d.put("image_emoticon16", "阴险");
        f14200d.put("image_emoticon17", "吐");
        f14200d.put("image_emoticon18", "咦");
        f14200d.put("image_emoticon19", "委屈");
        f14200d.put("image_emoticon20", "花心");
        f14200d.put("image_emoticon21", "呼~");
        f14200d.put("image_emoticon22", "笑眼");
        f14200d.put("image_emoticon23", "冷");
        f14200d.put("image_emoticon24", "太开心");
        f14200d.put("image_emoticon25", "滑稽");
        f14200d.put("image_emoticon26", "勉强");
        f14200d.put("image_emoticon27", "狂汗");
        f14200d.put("image_emoticon28", "乖");
        f14200d.put("image_emoticon29", "睡觉");
        f14200d.put("image_emoticon30", "惊哭");
        f14200d.put("image_emoticon31", "生气");
        f14200d.put("image_emoticon32", "惊讶");
        f14200d.put("image_emoticon33", "喷");
        f14200d.put("image_emoticon34", "爱心");
        f14200d.put("image_emoticon35", "心碎");
        f14200d.put("image_emoticon36", "玫瑰");
        f14200d.put("image_emoticon37", "礼物");
        f14200d.put("image_emoticon38", "彩虹");
        f14200d.put("image_emoticon39", "星星月亮");
        f14200d.put("image_emoticon40", "太阳");
        f14200d.put("image_emoticon41", "钱币");
        f14200d.put("image_emoticon42", "灯泡");
        f14200d.put("image_emoticon43", "茶杯");
        f14200d.put("image_emoticon44", "蛋糕");
        f14200d.put("image_emoticon45", "音乐");
        f14200d.put("image_emoticon46", "haha");
        f14200d.put("image_emoticon47", "胜利");
        f14200d.put("image_emoticon48", "大拇指");
        f14200d.put("image_emoticon49", "弱");
        f14200d.put("image_emoticon50", StatHelper.SENSOR_OK);
        f14200d.put("image_emoticon61", "哼");
        f14200d.put("image_emoticon62", "吃瓜");
        f14200d.put("image_emoticon63", "扔便便");
        f14200d.put("image_emoticon64", "惊恐");
        f14200d.put("image_emoticon65", "哎呦");
        f14200d.put("image_emoticon66", "小乖");
        f14200d.put("image_emoticon67", "捂嘴笑");
        f14200d.put("image_emoticon68", "你懂的");
        f14200d.put("image_emoticon69", "what");
        f14200d.put("image_emoticon70", "酸爽");
        f14200d.put("image_emoticon71", "呀咩爹");
        f14200d.put("image_emoticon72", "笑尿");
        f14200d.put("image_emoticon73", "挖鼻");
        f14200d.put("image_emoticon74", "犀利");
        f14200d.put("image_emoticon75", "小红脸");
        f14200d.put("image_emoticon76", "懒得理");
        f14200d.put("image_emoticon77", "沙发");
        f14200d.put("image_emoticon78", "手纸");
        f14200d.put("image_emoticon79", "香蕉");
        f14200d.put("image_emoticon80", "便便");
        f14200d.put("image_emoticon81", "药丸");
        f14200d.put("image_emoticon82", "红领巾");
        f14200d.put("image_emoticon83", "蜡烛");
        f14200d.put("image_emoticon84", "三道杠");
        f14200d.put("image_emoticon85", "暗中观察");
        f14200d.put("image_emoticon86", "吃瓜");
        f14200d.put("image_emoticon87", "喝酒");
        f14200d.put("image_emoticon88", "嘿嘿嘿");
        f14200d.put("image_emoticon89", "噗");
        f14200d.put("image_emoticon90", "困成狗");
        f14200d.put("image_emoticon91", "微微一笑");
        f14200d.put("image_emoticon92", "托腮");
        f14200d.put("image_emoticon93", "摊手");
        f14200d.put("image_emoticon94", "柯基暗中观察");
        f14200d.put("image_emoticon95", "欢呼");
        f14200d.put("image_emoticon96", "炸药");
        f14200d.put("image_emoticon97", "突然兴奋");
        f14200d.put("image_emoticon98", "紧张");
        f14200d.put("image_emoticon99", "黑头瞪眼");
        f14200d.put("image_emoticon100", "黑头高兴");
        f14200d.put("image_emoticon125", "奥特曼");
        f14200d.put("image_emoticon126", "不听");
        f14200d.put("image_emoticon127", "干饭");
        f14200d.put("image_emoticon129", "菜狗");
        f14200d.put("image_emoticon128", "望远镜");
        f14200d.put("image_emoticon101", "不跟丑人说话");
        f14200d.put("image_emoticon102", "么么哒");
        f14200d.put("image_emoticon103", "亲亲才能起来");
        f14200d.put("image_emoticon104", "伦家只是宝宝");
        f14200d.put("image_emoticon105", "你是我的人");
        f14200d.put("image_emoticon106", "假装看不见");
        f14200d.put("image_emoticon107", "单身等撩");
        f14200d.put("image_emoticon108", "吓到宝宝了");
        f14200d.put("image_emoticon109", "哈哈哈");
        f14200d.put("image_emoticon110", "嗯嗯");
        f14200d.put("image_emoticon111", "好幸福");
        f14200d.put("image_emoticon112", "宝宝不开心");
        f14200d.put("image_emoticon113", "小姐姐别走");
        f14200d.put("image_emoticon114", "小姐姐在吗");
        f14200d.put("image_emoticon115", "小姐姐来啦");
        f14200d.put("image_emoticon116", "小姐姐来玩呀");
        f14200d.put("image_emoticon117", "我养你");
        f14200d.put("image_emoticon118", "我是不会骗你的");
        f14200d.put("image_emoticon119", "扎心了");
        f14200d.put("image_emoticon120", "无聊");
        f14200d.put("image_emoticon121", "月亮代表我的心");
        f14200d.put("image_emoticon122", "来追我呀");
        f14200d.put("image_emoticon123", "爱你的形状");
        f14200d.put("image_emoticon124", "白眼");
        f14200d.put("ali_001", "赖皮");
        f14200d.put("ali_002", "感动");
        f14200d.put("ali_003", "十分惊讶");
        f14200d.put("ali_004", "怒气");
        f14200d.put("ali_005", "哭泣");
        f14200d.put("ali_006", "吃惊");
        f14200d.put("ali_007", "嘲弄");
        f14200d.put("ali_008", "飘过");
        f14200d.put("ali_009", "转圈哭");
        f14200d.put("ali_010", "神经病");
        f14200d.put("ali_011", "揪耳朵");
        f14200d.put("ali_012", "惊汗");
        f14200d.put("ali_013", "隐身");
        f14200d.put("ali_014", "不要嘛");
        f14200d.put("ali_015", "遁");
        f14200d.put("ali_016", "不公平");
        f14200d.put("ali_017", "爬来了");
        f14200d.put("ali_018", "蛋花哭");
        f14200d.put("ali_019", "温暖");
        f14200d.put("ali_020", "点头");
        f14200d.put("ali_021", "撒钱");
        f14200d.put("ali_022", "献花");
        f14200d.put("ali_023", "寒");
        f14200d.put("ali_024", "傻笑");
        f14200d.put("ali_025", "扭扭");
        f14200d.put("ali_026", "疯");
        f14200d.put("ali_027", "抓狂");
        f14200d.put("ali_028", "抓");
        f14200d.put("ali_029", "蜷");
        f14200d.put("ali_030", "挠墙");
        f14200d.put("ali_031", "狂笑");
        f14200d.put("ali_032", "抱枕");
        f14200d.put("ali_033", "吼叫");
        f14200d.put("ali_034", "嚷");
        f14200d.put("ali_035", "唠叨");
        f14200d.put("ali_036", "捏脸");
        f14200d.put("ali_037", "爆笑");
        f14200d.put("ali_038", "郁闷");
        f14200d.put("ali_039", "潜水");
        f14200d.put("ali_040", "十分开心");
        f14200d.put("ali_041", "冷笑话");
        f14200d.put("ali_042", "顶！");
        f14200d.put("ali_043", "潜");
        f14200d.put("ali_044", "画圈圈");
        f14200d.put("ali_045", "玩电脑");
        f14200d.put("ali_046", "狂吐");
        f14200d.put("ali_047", "哭着跑");
        f14200d.put("ali_048", "阿狸侠");
        f14200d.put("ali_049", "冷死了");
        f14200d.put("ali_050", "惆怅~");
        f14200d.put("ali_051", "摸头");
        f14200d.put("ali_052", "蹭");
        f14200d.put("ali_053", "打滚");
        f14200d.put("ali_054", "叩拜");
        f14200d.put("ali_055", "摸");
        f14200d.put("ali_056", "数钱");
        f14200d.put("ali_057", "拖走");
        f14200d.put("ali_058", "热");
        f14200d.put("ali_059", "加1");
        f14200d.put("ali_060", "压力");
        f14200d.put("ali_061", "表逼我");
        f14200d.put("ali_062", "人呢");
        f14200d.put("ali_063", "摇晃");
        f14200d.put("ali_064", "打地鼠");
        f14200d.put("ali_065", "这个屌");
        f14200d.put("ali_066", "恐慌");
        f14200d.put("ali_067", "晕乎乎");
        f14200d.put("ali_068", "浮云");
        f14200d.put("ali_069", "给力");
        f14200d.put("ali_070", "杯具了");
        f14200d.put("b01", "微笑");
        f14200d.put("b02", "帅哥");
        f14200d.put("b03", "美女");
        f14200d.put("b04", "老大");
        f14200d.put("b05", "哈哈哈");
        f14200d.put("b06", "奸笑");
        f14200d.put("b07", "傻乐");
        f14200d.put("b08", "飞吻");
        f14200d.put("b09", "害羞");
        f14200d.put("b10", "花痴");
        f14200d.put("b11", "憧憬");
        f14200d.put("b12", "你牛");
        f14200d.put("b13", "鼓掌");
        f14200d.put("b14", "可爱");
        f14200d.put("b15", "太委屈");
        f14200d.put("b16", "大哭");
        f14200d.put("b17", "泪奔");
        f14200d.put("b18", "寻死");
        f14200d.put("b19", "非常惊讶");
        f14200d.put("b20", "表示疑问");
        f14200d.put("yz_001", "焦糖舞");
        f14200d.put("yz_002", "翻滚");
        f14200d.put("yz_003", "拍屁股做鬼脸");
        f14200d.put("yz_004", "不");
        f14200d.put("yz_005", "河蟹掉啦");
        f14200d.put("yz_006", "哦耶");
        f14200d.put("yz_007", "我倒");
        f14200d.put("yz_008", "投降");
        f14200d.put("shoubai_emoji_face_01", "微笑");
        f14200d.put("shoubai_emoji_face_02", "开心");
        f14200d.put("shoubai_emoji_face_03", "期待");
        f14200d.put("shoubai_emoji_face_04", "大笑");
        f14200d.put("shoubai_emoji_face_05", "鼓掌");
        f14200d.put("shoubai_emoji_face_06", "悠闲");
        f14200d.put("shoubai_emoji_face_07", "笑哭");
        f14200d.put("shoubai_emoji_face_08", "不要啊");
        f14200d.put("shoubai_emoji_face_09", "啊");
        f14200d.put("shoubai_emoji_face_10", "哟");
        f14200d.put("shoubai_emoji_face_11", "汗");
        f14200d.put("shoubai_emoji_face_12", "抠鼻");
        f14200d.put("shoubai_emoji_face_13", "哼");
        f14200d.put("shoubai_emoji_face_14", "发怒");
        f14200d.put("shoubai_emoji_face_15", "委屈");
        f14200d.put("shoubai_emoji_face_16", "不高兴");
        f14200d.put("shoubai_emoji_face_17", "囧");
        f14200d.put("shoubai_emoji_face_18", "惊哭");
        f14200d.put("shoubai_emoji_face_19", "大哭");
        f14200d.put("shoubai_emoji_face_20", "流泪");
        f14200d.put("shoubai_emoji_face_21", "害羞");
        f14200d.put("shoubai_emoji_face_22", "亲亲");
        f14200d.put("shoubai_emoji_face_23", "色");
        f14200d.put("shoubai_emoji_face_24", "舔屏");
        f14200d.put("shoubai_emoji_face_25", "得意");
        f14200d.put("shoubai_emoji_face_26", "疑问");
        f14200d.put("shoubai_emoji_face_27", "晕");
        f14200d.put("shoubai_emoji_face_28", "大哈");
        f14200d.put("shoubai_emoji_face_29", "二哈");
        f14200d.put("shoubai_emoji_face_30", "三哈");
        f14200d.put("shoubai_emoji_face_31", "白眼");
        f14200d.put("shoubai_emoji_face_32", "阴险");
        f14200d.put("shoubai_emoji_face_33", "你懂的");
        f14200d.put("shoubai_emoji_face_34", "偷笑");
        f14200d.put("shoubai_emoji_face_35", "睡觉");
        f14200d.put("shoubai_emoji_face_36", "哈欠");
        f14200d.put("shoubai_emoji_face_37", "再见");
        f14200d.put("shoubai_emoji_face_38", "鄙视");
        f14200d.put("shoubai_emoji_face_39", "抓狂");
        f14200d.put("shoubai_emoji_face_40", "咒骂");
        f14200d.put("shoubai_emoji_face_41", "衰");
        f14200d.put("shoubai_emoji_face_42", "骷髅");
        f14200d.put("shoubai_emoji_face_43", "嘘");
        f14200d.put("shoubai_emoji_face_44", "闭嘴");
        f14200d.put("shoubai_emoji_face_45", "呆");
        f14200d.put("shoubai_emoji_face_46", "什么鬼");
        f14200d.put("shoubai_emoji_face_47", "吐");
        f14200d.put("shoubai_emoji_face_48", "已阅");
        f14200d.put("shoubai_emoji_face_49", "同上");
        f14200d.put("shoubai_emoji_face_50", "友军");
        f14200d.put("shoubai_emoji_face_51", "爱钱");
        f14200d.put("shoubai_emoji_face_52", "Freestyle");
        f14200d.put("shoubai_emoji_face_53", "国宝");
        f14200d.put("shoubai_emoji_face_54", "羊驼");
        f14200d.put("shoubai_emoji_face_55", "鲜花");
        f14200d.put("shoubai_emoji_face_56", "中国加油");
        f14200d.put("shoubai_emoji_face_57", "庆祝");
        f14200d.put("shoubai_emoji_face_58", "生日蛋糕");
        f14200d.put("shoubai_emoji_face_59", "MicDrop");
        f14200d.put("shoubai_emoji_face_60", "赞同");
        f14200d.put("shoubai_emoji_face_61", "药丸");
        f14200d.put("shoubai_emoji_face_62", "蜡烛");
        f14200d.put("shoubai_emoji_face_63", "鸡蛋");
        f14200d.put("shoubai_emoji_face_64", "浪");
        f14200d.put("shoubai_emoji_face_65", "打call");
        f14200d.put("shoubai_emoji_face_66", "尬笑");
        f14200d.put("shoubai_emoji_face_67", "坏笑");
        f14200d.put("shoubai_emoji_face_68", "没眼看");
        f14200d.put("shoubai_emoji_face_69", "嘿哈");
        f14200d.put("shoubai_emoji_face_70", "前面的别走");
        f14200d.put("shoubai_emoji_face_71", "滑稽");
        f14200d.put("shoubai_emoji_face_72", "捂脸");
        f14200d.put("shoubai_emoji_face_73", "左捂脸");
        f14200d.put("shoubai_emoji_face_74", "666");
        f14200d.put("shoubai_emoji_face_75", "2018");
        f14200d.put("shoubai_emoji_face_76", "福");
        f14200d.put("shoubai_emoji_face_77", "红包");
        f14200d.put("shoubai_emoji_face_78", "鞭炮");
        f14200d.put("shoubai_emoji_face_79", "财神");
        f14200d.put("shoubai_emoji_face_80", "饺子");
        f14200d.put("shoubai_emoji_face_81", "车票");
        f14200d.put("shoubai_emoji_face_82", "火车");
        f14200d.put("shoubai_emoji_face_83", "飞机");
        f14200d.put("shoubai_emoji_face_84", "射门");
        f14200d.put("shoubai_emoji_face_85", "红牌");
        f14200d.put("shoubai_emoji_face_86", "黄牌");
        f14200d.put("shoubai_emoji_face_87", "哨子");
        f14200d.put("shoubai_emoji_face_88", "比分");
        f14200d.put("shoubai_emoji_face_89", "啤酒");
        f14200d.put("shoubai_emoji_face_90", "足球");
        f14200d.put("shoubai_emoji_face_91", "大力神杯");
        f14200d.put("shoubai_emoji_face_92", "锦鲤");
        f14200d.put("shoubai_emoji_face_93", "2019");
        f14200d.put("shoubai_emoji_face_94", "猪年");
        f14200d.put("shoubai_emoji_face_95", "双手鼓掌");
        f14200d.put("shoubai_emoji_face_96", "火焰");
        f14200d.put("shoubai_emoji_face_97", "祈福");
        f14200d.put("shoubai_emoji_face_98", "亲吻");
        f14200d.put("shoubai_emoji_face_99", "天使");
        f14200d.put("shoubai_emoji_face_100", "樱花");
        f14200d.put("shoubai_emoji_face_101", "加油");
        f14200d.put("shoubai_emoji_face_102", "泡泡枪");
        f14200d.put("shoubai_emoji_face_103", "气球");
        f14200d.put("shoubai_emoji_face_104", "棒棒糖");
        f14200d.put("shoubai_emoji_face_105", "小黄鸭");
        f14200d.put("shoubai_emoji_face_106", "粽子");
        f14200d.put("bearchildren_01", "熊-88");
        f14200d.put("bearchildren_02", "熊-HI");
        f14200d.put("bearchildren_03", "熊-人艰不拆");
        f14200d.put("bearchildren_04", "熊-啥");
        f14200d.put("bearchildren_05", "熊-大哭");
        f14200d.put("bearchildren_06", "熊-失落");
        f14200d.put("bearchildren_07", "熊-怒赞");
        f14200d.put("bearchildren_08", "熊-惊呆了");
        f14200d.put("bearchildren_09", "熊-李菊福");
        f14200d.put("bearchildren_10", "熊-来信砍");
        f14200d.put("bearchildren_11", "熊-欢迎入群");
        f14200d.put("bearchildren_12", "熊-牛闪闪");
        f14200d.put("bearchildren_13", "熊-生日快乐");
        f14200d.put("bearchildren_14", "熊-石化");
        f14200d.put("bearchildren_15", "熊-羞羞哒");
        f14200d.put("bearchildren_16", "熊-肥皂必杀");
        f14200d.put("bearchildren_17", "熊-谢谢你");
        f14200d.put("bearchildren_18", "熊-跳舞");
        f14200d.put("bearchildren_19", "熊-霹雳舞");
        f14200d.put("bearchildren_20", "熊-鼓掌");
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.s0.c0.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f14198b.size() : invokeV.intValue;
    }

    @Override // c.a.s0.c0.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? f14200d.get(str) : (String) invokeL.objValue;
    }

    @Override // c.a.s0.c0.a
    public a.C0826a c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            return null;
        }
        return (a.C0826a) invokeLL.objValue;
    }

    @Override // c.a.s0.c0.a
    public int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Integer num = a.get(str);
            if ("video_icon".equals(str)) {
                return Integer.valueOf(R.drawable.ico_link_video).intValue();
            }
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // c.a.s0.c0.a
    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Integer num = f14199c.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
