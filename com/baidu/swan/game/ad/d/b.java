package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class b {
    private static Map<String, String> dOg = new HashMap();

    static {
        dOg.put("100000", "请求格式错误");
        dOg.put("101000", "请求ID信息缺失");
        dOg.put("101001", "请求ID不符合约定格式");
        dOg.put("101002", "请求的trftp信息缺失");
        dOg.put("101003", "请求的sdk版本信息有误");
        dOg.put("101004", "请求的referer信息有误");
        dOg.put("101005", "请求的appid不合法");
        dOg.put("103000", "应用信息缺失");
        dOg.put("103010", "应用ID信息缺失");
        dOg.put("103011", "应用ID信息错误，MSSP未收录");
        dOg.put("103012", "应用ID无效，MSSP上未生效");
        dOg.put("103020", "应用ID无效，渠道ID信息错误");
        dOg.put("103030", "应用版本信息缺失");
        dOg.put("103040", "应用主版本信息缺失");
        dOg.put("103050", "应用操作系统信息缺失");
        dOg.put("103060", "应用包名信息错误，请保证注册包名和实际请求包名一致");
        dOg.put("104000", "设备信息缺失");
        dOg.put("104010", "设备类型信息缺失");
        dOg.put("104011", "设备类型信息错误");
        dOg.put("104020", "操作系统信息缺失");
        dOg.put("104021", "操作系统信息错误");
        dOg.put("104030", "操作系统版本信息缺失");
        dOg.put("104040", "操作系统主版本信息缺失");
        dOg.put("104050", "厂商信息缺失");
        dOg.put("104060", "设备型号信息缺失");
        dOg.put("104070", "设备唯一标识符缺失");
        dOg.put("104071", "设备唯一标识符错误");
        dOg.put("104080", "android id 缺失");
        dOg.put("104081", "android id 格式错误");
        dOg.put("104090", "设备屏幕尺寸信息缺失");
        dOg.put("104100", "设备屏幕尺寸宽度缺失");
        dOg.put("104110", "设备屏幕尺寸高度缺失");
        dOg.put("105000", "网络环境信息缺失");
        dOg.put("105010", "网络地址信息缺失");
        dOg.put("105011", "网络地址信息格式错误");
        dOg.put("105020", "网络连接类型缺失");
        dOg.put("105021", "网络连接类型错误");
        dOg.put("105030", "网络运营商类型缺失");
        dOg.put("105031", "网络运营商类型错误");
        dOg.put("105040", "Wi-Fi热点地址信息缺失");
        dOg.put("105041", "Wi-Fi热点地址信息格式错误");
        dOg.put("105050", "Wi-Fi热点信号强度信息缺失");
        dOg.put("105060", "Wi-Fi热点名称缺失");
        dOg.put("105070", "Wi-Fi连接状态信息缺失");
        dOg.put("106000", "坐标类型信息缺失");
        dOg.put("106001", "坐标类型信息错误");
        dOg.put("106010", "经度信息缺失");
        dOg.put("106020", "纬度信息缺失");
        dOg.put("106030", "定位时间戳信息缺失");
        dOg.put("107000", "广告位ID缺失");
        dOg.put("107001", "广告位ID未收录");
        dOg.put("107002", "广告位ID未启用");
        dOg.put("107003", "广告位ID与应用ID不匹配");
        dOg.put("107010", "广告位尺寸信息缺失");
        dOg.put("107020", "广告位尺寸宽度缺失");
        dOg.put("107030", "广告位尺寸高度缺失");
        dOg.put("107040", "广告位信息缺失");
        dOg.put("107050", "视频广告的网络条件无法满足");
        dOg.put("107051", "视频标题名称过长");
        dOg.put("107052", "SDK传递的广告位比例与MSSP的广告位比例不一致");
        dOg.put("200000", "无广告返回");
        dOg.put("201000", "无广告数据");
        dOg.put("201010", "广告无签名");
        dOg.put("201020", "广告创意类型信息缺失");
        dOg.put("201021", "广告创意类型信息无法识别");
        dOg.put("201030", "广告动作类型信息缺失");
        dOg.put("201031", "广告动作类型信息无法识别");
        dOg.put("201040", "曝光汇报地址丢失");
        dOg.put("201050", "点击响应地址丢失");
        dOg.put("201060", "推广标题丢失");
        dOg.put("201070", "推广描述丢失");
        dOg.put("201080", "推广应用包名丢失");
        dOg.put("201090", "推广应用包大小丢失");
        dOg.put("201100", "推广图标丢失");
        dOg.put("201110", "推广图片丢失");
        dOg.put("3010000", "广告组件挂载失败");
        dOg.put("3010001", "播放器内部错误");
        dOg.put("3010002", "广告请求失败");
        dOg.put("3010003", "网络连接错误");
        dOg.put("3010004", "没有可以展示的广告");
        dOg.put("3010005", "广告正在拉取中，不能重复请求");
        dOg.put("3010006", "广告正在展示中，不能请求广告");
        dOg.put("3010007", "gameId、appsid、adUnitid其中一个为空，不能请求广告");
        dOg.put("4010000", "广告组件准备完成");
        dOg.put("3010008", "播放地址为空");
        dOg.put("3010009", "激励视频重复调用create错误");
        dOg.put("3010010", "没有可以show的banner广告");
        dOg.put("3010011", "广告关闭生效中，本次请求被拒绝");
        dOg.put("3010012", "小游戏启动前%d秒不允许展示banner广告");
        dOg.put("3010013", "banner广告展示频控限制，%d秒内不允许重复展示banner广告");
    }

    public static String vL(String str) {
        String str2 = dOg.get(str);
        if (str2 == null) {
            str2 = "";
        }
        return cQ(str, str2);
    }

    public static String cQ(String str, String str2) {
        return TextUtils.equals("3010012", str) ? String.format(str2, Long.valueOf(com.baidu.swan.games.utils.c.aXu().aXx() / 1000)) : TextUtils.equals("3010013", str) ? String.format(str2, Long.valueOf(com.baidu.swan.games.utils.c.aXu().aXy() / 1000)) : str2;
    }
}
