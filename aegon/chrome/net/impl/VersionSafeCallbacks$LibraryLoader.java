package aegon.chrome.net.impl;

import aegon.chrome.net.CronetEngine$Builder$LibraryLoader;
/* loaded from: classes4.dex */
public final class VersionSafeCallbacks$LibraryLoader extends CronetEngine$Builder$LibraryLoader {
    public final CronetEngine$Builder$LibraryLoader mWrappedLoader;

    public VersionSafeCallbacks$LibraryLoader(CronetEngine$Builder$LibraryLoader cronetEngine$Builder$LibraryLoader) {
        this.mWrappedLoader = cronetEngine$Builder$LibraryLoader;
    }

    @Override // aegon.chrome.net.CronetEngine$Builder$LibraryLoader
    public void loadLibrary(String str) {
        this.mWrappedLoader.loadLibrary(str);
    }
}
