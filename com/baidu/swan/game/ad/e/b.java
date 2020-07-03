package com.baidu.swan.game.ad.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    private static Map<String, String> cWm = new HashMap();

    static {
        cWm.put("100000", "请求格式错误");
        cWm.put("101000", "请求ID信息缺失");
        cWm.put("101001", "请求ID不符合约定格式");
        cWm.put("101002", "请求的trftp信息缺失");
        cWm.put("101003", "请求的sdk版本信息有误");
        cWm.put("101004", "请求的referer信息有误");
        cWm.put("101005", "请求的appid不合法");
        cWm.put("103000", "应用信息缺失");
        cWm.put("103010", "应用ID信息缺失");
        cWm.put("103011", "应用ID信息错误，MSSP未收录");
        cWm.put("103012", "应用ID无效，MSSP上未生效");
        cWm.put("103020", "应用ID无效，渠道ID信息错误");
        cWm.put("103030", "应用版本信息缺失");
        cWm.put("103040", "应用主版本信息缺失");
        cWm.put("103050", "应用操作系统信息缺失");
        cWm.put("103060", "应用包名信息错误，请保证注册包名和实际请求包名一致");
        cWm.put("104000", "设备信息缺失");
        cWm.put("104010", "设备类型信息缺失");
        cWm.put("104011", "设备类型信息错误");
        cWm.put("104020", "操作系统信息缺失");
        cWm.put("104021", "操作系统信息错误");
        cWm.put("104030", "操作系统版本信息缺失");
        cWm.put("104040", "操作系统主版本信息缺失");
        cWm.put("104050", "厂商信息缺失");
        cWm.put("104060", "设备型号信息缺失");
        cWm.put("104070", "设备唯一标识符缺失");
        cWm.put("104071", "设备唯一标识符错误");
        cWm.put("104080", "android id 缺失");
        cWm.put("104081", "android id 格式错误");
        cWm.put("104090", "设备屏幕尺寸信息缺失");
        cWm.put("104100", "设备屏幕尺寸宽度缺失");
        cWm.put("104110", "设备屏幕尺寸高度缺失");
        cWm.put("105000", "网络环境信息缺失");
        cWm.put("105010", "网络地址信息缺失");
        cWm.put("105011", "网络地址信息格式错误");
        cWm.put("105020", "网络连接类型缺失");
        cWm.put("105021", "网络连接类型错误");
        cWm.put("105030", "网络运营商类型缺失");
        cWm.put("105031", "网络运营商类型错误");
        cWm.put("105040", "Wi-Fi热点地址信息缺失");
        cWm.put("105041", "Wi-Fi热点地址信息格式错误");
        cWm.put("105050", "Wi-Fi热点信号强度信息缺失");
        cWm.put("105060", "Wi-Fi热点名称缺失");
        cWm.put("105070", "Wi-Fi连接状态信息缺失");
        cWm.put("106000", "坐标类型信息缺失");
        cWm.put("106001", "坐标类型信息错误");
        cWm.put("106010", "经度信息缺失");
        cWm.put("106020", "纬度信息缺失");
        cWm.put("106030", "定位时间戳信息缺失");
        cWm.put("107000", "广告位ID缺失");
        cWm.put("107001", "广告位ID未收录");
        cWm.put("107002", "广告位ID未启用");
        cWm.put("107003", "广告位ID与应用ID不匹配");
        cWm.put("107010", "广告位尺寸信息缺失");
        cWm.put("107020", "广告位尺寸宽度缺失");
        cWm.put("107030", "广告位尺寸高度缺失");
        cWm.put("107040", "广告位信息缺失");
        cWm.put("107050", "视频广告的网络条件无法满足");
        cWm.put("107051", "视频标题名称过长");
        cWm.put("107052", "SDK传递的广告位比例与MSSP的广告位比例不一致");
        cWm.put("200000", "无广告返回");
        cWm.put("201000", "无广告数据");
        cWm.put("201010", "广告无签名");
        cWm.put("201020", "广告创意类型信息缺失");
        cWm.put("201021", "广告创意类型信息无法识别");
        cWm.put("201030", "广告动作类型信息缺失");
        cWm.put("201031", "广告动作类型信息无法识别");
        cWm.put("201040", "曝光汇报地址丢失");
        cWm.put("201050", "点击响应地址丢失");
        cWm.put("201060", "推广标题丢失");
        cWm.put("201070", "推广描述丢失");
        cWm.put("201080", "推广应用包名丢失");
        cWm.put("201090", "推广应用包大小丢失");
        cWm.put("201100", "推广图标丢失");
        cWm.put("201110", "推广图片丢失");
        cWm.put("3010000", "广告组件挂载失败");
        cWm.put("3010001", "播放器内部错误");
        cWm.put("3010002", "广告请求失败");
        cWm.put("3010003", "网络连接错误");
        cWm.put("3010004", "没有可以展示的广告");
        cWm.put("3010005", "广告正在拉取中，不能重复请求");
        cWm.put("3010006", "广告正在展示中，不能请求广告");
        cWm.put("3010007", "gameId、appsid、adUnitid其中一个为空，不能请求广告");
        cWm.put("4010000", "广告组件准备完成");
        cWm.put("3010008", "播放地址为空");
        cWm.put("3010009", "激励视频重复调用create错误");
        cWm.put("3010010", "没有可以show的banner广告");
        cWm.put("3010011", "广告关闭生效中，本次请求被拒绝");
        cWm.put("3010012", "小游戏启动前%d秒不允许展示banner广告");
        cWm.put("3010013", "banner广告展示频控限制，%d秒内不允许重复展示banner广告");
    }

    public static String qL(String str) {
        String str2 = cWm.get(str);
        if (str2 == null) {
            str2 = "";
        }
        return ch(str, str2);
    }

    public static String ch(String str, String str2) {
        return TextUtils.equals("3010012", str) ? String.format(str2, Long.valueOf(com.baidu.swan.games.utils.c.aDi().aDl() / 1000)) : TextUtils.equals("3010013", str) ? String.format(str2, Long.valueOf(com.baidu.swan.games.utils.c.aDi().aDm() / 1000)) : str2;
    }
}
