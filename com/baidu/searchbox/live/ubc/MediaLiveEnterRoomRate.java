package com.baidu.searchbox.live.ubc;

import com.baidu.live.arch.utils.MiniPluginUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.LiveSessionService;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.ILivePageInfoInterface;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\bm\u0010nJM\u0010\t\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJe\u0010\t\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\t\u0010\rJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0014\u0010\u0010JK\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001c\u0010\u001bJ5\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001d\u0010\u001bJ5\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001e\u0010\u001bJ5\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ5\u0010 \u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b \u0010\u001bJ?\u0010 \u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010\u0010J5\u0010#\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b#\u0010\u001bJ5\u0010$\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b$\u0010\u001bJ5\u0010%\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b%\u0010\u001bJ!\u0010&\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b&\u0010\u0010J5\u0010'\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b'\u0010\u001bJ5\u0010(\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b(\u0010\u001bJ5\u0010)\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b)\u0010\u001bJ+\u0010*\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b*\u0010+Ja\u0010*\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u00100J?\u0010*\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b*\u0010!JW\u0010*\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b*\u00101J=\u00102\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b2\u0010!J\u0011\u00103\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0016H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0016H\u0002¢\u0006\u0004\b7\u00106R\u0016\u00108\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010<\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u00109R\u0016\u0010=\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010>\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u00109R\u0016\u0010?\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010@\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u00109R\u0016\u0010A\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010B\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u00109R\u0016\u0010C\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u00109R\u0016\u0010D\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u00109R\u0016\u0010E\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u00109R\u0016\u0010F\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u00109R\u0016\u0010G\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u00109R\u0016\u0010H\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u00109R\u0016\u0010I\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u00109R\u0016\u0010J\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u00109R\u0016\u0010K\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u00109R\u0016\u0010L\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u00109R\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010QR\u0016\u0010S\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010T\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010QR\u0016\u0010U\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010QR\u0016\u0010V\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010QR\u0016\u0010W\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010QR\u0016\u0010X\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010QR\u0016\u0010Y\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010QR\u0016\u0010Z\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010QR\u0016\u0010[\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010QR\u0016\u0010\\\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010QR\u0016\u0010]\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010QR\u0016\u0010^\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010QR\u0016\u0010_\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010QR\u0016\u0010`\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010QR\u0016\u0010a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010QR\u0016\u0010b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010QR\u0018\u0010c\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u001e\u0010g\u001a\n f*\u0004\u0018\u00010e0e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010i\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010OR\u001e\u0010k\u001a\n f*\u0004\u0018\u00010j0j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006o"}, d2 = {"Lcom/baidu/searchbox/live/ubc/MediaLiveEnterRoomRate;", "", "roomId", "value", "status", StatConstants.KEY_EXT_ERR_MSG, "source", "logid", "Lorg/json/JSONObject;", "buildSimpleContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", FlowInfoHelper.KEY_IS_COLDLAUNCH, "businessPluginStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", "", "clearFlag", "(Ljava/lang/String;Ljava/lang/String;)V", "apiName", "doEnterFirstSegmentApiError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "doEnterFirstSegmentCancel", "enterType", "", "media", "doEnterFirstSegmentEnd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "doEnterFirstSegmentInit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "doEnterFirstSegmentOtherError", "doEnterFirstSegmentPluginLoadError", "doEnterFirstSegmentPluginYYLoadError", "doEnterFirstSegmentTemplateNotMatchError", "doEnterSecondSegmentApiRequestError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "doEnterSecondSegmentCancel", "doEnterSecondSegmentInit", "doEnterSecondSegmentInitOtherLive", "doEnterSecondSegmentOtherError", "doEnterSecondSegmentPlugin2LoadSuccessAfterCancel", "doEnterSecondSegmentPluginLoadError", "doEnterSecondSegmentSuccess", "doEnterSecondSegmentTempateNotMatch", "doEnterUbcByRequestEnter", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "useCache", "", "error", "extjson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lorg/json/JSONObject;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "doEnterUbcByRequestEnterRealNet", "getTopPluginVersion", "()Ljava/lang/String;", "isFirstSegmentShutDown", "()Z", "isSecondSegmentShutDown", "ENTER_ROOM_RATE_FIRST_API_REQUEST_ERROR", "Ljava/lang/String;", "ENTER_ROOM_RATE_FIRST_INIT", "ENTER_ROOM_RATE_FIRST_OTHER_ERROR", "ENTER_ROOM_RATE_FIRST_PLUGIN_LOAD", "ENTER_ROOM_RATE_FIRST_PLUGIN_YY_LOAD", "ENTER_ROOM_RATE_FIRST_SEGEMNT_CANCEL", "ENTER_ROOM_RATE_FIRST_TEMPLATE_NOT_MATCH", "ENTER_ROOM_RATE_LIVE_ALL", "ENTER_ROOM_RATE_LIVE_OTHER", "ENTER_ROOM_RATE_OLD_ARCH", "ENTER_ROOM_RATE_SECOND_API_REQUEST_ERROR", "ENTER_ROOM_RATE_SECOND_INIT", "ENTER_ROOM_RATE_SECOND_OTHER_ERROR", "ENTER_ROOM_RATE_SECOND_PLUGIN_LOAD", "ENTER_ROOM_RATE_SECOND_SEGEMNT_CANCEL", "ENTER_ROOM_RATE_SECOND_SEGEMNT_END", "ENTER_ROOM_RATE_SECOND_SEGEMNT_REQ_START", "ENTER_ROOM_RATE_SECOND_TEMPLATE_NOT_MATCH", "UBC_FIRST_JUMP_REQ_END", "UBC_FIRST_JUMP_REQ_START", "", "firstSegmentTime", "J", "hasApiRequestSuccess", "Z", "hasFirstCancelReported", "hasFirstSegmentFinish", "hasFirstSegmentOtherLiveRecord", "hasFirstSegmentSetup", "hasLoadFirstPluginSuccess", "hasLoadFirstPluginYYSuccess", "hasLoadSecondPluginSuccess", "hasOtherFunctionFail", "hasRecordReqEnd", "hasRecordReqStart", "hasSecondApiRequestSuccess", "hasSecondCancelReported", "hasSecondOtherFunctionFail", "hasSecondSegmentFinish", "hasSecondSegmentSetup", "hasSecondTemplateMatch", "hasTemplateMatch", "isInsertVideo", "Ljava/lang/Boolean;", "Lcom/baidu/searchbox/live/interfaces/service/LiveSessionService;", "kotlin.jvm.PlatformType", "liveSessionService", "Lcom/baidu/searchbox/live/interfaces/service/LiveSessionService;", "secondSegmentTime", "Lcom/baidu/ubc/UBCManager;", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class MediaLiveEnterRoomRate {
    public static final String ENTER_ROOM_RATE_FIRST_API_REQUEST_ERROR = "api1_error";
    public static final String ENTER_ROOM_RATE_FIRST_INIT = "init";
    public static final String ENTER_ROOM_RATE_FIRST_OTHER_ERROR = "first_other_error";
    public static final String ENTER_ROOM_RATE_FIRST_PLUGIN_LOAD = "plugin1_error";
    public static final String ENTER_ROOM_RATE_FIRST_PLUGIN_YY_LOAD = "plugin1_yy_error";
    public static final String ENTER_ROOM_RATE_FIRST_SEGEMNT_CANCEL = "first_cancel";
    public static final String ENTER_ROOM_RATE_FIRST_TEMPLATE_NOT_MATCH = "template_not_match";
    public static final String ENTER_ROOM_RATE_LIVE_ALL = "live_all";
    public static final String ENTER_ROOM_RATE_LIVE_OTHER = "live_other";
    public static final String ENTER_ROOM_RATE_OLD_ARCH = "enter_room_rate_old_arch";
    public static final String ENTER_ROOM_RATE_SECOND_API_REQUEST_ERROR = "api2_error";
    public static final String ENTER_ROOM_RATE_SECOND_INIT = "media";
    public static final String ENTER_ROOM_RATE_SECOND_OTHER_ERROR = "second_other_error";
    public static final String ENTER_ROOM_RATE_SECOND_PLUGIN_LOAD = "plugin2_error";
    public static final String ENTER_ROOM_RATE_SECOND_SEGEMNT_CANCEL = "second_cancel";
    public static final String ENTER_ROOM_RATE_SECOND_SEGEMNT_END = "req_end";
    public static final String ENTER_ROOM_RATE_SECOND_SEGEMNT_REQ_START = "req_start";
    public static final String ENTER_ROOM_RATE_SECOND_TEMPLATE_NOT_MATCH = "template2_not_match";
    public static final String UBC_FIRST_JUMP_REQ_END = "enter_live_real_req_end";
    public static final String UBC_FIRST_JUMP_REQ_START = "enter_live_real_req_start";
    public static long firstSegmentTime;
    public static boolean hasApiRequestSuccess;
    public static boolean hasFirstCancelReported;
    public static boolean hasFirstSegmentFinish;
    public static boolean hasFirstSegmentOtherLiveRecord;
    public static boolean hasFirstSegmentSetup;
    public static boolean hasLoadFirstPluginSuccess;
    public static boolean hasLoadFirstPluginYYSuccess;
    public static boolean hasLoadSecondPluginSuccess;
    public static boolean hasOtherFunctionFail;
    public static boolean hasRecordReqEnd;
    public static boolean hasRecordReqStart;
    public static boolean hasSecondApiRequestSuccess;
    public static boolean hasSecondCancelReported;
    public static boolean hasSecondOtherFunctionFail;
    public static boolean hasSecondSegmentFinish;
    public static boolean hasSecondSegmentSetup;
    public static boolean hasSecondTemplateMatch;
    public static boolean hasTemplateMatch;
    public static Boolean isInsertVideo;
    public static long secondSegmentTime;
    public static final MediaLiveEnterRoomRate INSTANCE = new MediaLiveEnterRoomRate();
    public static final UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public static final LiveSessionService liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());

    static {
        Boolean bool;
        ILivePageInfoInterface iLivePageInfoInterface = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
        if (iLivePageInfoInterface != null) {
            bool = Boolean.valueOf(iLivePageInfoInterface.isInsertVideo());
        } else {
            bool = null;
        }
        isInsertVideo = bool;
        hasLoadFirstPluginSuccess = true;
        hasLoadFirstPluginYYSuccess = true;
        hasApiRequestSuccess = true;
        hasTemplateMatch = true;
        hasLoadSecondPluginSuccess = true;
        hasSecondApiRequestSuccess = true;
        hasSecondTemplateMatch = true;
    }

    private final String getTopPluginVersion() {
        String valueOf;
        PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
        if (pluginMgrService == null || (valueOf = String.valueOf(pluginMgrService.getPluginVersionCode("com.baidu.searchbox.livenps"))) == null) {
            return "0";
        }
        return valueOf;
    }

    private final boolean isFirstSegmentShutDown() {
        if (!hasFirstSegmentFinish && hasTemplateMatch && hasLoadFirstPluginYYSuccess && !hasFirstCancelReported && hasApiRequestSuccess) {
            return false;
        }
        return true;
    }

    private final boolean isSecondSegmentShutDown() {
        if (!hasSecondSegmentFinish && !hasSecondCancelReported && hasSecondApiRequestSuccess && hasLoadSecondPluginSuccess && !hasFirstSegmentOtherLiveRecord) {
            return false;
        }
        return true;
    }

    private final JSONObject buildSimpleContent(String str, String str2, String str3, String str4, String str5, String str6) {
        return buildSimpleContent(str, str2, str3, str4, str5, str6, null, null);
    }

    public final void doEnterFirstSegmentApiError(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!hasFirstSegmentSetup || hasFirstSegmentFinish) {
            return;
        }
        hasApiRequestSuccess = false;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("logid", str5);
        jSONObject.put("api_name", str6);
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_FIRST_API_REQUEST_ERROR, str2, false, str4, null, str3, jSONObject);
    }

    private final JSONObject buildSimpleContent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            jSONObject.put("type", "enter_live");
            jSONObject.put("value", str2);
            jSONObject.put("source", str5);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str);
            jSONObject2.put("status", str3);
            jSONObject2.put("useCache", 0);
            jSONObject2.put("error", 0);
            if (str4 != null) {
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, str4);
            }
            if (str7 != null) {
                jSONObject2.put(FlowInfoHelper.KEY_IS_COLDLAUNCH, str7);
            }
            if (str8 != null) {
                jSONObject2.put("bPluginStatus", str8);
            }
            jSONObject2.put("live_version", String.valueOf(MiniPluginUtils.INSTANCE.getComponentInstalledVersion("com.baidu.searchbox.livenps")));
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static /* synthetic */ JSONObject buildSimpleContent$default(MediaLiveEnterRoomRate mediaLiveEnterRoomRate, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 32) != 0) {
            str6 = null;
        }
        return mediaLiveEnterRoomRate.buildSimpleContent(str, str2, str3, str4, str5, str6);
    }

    public static /* synthetic */ void doEnterFirstSegmentEnd$default(MediaLiveEnterRoomRate mediaLiveEnterRoomRate, String str, String str2, String str3, String str4, String str5, Boolean bool, int i, Object obj) {
        if ((i & 32) != 0) {
            bool = Boolean.TRUE;
        }
        mediaLiveEnterRoomRate.doEnterFirstSegmentEnd(str, str2, str3, str4, str5, bool);
    }

    public static /* synthetic */ JSONObject buildSimpleContent$default(MediaLiveEnterRoomRate mediaLiveEnterRoomRate, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        String str9;
        String str10;
        String str11;
        if ((i & 32) != 0) {
            str9 = null;
        } else {
            str9 = str6;
        }
        if ((i & 64) != 0) {
            str10 = null;
        } else {
            str10 = str7;
        }
        if ((i & 128) != 0) {
            str11 = null;
        } else {
            str11 = str8;
        }
        return mediaLiveEnterRoomRate.buildSimpleContent(str, str2, str3, str4, str5, str9, str10, str11);
    }

    public static /* synthetic */ void doEnterUbcByRequestEnter$default(MediaLiveEnterRoomRate mediaLiveEnterRoomRate, String str, String str2, String str3, boolean z, String str4, Integer num, String str5, JSONObject jSONObject, int i, Object obj) {
        Integer num2;
        String str6;
        JSONObject jSONObject2;
        if ((i & 32) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i & 64) != 0) {
            str6 = null;
        } else {
            str6 = str5;
        }
        if ((i & 128) != 0) {
            jSONObject2 = null;
        } else {
            jSONObject2 = jSONObject;
        }
        mediaLiveEnterRoomRate.doEnterUbcByRequestEnter(str, str2, str3, z, str4, num2, str6, jSONObject2);
    }

    public static /* synthetic */ void doEnterUbcByRequestEnter$default(MediaLiveEnterRoomRate mediaLiveEnterRoomRate, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        String str8;
        String str9;
        if ((i & 32) != 0) {
            str8 = null;
        } else {
            str8 = str6;
        }
        if ((i & 64) != 0) {
            str9 = null;
        } else {
            str9 = str7;
        }
        mediaLiveEnterRoomRate.doEnterUbcByRequestEnter(str, str2, str3, str4, str5, str8, str9);
    }

    public final void clearFlag(String str, String str2) {
        doEnterFirstSegmentCancel(str, str2);
        doEnterSecondSegmentCancel(str, str2);
        hasRecordReqEnd = false;
        hasRecordReqStart = false;
        firstSegmentTime = 0L;
        secondSegmentTime = 0L;
        hasFirstSegmentSetup = false;
        hasLoadFirstPluginSuccess = true;
        hasLoadFirstPluginYYSuccess = true;
        hasApiRequestSuccess = true;
        hasOtherFunctionFail = false;
        hasFirstSegmentFinish = false;
        hasTemplateMatch = true;
        hasSecondSegmentFinish = false;
        hasLoadSecondPluginSuccess = true;
        hasSecondApiRequestSuccess = true;
        hasSecondOtherFunctionFail = false;
        hasSecondSegmentSetup = false;
        hasSecondCancelReported = false;
        hasFirstCancelReported = false;
        hasSecondTemplateMatch = true;
        hasFirstSegmentOtherLiveRecord = false;
    }

    public final void doEnterFirstSegmentCancel(String str, String str2) {
        if (!hasFirstSegmentSetup || !hasLoadFirstPluginSuccess || !hasApiRequestSuccess || hasOtherFunctionFail || hasFirstSegmentFinish || !hasTemplateMatch || hasFirstCancelReported) {
            return;
        }
        hasFirstCancelReported = true;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("first_cancel_time", System.currentTimeMillis() - firstSegmentTime);
        jSONObject.put("hasLoadFirstPluginSuccess", hasLoadFirstPluginSuccess);
        jSONObject.put("hasApiRequestSuccess", hasApiRequestSuccess);
        jSONObject.put("hasOtherFunctionFail", hasApiRequestSuccess);
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_FIRST_SEGEMNT_CANCEL, "", false, str2, 0, "", jSONObject);
    }

    public final void doEnterSecondSegmentPlugin2LoadSuccessAfterCancel(String str, String str2) {
        if (!hasSecondSegmentSetup || !hasFirstSegmentFinish || !hasLoadSecondPluginSuccess || hasSecondOtherFunctionFail || hasSecondSegmentFinish || hasSecondCancelReported) {
            return;
        }
        hasSecondCancelReported = true;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("second_cancel_time", System.currentTimeMillis() - secondSegmentTime);
        jSONObject.put("second_load_success", "1");
        jSONObject.put("hasFirstSegmentFinish", hasFirstSegmentFinish);
        jSONObject.put("hasLoadSecondPluginSuccess", hasLoadSecondPluginSuccess);
        jSONObject.put("hasSecondOtherFunctionFail", hasSecondOtherFunctionFail);
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_SECOND_SEGEMNT_CANCEL, "", false, str2, 0, "", jSONObject);
    }

    public final void doEnterFirstSegmentEnd(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        if (!hasFirstSegmentSetup || hasFirstSegmentFinish) {
            return;
        }
        hasFirstSegmentFinish = true;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enterType", str5);
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_LIVE_ALL, str2, false, str4, null, str3, jSONObject);
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            doEnterSecondSegmentInit(str, str2, str3, str4);
        } else {
            doEnterSecondSegmentInitOtherLive(str, str2, str3, str4);
        }
    }

    public final void doEnterFirstSegmentInit(String str, String str2, String str3, String str4) {
        if (hasFirstSegmentSetup) {
            return;
        }
        firstSegmentTime = System.currentTimeMillis();
        hasFirstSegmentSetup = true;
        JSONObject buildSimpleContent$default = buildSimpleContent$default(this, str, "init", str2, str3, str4, null, 32, null);
        if (Intrinsics.areEqual(isInsertVideo, Boolean.FALSE)) {
            ubcManager.onEvent("5153", buildSimpleContent$default);
        }
    }

    public final void doEnterFirstSegmentOtherError(String str, String str2, String str3, String str4) {
        if (!hasFirstSegmentSetup) {
            return;
        }
        hasOtherFunctionFail = true;
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_FIRST_OTHER_ERROR, str2, false, str4, null, str3, null);
    }

    public final void doEnterFirstSegmentPluginLoadError(String str, String str2, String str3, String str4) {
        if (!hasFirstSegmentSetup) {
            return;
        }
        hasLoadFirstPluginSuccess = false;
        JSONObject buildSimpleContent$default = buildSimpleContent$default(this, str, ENTER_ROOM_RATE_FIRST_PLUGIN_LOAD, str2, str3, str4, null, 32, null);
        if (Intrinsics.areEqual(isInsertVideo, Boolean.FALSE)) {
            ubcManager.onEvent("5153", buildSimpleContent$default);
        }
    }

    public final void doEnterFirstSegmentPluginYYLoadError(String str, String str2, String str3, String str4) {
        if (!hasFirstSegmentSetup) {
            return;
        }
        hasLoadFirstPluginYYSuccess = false;
        JSONObject buildSimpleContent$default = buildSimpleContent$default(this, str, ENTER_ROOM_RATE_FIRST_PLUGIN_YY_LOAD, str2, str3, str4, null, 32, null);
        if (Intrinsics.areEqual(isInsertVideo, Boolean.FALSE)) {
            ubcManager.onEvent("5153", buildSimpleContent$default);
        }
    }

    public final void doEnterFirstSegmentTemplateNotMatchError(String str, String str2, String str3, String str4) {
        if (!hasFirstSegmentSetup) {
            return;
        }
        hasTemplateMatch = false;
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_FIRST_TEMPLATE_NOT_MATCH, str2, false, str4, null, str3, null);
    }

    public final void doEnterSecondSegmentApiRequestError(String str, String str2, String str3, String str4) {
        if (isSecondSegmentShutDown() || !hasSecondSegmentSetup) {
            return;
        }
        hasSecondApiRequestSuccess = false;
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_SECOND_API_REQUEST_ERROR, str2, false, str4, null, str3, null);
    }

    public final void doEnterSecondSegmentInit(String str, String str2, String str3, String str4) {
        if (hasSecondSegmentSetup) {
            return;
        }
        secondSegmentTime = System.currentTimeMillis();
        hasSecondSegmentSetup = true;
        doEnterUbcByRequestEnter(str, "media", str2, false, str4, null, str3, null);
    }

    public final void doEnterSecondSegmentInitOtherLive(String str, String str2, String str3, String str4) {
        if (hasFirstSegmentOtherLiveRecord) {
            return;
        }
        hasFirstSegmentOtherLiveRecord = true;
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_LIVE_OTHER, str2, false, str4, null, str3, null);
    }

    public final void doEnterSecondSegmentOtherError(String str, String str2, String str3, String str4) {
        if (!hasSecondSegmentSetup) {
            return;
        }
        hasSecondOtherFunctionFail = true;
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_SECOND_OTHER_ERROR, str2, false, str4, null, str3, null);
    }

    public final void doEnterSecondSegmentPluginLoadError(String str, String str2, String str3, String str4) {
        if (!hasSecondSegmentSetup) {
            return;
        }
        hasLoadSecondPluginSuccess = false;
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_SECOND_PLUGIN_LOAD, str2, false, str4, null, str3, null);
    }

    public final void doEnterSecondSegmentSuccess(String str, String str2, String str3, String str4) {
        if (isSecondSegmentShutDown() || !hasSecondSegmentSetup) {
            return;
        }
        hasSecondSegmentFinish = true;
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_SECOND_SEGEMNT_END, str2, false, str4, null, str3, null);
    }

    public final void doEnterSecondSegmentTempateNotMatch(String str, String str2, String str3, String str4) {
        if (!hasSecondSegmentSetup) {
            return;
        }
        hasSecondTemplateMatch = false;
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_SECOND_TEMPLATE_NOT_MATCH, str2, false, str4, null, str3, null);
    }

    public final void doEnterSecondSegmentApiRequestError(String str, String str2, String str3, String str4, String str5) {
        if (isSecondSegmentShutDown() || !hasSecondSegmentSetup) {
            return;
        }
        hasSecondApiRequestSuccess = false;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_name", str5);
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_SECOND_API_REQUEST_ERROR, str2, false, str4, null, str3, jSONObject);
    }

    public final void doEnterUbcByRequestEnter(String str, String str2, String str3, String str4, String str5) {
        JSONObject buildSimpleContent$default = buildSimpleContent$default(this, str, str2, str3, str4, str5, null, 32, null);
        if (Intrinsics.areEqual(isInsertVideo, Boolean.FALSE)) {
            ubcManager.onEvent("5153", buildSimpleContent$default);
        }
    }

    public final void doEnterSecondSegmentCancel(String str, String str2) {
        if (isSecondSegmentShutDown() || !hasSecondSegmentSetup || !hasLoadSecondPluginSuccess || !hasSecondApiRequestSuccess || hasSecondOtherFunctionFail || hasSecondSegmentFinish || hasSecondCancelReported) {
            return;
        }
        hasSecondCancelReported = true;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("second_cancel_time", System.currentTimeMillis() - secondSegmentTime);
        jSONObject.put("second_load_success", "2");
        jSONObject.put("hasLoadSecondPluginSuccess", hasLoadSecondPluginSuccess);
        jSONObject.put("hasSecondApiRequestSuccess", hasSecondApiRequestSuccess);
        jSONObject.put("hasSecondOtherFunctionFail", hasSecondOtherFunctionFail);
        doEnterUbcByRequestEnter(str, ENTER_ROOM_RATE_SECOND_SEGEMNT_CANCEL, "", false, str2, 0, "", jSONObject);
    }

    public final void doEnterUbcByRequestEnter(String str, String str2, String str3) {
        doEnterUbcByRequestEnter$default(this, str, str2, "", true, str3, null, null, null, 224, null);
    }

    public final void doEnterUbcByRequestEnter(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        JSONObject buildSimpleContent$default = buildSimpleContent$default(this, str, str2, str3, str4, str5, null, str6, str7, 32, null);
        if (Intrinsics.areEqual(isInsertVideo, Boolean.FALSE)) {
            ubcManager.onEvent("5153", buildSimpleContent$default);
        }
    }

    public final void doEnterUbcByRequestEnter(String str, String str2, String str3, boolean z, String str4, Integer num, String str5, JSONObject jSONObject) {
        int i;
        Integer valueOf;
        LiveSessionService liveSessionService2 = liveSessionService;
        int i2 = 0;
        if (liveSessionService2 != null) {
            i = liveSessionService2.getSessionOrder();
        } else {
            i = 0;
        }
        if (i < 1 && ubcManager != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("from", "live");
                jSONObject2.put("type", "enter_live");
                jSONObject2.put("value", str2);
                jSONObject2.put("source", str4);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put(MixYYFakeShell.ROOM_ID_YY, str);
                jSONObject.put("status", str3);
                if (z) {
                    i2 = 1;
                }
                jSONObject.put("useCache", i2);
                if (num == null) {
                    if (str3 != null) {
                        try {
                            valueOf = Integer.valueOf(Integer.parseInt(str3));
                        } catch (Exception unused) {
                        }
                    } else {
                        valueOf = null;
                    }
                    num = valueOf;
                }
                if (num != null) {
                    jSONObject.put("error", num.intValue());
                }
                if (str5 != null) {
                    jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str5);
                }
                jSONObject.put("live_version", String.valueOf(MiniPluginUtils.INSTANCE.getComponentInstalledVersion("com.baidu.searchbox.livenps")));
                if (liveSessionService != null) {
                    jSONObject.put("zhibo_sessionid", liveSessionService.getSessionId());
                }
                jSONObject2.put("ext", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (Intrinsics.areEqual(isInsertVideo, Boolean.FALSE)) {
                ubcManager.onEvent("5153", jSONObject2);
            }
        }
    }

    public final void doEnterUbcByRequestEnterRealNet(String str, String str2, String str3, String str4, String str5) {
        boolean z;
        boolean z2;
        if (Intrinsics.areEqual("enter_live_real_req_start", str2) && !hasRecordReqStart) {
            z = true;
        } else {
            z = false;
        }
        if (Intrinsics.areEqual("enter_live_real_req_end", str2) && !hasRecordReqEnd) {
            z2 = true;
        } else {
            z2 = false;
        }
        LiveSessionService liveSessionService2 = liveSessionService;
        if (liveSessionService2 != null && liveSessionService2.getSessionOrder() < 1 && (z || z2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "live");
                jSONObject.put("type", "enter_live");
                jSONObject.put("value", str2);
                jSONObject.put("source", str5);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str);
                jSONObject2.put("status", str3);
                jSONObject2.put("useCache", 0);
                jSONObject2.put("error", 0);
                if (str4 != null) {
                    jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, str4);
                }
                if (liveSessionService != null) {
                    jSONObject2.put("zhibo_sessionid", liveSessionService.getSessionId());
                }
                jSONObject2.put("live_version", getTopPluginVersion());
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (Intrinsics.areEqual(isInsertVideo, Boolean.FALSE)) {
                ubcManager.onEvent("5153", jSONObject);
            }
        }
        if (Intrinsics.areEqual("enter_live_real_req_start", str2)) {
            hasRecordReqStart = true;
        }
        if (Intrinsics.areEqual("enter_live_real_req_end", str2)) {
            hasRecordReqEnd = true;
        }
    }
}
