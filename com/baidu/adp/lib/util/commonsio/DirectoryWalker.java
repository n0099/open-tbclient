package com.baidu.adp.lib.util.commonsio;

import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class DirectoryWalker<T> {

    /* loaded from: classes.dex */
    public class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private final int depth;
        private final File file;

        public CancelException(File file, int i) {
            this("Operation Cancelled", file, i);
        }

        public CancelException(String str, File file, int i) {
            super(str);
            this.file = file;
            this.depth = i;
        }

        public File getFile() {
            return this.file;
        }

        public int getDepth() {
            return this.depth;
        }
    }
}
