package com.baidu.searchbox.playerserver;

import androidx.annotation.Keep;
/* loaded from: classes4.dex */
public class PlayerPolicyDetailConfig implements Cloneable {
    public String configName;
    public String[] hosts;
    public String cntlId = null;
    public PCDNConfig pcdnConfig = new PCDNConfig();
    public CdnConfig cdnConfig = new CdnConfig();
    public PrefetchConfig prefetchConfig = new PrefetchConfig();
    public ClarityConfig clarityConfig = new ClarityConfig();
    public PrebootConfig prebootConfig = new PrebootConfig();

    @Keep
    /* loaded from: classes4.dex */
    public static class CdnConfig implements Cloneable {
        public int sle = 0;
        public float slRate = 0.0f;
        public float splitRate = 0.0f;
        public int level = 0;
        public String key = null;
        public int quicEnable = 1;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: clone */
        public CdnConfig m100clone() throws CloneNotSupportedException {
            CdnConfig cdnConfig = (CdnConfig) super.clone();
            cdnConfig.sle = this.sle;
            cdnConfig.slRate = this.slRate;
            cdnConfig.splitRate = this.splitRate;
            cdnConfig.level = this.level;
            cdnConfig.key = new String(this.key);
            cdnConfig.quicEnable = this.quicEnable;
            return cdnConfig;
        }

        public boolean isValidate() {
            int i = this.sle;
            if (i >= 0 && i <= 1) {
                float f = this.slRate;
                if (f >= 0.0f && f <= 16.0f) {
                    float f2 = this.splitRate;
                    if (f2 >= 0.0f && f2 <= 24.0f) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    @Keep
    /* loaded from: classes4.dex */
    public static class ClarityConfig implements Cloneable {
        public float cs480p = 0.0f;
        public float cs720p = 0.0f;
        public float cs1080p = 0.0f;
        public int level = 0;
        public String key = null;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: clone */
        public ClarityConfig m101clone() throws CloneNotSupportedException {
            ClarityConfig clarityConfig = (ClarityConfig) super.clone();
            clarityConfig.cs480p = this.cs480p;
            clarityConfig.cs720p = this.cs720p;
            clarityConfig.cs1080p = this.cs1080p;
            clarityConfig.level = this.level;
            clarityConfig.key = this.key;
            return clarityConfig;
        }
    }

    @Keep
    /* loaded from: classes4.dex */
    public static class PCDNConfig implements Cloneable {
        public int pcdnEnable = 0;
        public int p2pEnable = 0;
        public int xcdnEnable = 0;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: clone */
        public PCDNConfig m102clone() throws CloneNotSupportedException {
            PCDNConfig pCDNConfig = (PCDNConfig) super.clone();
            pCDNConfig.pcdnEnable = this.pcdnEnable;
            pCDNConfig.p2pEnable = this.p2pEnable;
            pCDNConfig.xcdnEnable = this.xcdnEnable;
            return pCDNConfig;
        }
    }

    @Keep
    /* loaded from: classes4.dex */
    public static class PrebootConfig implements Cloneable {
        public int b = 0;
        public int level = 0;
        public String key = null;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: clone */
        public PrebootConfig m103clone() throws CloneNotSupportedException {
            PrebootConfig prebootConfig = (PrebootConfig) super.clone();
            prebootConfig.b = this.b;
            prebootConfig.level = this.level;
            prebootConfig.key = this.key;
            return prebootConfig;
        }
    }

    @Keep
    /* loaded from: classes4.dex */
    public static class PrefetchConfig implements Cloneable {
        public int duration;
        public int p2pEnable;
        public int pcdnEnable;
        public int xcdnEnable;
        public int sle = 0;
        public float slRate = 0.0f;
        public float splitRate = 0.0f;
        public int level = 0;
        public String key = null;

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: clone */
        public PrefetchConfig m104clone() throws CloneNotSupportedException {
            PrefetchConfig prefetchConfig = (PrefetchConfig) super.clone();
            prefetchConfig.duration = this.duration;
            prefetchConfig.pcdnEnable = this.pcdnEnable;
            prefetchConfig.p2pEnable = this.p2pEnable;
            prefetchConfig.xcdnEnable = this.xcdnEnable;
            prefetchConfig.sle = this.sle;
            prefetchConfig.slRate = this.slRate;
            prefetchConfig.splitRate = this.splitRate;
            prefetchConfig.level = this.level;
            prefetchConfig.key = new String(this.key);
            return prefetchConfig;
        }
    }

    public PlayerPolicyDetailConfig(String str) {
        this.configName = null;
        this.configName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public PlayerPolicyDetailConfig m99clone() throws CloneNotSupportedException {
        String[] strArr;
        PlayerPolicyDetailConfig playerPolicyDetailConfig = (PlayerPolicyDetailConfig) super.clone();
        String[] strArr2 = this.hosts;
        if (strArr2 != null) {
            strArr = (String[]) strArr2.clone();
        } else {
            strArr = null;
        }
        playerPolicyDetailConfig.hosts = strArr;
        playerPolicyDetailConfig.cntlId = new String(this.cntlId);
        playerPolicyDetailConfig.pcdnConfig = this.pcdnConfig.m102clone();
        playerPolicyDetailConfig.cdnConfig = this.cdnConfig.m100clone();
        playerPolicyDetailConfig.prefetchConfig = this.prefetchConfig.m104clone();
        return playerPolicyDetailConfig;
    }

    public boolean isValidate() {
        Boolean bool;
        CdnConfig cdnConfig = this.cdnConfig;
        if (cdnConfig != null) {
            bool = Boolean.valueOf(cdnConfig.isValidate());
        } else {
            bool = null;
        }
        return bool.booleanValue();
    }
}
