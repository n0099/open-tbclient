package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.player.data.AssetConfigData;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0006\u0010\u000b\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"CONFIG_ASSERT_FILE_NAME", "", "JSON_KEY_PCDN_TYPE", "PCDN_TYPE_SEARCH_BOX", "", "dumediaConfig", "Lorg/json/JSONObject;", "getDumediaConfig", "()Lorg/json/JSONObject;", "dumediaConfig$delegate", "Lcom/baidu/searchbox/player/data/AssetConfigData;", "getPCDNType", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "CyberConfigUtils")
/* loaded from: classes4.dex */
public final class CyberConfigUtils {
    public static final String JSON_KEY_PCDN_TYPE = "pcdn_type";
    public static final int PCDN_TYPE_SEARCH_BOX = 0;
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(CyberConfigUtils.class, "dumediaConfig", "getDumediaConfig()Lorg/json/JSONObject;", 1))};
    public static final String CONFIG_ASSERT_FILE_NAME = "cyber_config.json";
    public static final AssetConfigData dumediaConfig$delegate = new AssetConfigData(CONFIG_ASSERT_FILE_NAME, false, 2, null);

    public static final JSONObject getDumediaConfig() {
        return dumediaConfig$delegate.getValue((Object) null, $$delegatedProperties[0]);
    }

    public static final int getPCDNType() {
        return getDumediaConfig().optInt(JSON_KEY_PCDN_TYPE, 0);
    }
}
