package com.baidu.mobads.container.error;

import com.baidu.sapi2.result.OneKeyLoginResult;
/* loaded from: classes2.dex */
public enum XAdErrorCode {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    WEBVIEW_LOAD_ERROR(1010002, "web载入异常"),
    VIEWKIT_PUT_PROBLEM(1010003, "控件摆放问题"),
    VIEWKIT_TOO_SMALL(1010004, "控件过小"),
    NETWORK_UNCONNECT(1020001, "网络连接问题"),
    PERMISSION_PROBLEM(1030002, "权限设置问题"),
    SETTINGS_ERROR(1030002, "设置问题"),
    REQUEST_PARAM_ERROR(1040001, "请求参数问题"),
    REQUEST_URL_TOO_LONG(1040002, "请求串过长"),
    REQUEST_TIMEOUT(1040003, OneKeyLoginResult.m),
    REQUEST_STATUS_CODE_ERROR(1040004, "状态码异常"),
    RESPONSE_PARSE_FAILED(3010001, "清单解析失败"),
    RESPONSE_FIELD_LESS(3010002, "清单缺少字段"),
    RESPONSE_MTYPE_UNSUPPORT(3010003, "物料类型不支持"),
    RESPONSE_ATYPE_UNSUPPORT(3010004, "跳转类型不支持"),
    RESPONSE_HTML_ERROR(3010005, "广告服务器返回的html内容错误, AD-SDK无法渲染该广告"),
    FILTER_APP_INSTALLED(3020001, "推广应用已被安装"),
    FILTER_APP_UNINSTALLED(3020002, "推广应用未被安装"),
    MCACHE_PREPARE_FAILED(3030001, "缓存准备失败"),
    MCACHE_FETCH_FAILED(3030002, "缓存物料失败"),
    SHOW_STANDARD_UNFIT(3040001, "广告展现标准不达标"),
    SHOW_PROCESS_FAILED(3040002, "广告展现失败"),
    CLICK_PARSE_FAILED(4010001, "点击信息解析失败"),
    CLICK_FIELD_LESS(4010002, "点击信息缺失"),
    CLICK_FIELD_ERROR(4010003, "点击信息有误"),
    CLICK_JUMP_FAILED(4010004, "点击跳转失败"),
    LOADING_LP_ERROR(4020001, "打开LP问题"),
    LOADING_DL_ERROR(4020002, "下载器问题"),
    MONITOR_START_FAILED(4030001, "监控启动失败"),
    ADELEMENT_PARSE_ERROR(4030002, "response json parsing error"),
    AD_REQUEST_ERROR(4030003, "request ad-server error, io_err/timeout"),
    AD_CONTAINER_NULL(4030004, "create container is null"),
    SPLASH_VIDEO_NO_EXISTS(4030005, "开屏因为请求到未在wifi下缓存的视频广告跳过"),
    REWARD_VIDEO_URL_EMPTY(4030006, "激励视频广告视频url为空");
    
    public static final String ERROR_CODE_MESSAGE = "msg";
    public int code;
    public String msg;

    XAdErrorCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }
}
