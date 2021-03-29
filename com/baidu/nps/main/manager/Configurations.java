package com.baidu.nps.main.manager;

import com.baidu.nps.interfa.IAlertManager;
import com.baidu.nps.interfa.IPackageChangeNotifier;
import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.nps.interfa.ISignatureVerifier;
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.interfa.IThreadManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
/* loaded from: classes2.dex */
public class Configurations {
    public IAlertManager alertManager;
    public boolean debug;
    public IPackageChangeNotifier packageChangeNotifier;
    public IPackageGetter packageGetter;
    public IResourcesFetcher resourcesFetcher;
    public ISignatureVerifier signatureVerifier;
    public IStatisticManager statisticManager;
    public IThreadManager threadManager;
    public IWebViewDataDirectoryManager webViewDataDirectoryManager;

    /* loaded from: classes2.dex */
    public static class Builder {
        public boolean debug;
        public IAlertManager alertManager = null;
        public IPackageChangeNotifier packageChangeNotifier = null;
        public IPackageGetter packageGetter = null;
        public ISignatureVerifier signatureVerifier = null;
        public IStatisticManager statisticManager = null;
        public IThreadManager threadManager = null;
        public IResourcesFetcher resourcesFetcher = null;
        public IWebViewDataDirectoryManager webViewDataDirectoryManager = null;

        public Builder alertManager(IAlertManager iAlertManager) {
            this.alertManager = iAlertManager;
            return this;
        }

        public Configurations build() {
            return new Configurations(this.alertManager, this.packageChangeNotifier, this.packageGetter, this.signatureVerifier, this.statisticManager, this.threadManager, this.resourcesFetcher, this.webViewDataDirectoryManager, this.debug);
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder packageChangeNotifier(IPackageChangeNotifier iPackageChangeNotifier) {
            this.packageChangeNotifier = iPackageChangeNotifier;
            return this;
        }

        public Builder packageGetter(IPackageGetter iPackageGetter) {
            this.packageGetter = iPackageGetter;
            return this;
        }

        public Builder resourcesFetcher(IResourcesFetcher iResourcesFetcher) {
            this.resourcesFetcher = iResourcesFetcher;
            return this;
        }

        public Builder signatureVerifier(ISignatureVerifier iSignatureVerifier) {
            this.signatureVerifier = iSignatureVerifier;
            return this;
        }

        public Builder statisticManager(IStatisticManager iStatisticManager) {
            this.statisticManager = iStatisticManager;
            return this;
        }

        public Builder threadManager(IThreadManager iThreadManager) {
            this.threadManager = iThreadManager;
            return this;
        }

        public Builder webViewDataDirectoryManager(IWebViewDataDirectoryManager iWebViewDataDirectoryManager) {
            this.webViewDataDirectoryManager = iWebViewDataDirectoryManager;
            return this;
        }
    }

    public Configurations(IAlertManager iAlertManager, IPackageChangeNotifier iPackageChangeNotifier, IPackageGetter iPackageGetter, ISignatureVerifier iSignatureVerifier, IStatisticManager iStatisticManager, IThreadManager iThreadManager, IResourcesFetcher iResourcesFetcher, IWebViewDataDirectoryManager iWebViewDataDirectoryManager, boolean z) {
        this.alertManager = iAlertManager;
        this.packageChangeNotifier = iPackageChangeNotifier;
        this.packageGetter = iPackageGetter;
        this.signatureVerifier = iSignatureVerifier;
        this.statisticManager = iStatisticManager;
        this.threadManager = iThreadManager;
        this.resourcesFetcher = iResourcesFetcher;
        this.webViewDataDirectoryManager = iWebViewDataDirectoryManager;
        this.debug = z;
    }
}
