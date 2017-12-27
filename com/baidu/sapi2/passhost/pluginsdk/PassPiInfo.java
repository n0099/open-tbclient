package com.baidu.sapi2.passhost.pluginsdk;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class PassPiInfo {
    private static final String KEY_PLUGIN_CHANGE_LOG = "changeLog";
    private static final String KEY_PLUGIN_ENTRY = "entryClass";
    private static final String KEY_PLUGIN_HOST_VERSION = "hostVersion";
    private static final String KEY_PLUGIN_NAME = "name";
    private static final String KEY_PLUGIN_PID = "pid";
    private static final String KEY_PLUGIN_SHA1 = "checksum";
    private static final String KEY_PLUGIN_URL = "url";
    private static final String KEY_PLUGIN_VERSION = "version";
    public int pid = -1;
    public String version = null;
    public String url = null;
    public String sha1 = null;
    public String name = null;
    public String entryClass = null;
    public String hostVersion = null;
    public String changeLog = null;
    public String filePath = null;
    public int installState = 0;
    public boolean firstInstall = false;
    public boolean firstRun = true;

    public static PassPiInfo fromJSONObject(JSONObject jSONObject) {
        PassPiInfo passPiInfo = new PassPiInfo();
        passPiInfo.pid = Integer.parseInt(jSONObject.optString("pid"));
        passPiInfo.version = jSONObject.optString("version");
        passPiInfo.hostVersion = jSONObject.optString(KEY_PLUGIN_HOST_VERSION);
        passPiInfo.name = jSONObject.optString("name");
        passPiInfo.entryClass = jSONObject.optString(KEY_PLUGIN_ENTRY);
        passPiInfo.changeLog = jSONObject.optString(KEY_PLUGIN_CHANGE_LOG);
        passPiInfo.sha1 = jSONObject.optString(KEY_PLUGIN_SHA1);
        passPiInfo.url = jSONObject.optString("url");
        return passPiInfo;
    }
}
